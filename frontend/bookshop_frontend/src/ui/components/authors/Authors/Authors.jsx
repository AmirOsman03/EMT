import React from 'react';
import {Grid} from "@mui/material";
import Author from "../Author/Author.jsx";

const Authors = ({authors}) => {
    return (
        <Grid container spacing={{xs: 2, md: 3}}>
            {authors.map((author) => (
                <Grid key={author.id} size={{ xs: 12, sm: 6, md: 4, lg: 3 }}>
                    <Author author = {author}/>
                </Grid>
            ))}
        </Grid>
    );
};

export default Authors;