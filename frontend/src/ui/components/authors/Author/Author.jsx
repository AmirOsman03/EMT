import {Box, Button, Card, CardActions, CardContent, Typography} from "@mui/material";
import InfoIcon from "@mui/icons-material/Info";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";
import {useNavigate} from "react-router";
import {useState} from "react";
import EditAuthorDialog from "../EditAuthorDialog/EditAuthorDialog.jsx";
import DeleteAuthorDialog from "../DeleteAuthorDialog/DeleteAuthorDialog.jsx";

const Author = ({author, onDelete, onEdit}) => {
    const [deleteAuthorDialogOpen, setDeleteAuthorDialogOpen] = useState(false);
    const [editAuthorDialogOpen, setEditAuthorDialogOpen] = useState(false);
    const navigate = useNavigate();

    return (
        <>
            <Card sx={{boxShadow: 3, borderRadius: 2, p: 1}}>
                <CardContent>
                    <Typography variant="h5" fontWeight={"bolder"}>{author.name} {author.surname}</Typography>
                    <Typography variant="subtitle1" color="text.secondary" gutterBottom>
                        <strong>From:</strong> {author.country.name}
                    </Typography>
                </CardContent>
                <CardActions sx={{justifyContent: "space-between"}}>
                    <Button size="small"
                            color="info"
                            startIcon={<InfoIcon/>}
                            onClick={() => navigate(`/authors/${author.id}`)}>
                        Info
                    </Button>
                    <Box>
                        <Button size="small"
                                color="warning"
                                startIcon={<EditIcon/>}
                                sx={{mr: "0.25rem"}}
                            onClick={() => setEditAuthorDialogOpen(true)}
                        >
                            Edit
                        </Button>
                        <Button size="small" color="error" startIcon={<DeleteIcon/>}
                                onClick={() => setDeleteAuthorDialogOpen(true)}>
                            Delete
                        </Button>
                    </Box>
                </CardActions>
            </Card>

            <EditAuthorDialog
                open={editAuthorDialogOpen}
                onClose={() => setEditAuthorDialogOpen(false)}
                author={author}
                onEdit={onEdit}
            />

            <DeleteAuthorDialog
                open={deleteAuthorDialogOpen}
                onClose={() => setDeleteAuthorDialogOpen(false)}
                author={author}
                onDelete={onDelete}
            />

        </>
    );
};

export default Author;