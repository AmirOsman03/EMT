import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import bookRepository from '../../../repository/bookRepository.js';
import {Box, Typography, CircularProgress, CardContent, CardActions, Button, Card} from '@mui/material';
import InfoIcon from "@mui/icons-material/Info";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";

const BookDetailsPage = () => {
    const { id } = useParams();
    const [book, setBook] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        bookRepository.findById(id)
            .then(response => {
                setBook(response.data);
                setLoading(false);
            })
            .catch(error => {
                console.log(error);
                setLoading(false);
            });
    }, [id]);

    if (loading) {
        return <CircularProgress />;
    }

    if (!book) {
        return <Typography>Book not found</Typography>;
    }

    return (
        <Box
            display="flex"
            justifyContent="center"
            alignItems="center"
            minHeight="50vh"
        >
            <Card sx={{ boxShadow: 3, borderRadius: 2, p: 2, width: "100%", maxWidth: 400 }}>
                <CardContent>
                    <Typography variant="h5" fontWeight={"bolder"}>{book.name}</Typography>
                    <Typography variant="subtitle1">{book.author}</Typography>
                    <Typography variant="subtitle2" sx={{ textAlign: "right" }}>
                        {book.availableCopies} copies available
                    </Typography>
                </CardContent>
            </Card>
        </Box>
    );
};

export default BookDetailsPage;
