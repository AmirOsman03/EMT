import React from 'react';
import useBooks from "../../../hooks/useBooks.js";
import Books from "../../components/books/Books/Books.jsx"
import {Box, CircularProgress} from "@mui/material";
import "./BooksPage.css"

const BooksPage = () => {
    const {books, loading} = useBooks();

    return (
        <Box className="books-box">
            {loading && (
                <Box className="progress-box">
                    <CircularProgress/>
                </Box>
            )}
            {!loading && <Books books={books} />}
        </Box>
    );
};

export default BooksPage;