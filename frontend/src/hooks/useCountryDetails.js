import {useEffect, useState} from 'react';
import countryRepository from "../repository/countryRepository.js";

const initialState = {
    "countries": [],
    "loading": true,
};

const useCountryDetails = (id) => {
    const [state, setState] = useState(initialState);

    useEffect(() => {
        countryRepository
            .findById(id)
            .then((response) => {
                console.log("Country details:", response.data); // <- ова ќе ти покаже структурата
                setState({
                    country: response.data,
                    loading: false,
                });
            })
            .catch((error) => console.log(error));
    }, [id])

    return state;
};

export default useCountryDetails;