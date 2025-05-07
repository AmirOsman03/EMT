import React from 'react';
import {Box, Container, Typography} from "@mui/material";

const HomePage = () => {
    return (
        <Box sx={{m: 0, p: 0}}>
            <Container maxWidth="xl" sx={{mt: 3, py: 3}}>
                <Typography variant="h2"
                            gutterBottom
                            align={"left"}
                            fontWeight={"bolder"}
                            width={"600px"}

                >
                    WELCOME TO BOOK SHOP
                </Typography>
                <Typography variant="body1"
                            sx={{mb: 4}}
                            align={"left"}
                            width={"350px"}
                            fontWeight={"bold"}
                >
                    A house to millions of digital and non-digital books from around the world
                </Typography>
            </Container>
        </Box>
    );
};

export default HomePage;