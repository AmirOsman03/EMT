import React from 'react';
import useCountries from "../../../hooks/useCountries.js";
import {Box, CircularProgress} from "@mui/material";
import Countries from "../../components/countries/Countries/Countries.jsx";
import "../BooksPage/BooksPage.css"

const CountriesPage = () => {
    const {countries, loading} = useCountries();

    return (
        <Box className="books-box">
            {loading && (
                <Box className="progress-box">
                    <CircularProgress/>
                </Box>
            )}
            {!loading && <Countries countries={countries} />}
        </Box>
    );
};

export default CountriesPage;