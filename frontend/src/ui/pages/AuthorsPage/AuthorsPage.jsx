import React, {useState} from 'react';
import {Box, Button, CircularProgress} from "@mui/material";
import Authors from "../../components/authors/Authors/Authors.jsx";
import useAuthors from "../../../hooks/useAuthors.js";
import "../BooksPage/BooksPage.css"
import AddAuthorDialog from "../../components/authors/AddAuthorDialog/AddAuthorDialog.jsx";

const AuthorsPage = () => {
    const {authors, loading, onDelete, onAdd, onEdit} = useAuthors();
    const [addAuthorDialogOpen, setAddAuthorDialogOpen] = useState(false);

    return (
        <>
            <Box className="books-box">
                {loading && (
                    <Box className="progress-box">
                        <CircularProgress/>
                    </Box>
                )}
                {!loading &&
                    <>
                        <Box sx={{display: "flex", justifyContent: "flex-end", mb: 2}}>
                            <Button variant="contained" color="primary" onClick={() => setAddAuthorDialogOpen(true)}>
                                Add Author
                            </Button>
                        </Box>
                        <Authors authors={authors} onEdit={onEdit} onDelete={onDelete}/>
                    </>}
            </Box>
            <AddAuthorDialog
                open={addAuthorDialogOpen}
                onClose={() => setAddAuthorDialogOpen(false)}
                onAdd={onAdd}
            />
        </>
    );
};

export default AuthorsPage;