import React from 'react';
import {Box, Button, Chip, CircularProgress, Grid, Typography, Paper, Avatar, Stack, Rating, Breadcrumbs, Link, Container} from "@mui/material";
import {useNavigate, useParams} from "react-router";
import {ArrowBack, Category, Factory, Star, ShoppingCart, FavoriteBorder, Share} from "@mui/icons-material";
import useCountryDetails from "../../../../hooks/useCountryDetails.js";


const CountryDetails = () => {
    const {id} = useParams();
    const {country, loading} = useCountryDetails(id);
    const navigate = useNavigate();

    if (loading) {
        return (
            <Box sx={{display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '60vh'}}>
                <CircularProgress/>
            </Box>
        );
    }

    return (
        <Box>
            <Breadcrumbs aria-label="breadcrumb" sx={{mb: 3, mx: 3}}>
                <Link
                    underline="hover"
                    color="inherit"
                    href="#"
                    onClick={(e) => {
                        e.preventDefault();
                        navigate("/countries");
                    }}
                >
                    Countries
                </Link>
                <Typography color="text.primary">{country.name}</Typography>
            </Breadcrumbs>
            <Container>
                <Paper elevation={2} sx={{p: 4, borderRadius: 4}}>
                    <Grid container spacing={4}>
                        <Grid size={{xs: 12, md: 9}}>
                            <Box sx={{mb: 3}}>
                                <Typography variant="h3" gutterBottom sx={{fontWeight: 600}}>
                                    {country.name}
                                </Typography>

                                <Typography variant="h4" color="primary.main" sx={{mb: 3}}>
                                    {country.continent}
                                </Typography>



                                <Typography variant="body1" sx={{mb: 3}}>
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi consequatur culpa
                                    doloribus, enim maiores possimus similique totam ut veniam voluptatibus. Adipisci
                                    consequatur, cum dolorem eaque enim explicabo fugit harum, id laborum non totam ut!
                                    Architecto assumenda deserunt doloribus ducimus labore magnam officiis sunt. Autem
                                    culpa
                                    eaque obcaecati quasi, quo vitae.
                                </Typography>
                            </Box>
                        </Grid>
                        <Grid size={12} display="flex" justifyContent="space-between">
                            <Stack direction="row" spacing={2}>
                                <Button
                                    variant="contained"
                                    color="primary"
                                    startIcon={<ShoppingCart/>}
                                    size="large"
                                >
                                    Add to Cart
                                </Button>
                                <Button
                                    variant="outlined"
                                    color="secondary"
                                    startIcon={<FavoriteBorder/>}
                                >
                                    Wishlist
                                </Button>
                                <Button
                                    variant="outlined"
                                    startIcon={<Share/>}
                                >
                                    Share
                                </Button>
                            </Stack>
                            <Button
                                variant="outlined"
                                startIcon={<ArrowBack/>}
                                onClick={() => navigate("/countries")}
                            >
                                Back to countries
                            </Button>
                        </Grid>
                    </Grid>
                </Paper>
            </Container>
        </Box>
    );
};

export default CountryDetails;
