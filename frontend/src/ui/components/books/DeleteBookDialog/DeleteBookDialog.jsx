import { Dialog, DialogTitle, DialogContent, DialogActions, Button } from "@mui/material";

const DeleteBookDialog = ({ open, onClose, book, onDelete }) => {
    if (!book) {
        return null; // или прикажи Loading...
    }

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Delete Book</DialogTitle>
            <DialogContent>
                Are you sure you want to delete <strong>{book.name}</strong>?
            </DialogContent>
            <DialogActions>
                <Button onClick={onClose}>Cancel</Button>
                <Button onClick={() => onDelete(book.id)} color="error">
                    Delete
                </Button>
            </DialogActions>
        </Dialog>
    );
};

export default DeleteBookDialog;
