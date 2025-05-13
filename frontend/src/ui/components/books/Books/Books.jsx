import React from 'react';
import Book from "../Book/Book.jsx"
import {Grid, Container} from "@mui/material";

const Books = ({books}) => {
    return (
        <Container>
            <Grid container spacing={{xs: 2, md: 3}}>
                {books.map((book) => (
                    <Grid key={book.id} size={{ xs: 12, sm: 6, md: 4, lg: 3 }}>
                        <Book book = {book}/>
                    </Grid>
                ))}
            </Grid>
        </Container>
    );
};

export default Books;