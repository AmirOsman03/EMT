import axiosInstance from "../axios/axios.js";

const authorRepository = {
    findAll: async () => {
        return await axiosInstance.get("/authors");
    },
    findById: async (id) => {
        return await axiosInstance.get(`/authors/${id}`);
    }
};

export default authorRepository;