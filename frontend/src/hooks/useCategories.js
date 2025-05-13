import { useEffect, useState } from 'react';
import bookRepository from "../repository/bookRepository.js";

const useCategories = () => {
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        bookRepository
            .getAllCategories()
            .then((response) => {
                setCategories(response.data);
            })
            .catch((error) => console.log("Error fetching categories: ", error));
    }, []);

    return categories;
};

export default useCategories;
