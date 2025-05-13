import axiosInstance from "../axios/axios.js";

const bookRepository = {
    findAll: async () => {
        return await axiosInstance.get("/books");
    },
};

export default bookRepository;