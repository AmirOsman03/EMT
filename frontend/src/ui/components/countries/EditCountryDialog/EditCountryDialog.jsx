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

const initialFormData = {
    "name": "",
    "continent": "",

}

const EditCountryDialog = ({open, onClose, country, onEdit}) => {
    const [formData, setFormData] = useState(initialFormData);

    const handleChange = (event) => {
        const {name, value} = event.target;
        setFormData({...formData, [name]: value});
    };

    const handleSubmit = () => {
        onEdit(country.id, formData);
        setFormData(formData);
        onClose();
    };

    useEffect(() => {
        if (country) {
            setFormData({
                country: country?.id || "",
                name: country.name || "",
                continent: country.continent || "",

            });
        }
    }, [country]);

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Add Country</DialogTitle>
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
                    label="continent"
                    name="continent"
                    value={formData.continent }
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

export default EditCountryDialog;
