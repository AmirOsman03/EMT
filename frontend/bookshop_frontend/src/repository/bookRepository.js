import axiosInstance from "../axios/axios.js";

const bookRepository = {
    findAll: async () => {
        return await axiosInstance.get("/books");
    },
    findById: (id) => {
        return axiosInstance.get(`/books/${id}`);
    }
};

export default bookRepository;