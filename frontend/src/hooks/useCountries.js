import {useEffect, useState} from "react";
import countryRepository from "../repository/countryRepository.js";

const initialState = {
    "countries": [],
    "loading": true,
};

const useCountries = () => {
    const [state, setState] = useState(initialState);

    useEffect(() => {
        countryRepository.
            findAll()
            .then((response) => {
                setState({
                    "countries": response.data,
                    "loading": false,
                });
            })
            .catch((error) =>
                console.log("Error fetching countries: ", error));
    })

    return state;
}

export default useCountries;