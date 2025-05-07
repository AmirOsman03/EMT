import axiosInstance from "../axios/axios.js";

const authorRepository = {
    findAll: async () => {
        return await axiosInstance.get("/authors");
    },
};

export default authorRepository;