import React from 'react';
import {useNavigate, useParams} from "react-router";
import {
    Box,
    Breadcrumbs,
    Button,
    CircularProgress,
    Container,
    Grid,
    Link,
    Paper,
    Stack,
    Typography
} from "@mui/material";
import {ArrowBack, FavoriteBorder, Share, ShoppingCart} from "@mui/icons-material";
import useAuthorDetails from "../../../../hooks/useAuthorDetails.js";

const AuthorDetails = () => {
    const {id} = useParams();
    const {author, loading} = useAuthorDetails(id);
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
                        navigate("/authors");
                    }}
                >
                    Authors
                </Link>
                <Typography color="text.primary">{author?.name}</Typography>
            </Breadcrumbs>
            <Container>
                <Paper elevation={2} sx={{p: 4, borderRadius: 4}}>
                    <Grid container spacing={4}>
                        <Grid size={{xs: 12, md: 9}}>
                            <Box sx={{mb: 3}}>
                                <Typography variant="h3" gutterBottom sx={{fontWeight: 600}}>
                                    {author.name} {author.surname}
                                </Typography>

                                <Typography variant="h4" color="primary.main" sx={{mb: 3}}>
                                    <strong>Country:</strong> {author.country.name}
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
                                onClick={() => navigate("/authors")}
                            >
                                Back to Books
                            </Button>
                        </Grid>
                    </Grid>
                </Paper>
            </Container>
        </Box>
    );
};

export default AuthorDetails;