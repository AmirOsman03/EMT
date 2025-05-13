import axiosInstance from "../axios/axios.js";

const countryRepository = {
    findAll: async () => {
        return await axiosInstance.get("/countries");
    },
    delete: async (id) => {
        return await axiosInstance.delete(`/countries/delete/${id}`);
    },
    findById: async (id) => {
        return await axiosInstance.get(`/countries/${id}`);
    },

    add: async (data) => {
        return await axiosInstance.post("/countries/add", data);
    },
    edit: async (id, data) => {
        return await axiosInstance.put(`/countries/edit/${id}`, data);
    },
}

export default countryRepository;