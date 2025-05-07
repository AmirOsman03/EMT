import {useEffect, useState} from 'react';
import authorRepository from "../repository/authorRepository.js";

const initialState = {
    "authors": [],
    "loading": true,
};

const useAuthors = () => {
    const [state, setState] = useState(initialState);

    useEffect(() => {
        authorRepository
            .findAll()
            .then((response) => {
                setState({
                    "authors": response.data,
                    "loading": false,
                });
            })
            .catch((error) => console.log(error));
    }, []);

    return state;
};

export default useAuthors;