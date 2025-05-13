import {useEffect, useState} from 'react';
import bookRepository from "../repository/bookRepository.js";

const initialState = {
    "book": [],
    "loading": true,
};

const useBookDetails = (id) => {
    const [state, setState] = useState(initialState);

    useEffect(() => {
        bookRepository
            .findById(id)
            .then((response) => {
                console.log("Book details:", response.data); // <- ова ќе ти покаже структурата
                setState({
                    book: response.data,
                    loading: false,
                });
            })
            .catch((error) => console.log(error));
    }, [id])

    return state;
};

export default useBookDetails;