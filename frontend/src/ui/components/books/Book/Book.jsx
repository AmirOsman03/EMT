import React, { useEffect, useState } from 'react';
import {Box, Button, Card, CardActions, CardContent, Typography} from "@mui/material";
import InfoIcon from '@mui/icons-material/Info';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import axiosInstance from '../../../../axios/axios.js';

const Book = ({ book }) => {
    const [author, setAuthor] = useState(null);

    useEffect(() => {
        axiosInstance.get(`/authors/${book.author}`)
            .then((response) => {
                setAuthor(response.data);
            })
            .catch((error) => console.log("Error fetching the author: ", error));
    }, [book.author]);

    return (
        <Card sx={{boxShadow: 3, borderRadius: 2, p: 1}}>
            <CardContent>
                <Typography variant="h5" fontWeight="bolder">
                    {book.name}
                </Typography>
                <Typography variant="subtitle1" color="text.secondary" gutterBottom>
                    <strong>Author:</strong> {author ? `${author.name} ${author.surname}` : "Loading..."}
                </Typography>
                <Typography variant="subtitle1" color="text.secondary" gutterBottom>
                    <strong>Category:</strong> {book.category ? `${book.category}` : "Loading..."}
                </Typography>
            </CardContent>
            <CardActions sx={{justifyContent: "space-between"}}>
                <Button size="small" color="info" startIcon={<InfoIcon/>}>Info</Button>
                <Box>
                    <Button size="small" color="warning" startIcon={<EditIcon/>} sx={{mr: "0.25rem"}}>Edit</Button>
                    <Button size="small" color="error" startIcon={<DeleteIcon/>}>Delete</Button>
                </Box>
            </CardActions>
        </Card>
    );
};

export default Book;
