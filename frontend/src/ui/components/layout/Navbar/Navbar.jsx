import React from 'react';
import {Link} from 'react-router';
import {AppBar, Box, Button, Toolbar, Typography} from "@mui/material";

const Navbar = () => {
    return (
        <AppBar position="static" sx={{mb: 5}}>
            <Toolbar>

                <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
                    Book Shop
                </Typography>

                <Box>
                    <Button color="inherit" component={Link} to="/">Home</Button>
                    <Button color="inherit" component={Link} to="/books">Books</Button>
                    <Button color="inherit" component={Link} to="/authors">Authors</Button>
                    <Button color="inherit" component={Link} to="/countries">Countries</Button>
                </Box>
            </Toolbar>
        </AppBar>
    );
};

export default Navbar;