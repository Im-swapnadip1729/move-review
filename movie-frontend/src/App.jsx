import { Route, Routes } from 'react-router-dom';
import './App.css'
import api from './api/axiosConfig';
import { useEffect, useState } from 'react';
import { Layout } from './componenets/Layout';
import Home from './componenets/home/home';

function App() {
 
    const [movies, setMovies] = useState([]);

    const fetchMovies = async () => {
        try {
            const responce = await api.get('/movies');
            console.log(responce.data);
            setMovies(responce.data);
        } catch (error) {
            console.log("Error while fetching movies data", error);
        }
    }

    useEffect(() => {
        fetchMovies();
    }, [])

    return (
        <div className = "App">
            <Routes>
                <Route path = '/' element = {<Layout />} >
                    <Route path = '/' element = {<Home movies={movies} />} />
                </Route>
            </Routes>
        </div>
    );
 
}

export default App
