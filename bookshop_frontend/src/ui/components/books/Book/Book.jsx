import React from 'react';
import InfoIcon from '@mui/icons-material/Info';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import {Box, Button, Card, CardActions, CardContent, Typography} from "@mui/material";
import {useNavigate} from 'react-router-dom';

const Book = ({book}) => {
    const navigate = useNavigate();

    return (
        <Card
            sx={{
                boxShadow: 4,
                borderRadius: 3,
                p: 1,
                backgroundColor: "#f9f9f9",
                display: "flex",
                flexDirection: "column",
                justifyContent: "space-between",
                minHeight: "200px",
            }}
        >
            <CardContent>
                <Typography variant="h5" fontWeight="bold" gutterBottom color="dark">
                    {book.name}
                </Typography>
                <Typography variant="subtitle1" color="text.secondary" gutterBottom>
                    Author: {book.author}
                </Typography>
                <Typography variant="body2" color="text.secondary" textAlign="right">
                    {book.availableCopies} copies available
                </Typography>
            </CardContent>

            <CardActions sx={{
                justifyContent: "space-between",
                mt: 1,
            }}>
                <Button
                    size="small"
                    variant="outlined"
                    color="info"
                    startIcon={<InfoIcon/>}
                    onClick={() => navigate(`/books/${book.id}`)}
                >
                    Info
                </Button>

                <Button
                    size="small"
                    variant="outlined"
                    color="warning"
                    startIcon={<EditIcon/>}
                >
                    Edit
                </Button>

                <Button
                    size="small"
                    variant="outlined"
                    color="error"
                    startIcon={<DeleteIcon/>}
                >
                    Delete
                </Button>
            </CardActions>
        </Card>
    );
};

export default Book;
