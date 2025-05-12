import axiosInstance from "../axios/axios.js";

const countryRepository = {
    findAll: async () => {
        return await axiosInstance.get("/countries");
    },
}

export default countryRepository;