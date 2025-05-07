import React from 'react';
import {Box, CircularProgress} from "@mui/material";
import Books from "../../components/books/Books/Books.jsx";
import useBooks from "../../../hooks/useBooks.js";

const BooksPage = () => {
    const {books, loading} = useBooks();

    return (
        <Box className="books-box">
            {loading && (
                <Box className="progress-box">
                    <CircularProgress/>
                </Box>
            )}
            {!loading && <Books books={books}/>}
        </Box>
    );
};

export default BooksPage;