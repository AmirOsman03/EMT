import React, {useState} from 'react';
import useBooks from "../../../hooks/useBooks.js";
import Books from "../../components/books/Books/Books.jsx"
import {Box, Button, CircularProgress} from "@mui/material";
import "./BooksPage.css"
import AddBookDialog from "../../components/books/AddBookDialog/AddBookDialog.jsx";

const BooksPage = () => {
    const {books, loading, onDelete, onAdd, onEdit} = useBooks();
    const [addBookDialogOpen, setAddBookDialogOpen] = useState(false);


    return (
        <>
            <Box className="products-box">
                {loading && (
                    <Box className="progress-box">
                        <CircularProgress/>
                    </Box>
                )}
                {!loading &&
                    <>
                        <Box sx={{display: "flex", justifyContent: "flex-end", mb: 2}}>
                            <Button variant="contained" color="primary" onClick={() => setAddBookDialogOpen(true)}>
                                Add Book
                            </Button>
                        </Box>
                        <Books books={books} onEdit={onEdit} onDelete={onDelete} />
                    </>}
            </Box>
            <AddBookDialog
                open={addBookDialogOpen}
                onClose={() => setAddBookDialogOpen(false)}
                onAdd={onAdd}
            />
        </>

    );
};

export default BooksPage;