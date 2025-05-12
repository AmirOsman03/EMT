import React from 'react';
import {BrowserRouter, Routes, Route} from "react-router";
import HomePage from "./ui/pages/HomePage/HomePage.jsx";
import BooksPage from "./ui/pages/BooksPage/BooksPage.jsx";
import Navbar from "./ui/components/layout/Navbar/Navbar.jsx";
import AuthorsPage from "./ui/pages/AuthorsPage/AuthorsPage.jsx";
import CountriesPage from "./ui/pages/CountriesPage/CountriesPage.jsx";

const App = () => {
    return (
        <BrowserRouter>
            <Navbar/>
            <Routes>
                <Route index element={<HomePage/>}/>
                <Route path="books" element={<BooksPage/>}/>
                <Route path="authors" element={<AuthorsPage/>}/>
                <Route path="countries" element={<CountriesPage/>}/>
            </Routes>
        </BrowserRouter>
    );
};

export default App;