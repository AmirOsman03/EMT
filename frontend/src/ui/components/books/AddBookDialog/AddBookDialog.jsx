import React, {useState} from 'react';
import {Button, CircularProgress, Dialog, DialogActions,DialogContent, DialogTitle, FormControl, InputLabel, MenuItem, Select, TextField} from "@mui/material";
import useCategories from "../../../../hooks/useCategories.js";
import useAuthors from "../../../../hooks/useAuthors.js";


const initialFormData = {
    "name": "",
    "category": "",
    "author": "",
    "availableCopies": "",
    "renter": false,
}

const AddBookDialog = ({open, onClose, onAdd}) => {
    const [formData, setFormData] = useState(initialFormData);
    const categories = useCategories();
    const { authors, loading } = useAuthors();


    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = () => {
        onAdd(formData);
        setFormData(initialFormData);
        onClose();
    };

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Add Book</DialogTitle>
            <DialogContent>
                <TextField
                    margin="dense"
                    label="Name"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                    fullWidth
                />
                <FormControl fullWidth margin="dense">
                    <InputLabel>Category</InputLabel>
                    <Select
                        name="category"
                        value={formData.category}
                        onChange={handleChange}
                        label="Category"
                        variant="outlined">
                        {categories.map((cat, index) => (
                            <MenuItem key={index} value={cat}>{cat}</MenuItem>
                        ))}
                    </Select>
                </FormControl>
                <FormControl fullWidth margin="dense">
                    <InputLabel>Author</InputLabel>
                    <Select
                        name="author"
                        value={formData.author}
                        onChange={handleChange}
                        label="Author"
                        variant="outlined"
                    >
                        {loading ? (
                            <MenuItem value="">
                                <CircularProgress size={24} />
                            </MenuItem>
                        ) : (
                            authors.map((author) => (
                                <MenuItem key={author.id} value={author.id}>
                                    {author.name} {author.surname}
                                </MenuItem>
                            ))
                        )}
                    </Select>
                </FormControl>

                <TextField
                    margin="dense"
                    label="AvailableCopies"
                    name="availableCopies"
                    type="number"
                    value={formData.availableCopies || 0}
                    onChange={handleChange}
                    fullWidth
                />
            </DialogContent>
            <DialogActions>
                <Button onClick={onClose}>Cancel</Button>
                <Button onClick={handleSubmit} variant="contained" color="primary">Add</Button>
            </DialogActions>
        </Dialog>
    );
};

export default AddBookDialog;