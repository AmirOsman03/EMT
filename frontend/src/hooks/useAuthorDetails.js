import React, {useEffect, useState} from 'react';
import authorRepository from "../repository/authorRepository.js";

const initialState = {
    "author": [],
    "loading": true,
};

const useAuthorDetails = (id) => {
    const [state, setState] = useState(initialState);

    useEffect(() => {
        if (id) {
            authorRepository
                .findById(id)
                .then((response) => {
                    console.log("Author details: ", response.data);
                    setState({
                        author: response.data,
                        loading: false,
                    });
                })
                .catch((error) => {
                    console.error("Error fetching author details: ", error);
                    setState({
                        author: null,
                        loading: false,
                    });
                });
        }
    }, [id])

    return state;
};

export default useAuthorDetails;