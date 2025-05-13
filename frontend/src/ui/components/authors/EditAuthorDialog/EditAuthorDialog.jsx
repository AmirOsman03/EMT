import React, {useEffect, useState} from "react";

import {
    Button, CircularProgress,
    Dialog,
    DialogActions,
    DialogContent,
    DialogTitle,
    FormControl,
    InputLabel, MenuItem, Select,
    TextField
} from "@mui/material";
import useCountries from "../../../../hooks/useCountries.js";
import Author from "../Author/Author.jsx";

const initialFormData = {
    "name": "",
    "surname": "",
    "country": "",
};

const EditAuthorDialog = ({open, onClose, author, onEdit}) => {
    const [formData, setFormData] = useState(initialFormData);
    const { countries, loading } = useCountries();

    const handleChange = (event) => {
        const {name, value} = event.target;
        setFormData({...formData, [name]: value});
    };

    const handleSubmit = () => {
        onEdit(author.id, formData);
        setFormData(formData);
        onClose();
    };

    useEffect(() => {
        if (author) {
            setFormData({
                name: author.name || "",
                surname: author.surname || "",
                country: author.country?.id || "", // ако е објект
            });
        }
    }, [author]);

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Add Author</DialogTitle>
            <DialogContent>
                <TextField
                    margin="dense"
                    label="Name"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                    fullWidth
                />

                <TextField
                    margin="dense"
                    label="Surname"
                    name="surname"
                    value={formData.surname}
                    onChange={handleChange}
                    fullWidth
                />

                <FormControl fullWidth margin="dense">
                    <InputLabel>Country</InputLabel>
                    <Select
                        name="country"
                        value={formData.country}
                        onChange={handleChange}
                        label="Country"
                        variant="outlined"
                    >
                        {loading ? (
                            <MenuItem value="">
                                <CircularProgress size={24} />
                            </MenuItem>
                        ) : (
                            countries.map((country) => (
                                <MenuItem key={country.id} value={country.id}>
                                    {country.name}
                                </MenuItem>
                            ))
                        )}
                    </Select>
                </FormControl>
            </DialogContent>
            <DialogActions>
                <Button onClick={onClose}>Cancel</Button>
                <Button onClick={handleSubmit} variant="contained" color="primary">Add</Button>
            </DialogActions>
        </Dialog>
    );
};

export default EditAuthorDialog;