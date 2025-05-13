import {Box, Button, Card, CardActions, CardContent, Typography} from "@mui/material";
import InfoIcon from '@mui/icons-material/Info';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import {useState} from "react";
import DeleteBookDialog from "../DeleteBookDialog/DeleteBookDialog.jsx";
import {useNavigate} from "react-router";
import EditBookDialog from "../EditBookDialog/EditBookDialog.jsx";

const Book = ({book, onDelete, onEdit}) => {
    const [deleteBookDialogOpen, setDeleteBookDialogOpen] = useState(false);
    const [editBookDialogOpen, setEditBookDialogOpen] = useState(false);
    const navigate = useNavigate();

    return (
        <>
            <Card sx={{boxShadow: 3, borderRadius: 2, p: 1}}>
                <CardContent>
                    <Typography variant="h5" fontWeight="bolder">
                        {book.name}
                    </Typography>
                    <Typography variant="subtitle1" color="text.secondary" gutterBottom>
                        <strong>Author:</strong> {book.author.name} {book.author.surname}
                    </Typography>
                    <Typography variant="subtitle1" color="text.secondary" gutterBottom>
                        <strong>Category:</strong> {book.category}
                    </Typography>
                </CardContent>
                <CardActions sx={{justifyContent: "space-between"}}>
                    <Button size="small"
                            color="info"
                            startIcon={<InfoIcon/>}
                            onClick={() => navigate(`/books/${book.id}`)}>
                        Info
                    </Button>
                    <Box>
                        <Button size="small"
                                color="warning"
                                startIcon={<EditIcon/>}
                                sx={{mr: "0.25rem"}}
                                onClick={() => setEditBookDialogOpen(true)}
                        >
                            Edit
                        </Button>
                        <Button size="small" color="error" startIcon={<DeleteIcon/>}
                                onClick={() => setDeleteBookDialogOpen(true)}>
                            Delete
                        </Button>
                    </Box>
                </CardActions>
            </Card>

            <EditBookDialog
                open={editBookDialogOpen}
                onClose={() => setEditBookDialogOpen(false)}
                book={book}
                onEdit={onEdit}
            />

            <DeleteBookDialog
                open={deleteBookDialogOpen}
                onClose={() => setDeleteBookDialogOpen(false)}
                book={book}
                onDelete={onDelete}
            />
        </>
    );
};

export default Book;
