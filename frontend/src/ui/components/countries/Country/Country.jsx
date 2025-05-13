import React, {useState} from 'react';
import {Box, Button, Card, CardActions, CardContent, Typography} from "@mui/material";
import InfoIcon from "@mui/icons-material/Info";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";
import DeleteCountryDialog from "../DeleteCountryDialog/DeleteCountryDialog.jsx";
import EditCountryDialog from "../EditCountryDialog/EditCountryDialog.jsx";
import {useNavigate} from "react-router";

const Country = ({country,onDelete,onEdit}) => {
    const navigate = useNavigate();

    const [deleteCountryDialogOpen, setdeleteCountryDialogOpen] = useState(false);
    const [editCountryDialogOpen, setEditCountryDialogOpen] = useState(false);

    return (
        <>
        <Card sx={{boxShadow: 3, borderRadius: 2, p: 1}}>
            <CardContent>
                <Typography variant="h5" fontWeight="bolder">
                    {country.name}
                </Typography>
                <Typography variant="subtitle1" color="text.secondary" gutterBottom>
                    <strong>Continent:</strong> {country.continent}
                </Typography>
            </CardContent>
            <CardActions sx={{justifyContent: "space-between"}}>
                <Button
                    size="small"
                        color="info"
                        startIcon={<InfoIcon/>}
                    onClick={() => navigate(`/countries/${country.id}`)}>

                    Info
                </Button>

                <Box>
                    <Button size="small"
                            color="warning"
                            startIcon={<EditIcon/>}
                            sx={{mr: "0.25rem"}}
                            onClick={() => setEditCountryDialogOpen(true)}

                    >
                        Edit
                    </Button>

                    <Button size="small" color="error" startIcon={<DeleteIcon/>}
                            onClick={() => setdeleteCountryDialogOpen(true)}>
                        Delete
                    </Button>

                </Box>
            </CardActions>
        </Card>

            <DeleteCountryDialog
                open={deleteCountryDialogOpen}
                onClose={() => setdeleteCountryDialogOpen(false)}
                country={country}
                onDelete={onDelete}
            />
            <EditCountryDialog
                open={editCountryDialogOpen}
                onClose={() => setEditCountryDialogOpen(false)}
                country={country}
                onEdit={onEdit}
            />
        </>
    );
};

export default Country;
