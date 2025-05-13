import React from 'react';
import {Container, Grid} from "@mui/material";
import Country from "../Country/Country.jsx";

const Countries = ({countries,onDelete,onEdit}) => {
    return (
        <Container>
            <Grid container spacing={{xs: 2, md: 3}}>
                {countries.map((country) => (
                    <Grid key={country.id} size={{ xs: 12, sm: 6, md: 4, lg: 3 }}>
                        <Country country = {country} onDelete={onDelete} onEdit={onEdit} />
                    </Grid>
                ))}
            </Grid>
        </Container>
    );
};

export default Countries;
