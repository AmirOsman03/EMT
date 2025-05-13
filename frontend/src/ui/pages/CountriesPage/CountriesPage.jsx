import React, {useState} from 'react';
import useCountries from "../../../hooks/useCountries.js";
import {Box, Button, CircularProgress} from "@mui/material";
import Countries from "../../components/countries/Countries/Countries.jsx";
import "../BooksPage/BooksPage.css"
import AddCountryDialog from "../../components/countries/AddCountryDialog/AddCountryDialog.jsx";

const CountriesPage = () => {
    const {countries, loading,onDelete,onEdit,onAdd} = useCountries();

    const [addCountryDialogOpen, setAddCountryDialogOpen] = useState(false);


    return (
        <>
            <Box className="books-box">
                {loading && (
                    <Box className="progress-box">
                        <CircularProgress/>
                    </Box>
                )}
                <Box sx={{display: "flex", justifyContent: "flex-end", mb: 2}}>
                    <Button variant="contained" color="primary" onClick={() => setAddCountryDialogOpen(true)}>
                        Add Country
                    </Button>
                </Box>a
                <Countries countries={countries} onDelete={onDelete} onEdit={onEdit} />
            </Box>

            <AddCountryDialog
                open={addCountryDialogOpen}
                onClose={() => setAddCountryDialogOpen(false)}
                onAdd={onAdd}
            />
        </>
    );

};

export default CountriesPage;