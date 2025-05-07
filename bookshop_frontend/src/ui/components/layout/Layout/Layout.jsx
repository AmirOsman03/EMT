import React from 'react';
import {Box, Container} from "@mui/material";
import Header from "../Header/Header.jsx";
import {Outlet} from "react-router-dom";
import "./Layout.css"

const Layout = () => {
    return (
        <Box className='layout-box'>
            <Header/>
            <Container className='outer-container' sx={{my: 2}} maxWidth={"lg"}>
                <Outlet/>
            </Container>
        </Box>
    );
};

export default Layout;