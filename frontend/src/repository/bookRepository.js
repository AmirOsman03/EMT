import axiosInstance from "../axios/axios.js";

const bookRepository = {
    findAll: async () => {
        return await axiosInstance.get("/books");
    },
    delete: async (id) => {
        return await axiosInstance.delete(`/books/delete/${id}`);
    },
    findById: async (id) => {
        return await axiosInstance.get(`/books/${id}`);
    },
    getAllCategories: async () => {
        return await axiosInstance.get("/books/categories");
    },
    add: async (data) => {
        return await axiosInstance.post("/books/add", data);
    },
    edit: async (id, data) => {
        return await axiosInstance.put(`/books/edit/${id}`, data);
    },
};

export default bookRepository;