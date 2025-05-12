import React from 'react';
import {Box, CircularProgress} from "@mui/material";
import Authors from "../../components/authors/Authors/Authors.jsx";
import useAuthors from "../../../hooks/useAuthors.js";
import "../BooksPage/BooksPage.css"

const AuthorsPage = () => {
    const {authors, loading} = useAuthors();

    return (
        <Box className="books-box">
            {loading && (
                <Box className="progress-box">
                    <CircularProgress/>
                </Box>
            )}
            {!loading && <Authors authors={authors}/>}
        </Box>
    );
};

export default AuthorsPage;