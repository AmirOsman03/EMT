import {useEffect, useState} from 'react';
import bookRepository from "../repository/bookRepository.js";

const initialState = {
    "books": [],
    "loading": true,
};

const useBooks = () => {
    const [state, setState] = useState(initialState);

    useEffect(() => {
        bookRepository
            .findAll()
            .then((response) => {
                setState({
                    "books": response.data,
                    "loading": false,
                });
            })
            .catch((error) => console.log(error));
    }, []);

    return state;
};

export default useBooks;