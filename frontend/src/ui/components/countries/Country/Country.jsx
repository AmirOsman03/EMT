import React from 'react';
import {Box, Button, Card, CardActions, CardContent, Typography} from "@mui/material";
import InfoIcon from "@mui/icons-material/Info";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";

const Country = ({country}) => {
    return (
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
                <Button size="small" color="info" startIcon={<InfoIcon/>}>Info</Button>
                <Box>
                    <Button size="small" color="warning" startIcon={<EditIcon/>} sx={{mr: "0.25rem"}}>Edit</Button>
                    <Button size="small" color="error" startIcon={<DeleteIcon/>}>Delete</Button>
                </Box>
            </CardActions>
        </Card>
    );
};

export default Country;