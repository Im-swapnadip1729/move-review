import { Route, Routes } from 'react-router-dom';
import './App.css'
import api from './api/axiosConfig';
import { useEffect, useState } from 'react';
import { Layout } from './componenets/Layout';
import Home from './componenets/home/home';
import Header from './componenets/header/Header';
import Trailer from './componenets/trailer/Trailer';
import Reviews from './componenets/review/Review';

function App() {
 
    const [movies, setMovies] = useState();
      const [movie, setMovie] = useState();
      const [reviews, setReviews] = useState([]);

    const fetchMovies = async () => {
        try {
            const responce = await api.get('/movies');
            console.log(responce.data);
            setMovies(responce.data);
        } catch (error) {
            console.log("Error while fetching movies data", error);
        }
    }

    const getMovieData = async (movieId) => {
      try {
        const response = await api.get(`/movies/${movieId}`);

        const singleMovie = response.data;

        setMovie(singleMovie);

        setReviews(singleMovie.reviews);
      } catch (error) {
        console.error(error);
      }
    };

    useEffect(() => {
        // eslint-disable-next-line react-hooks/set-state-in-effect
        fetchMovies();
    }, [])

    return (
      <div className="App">
        <Header />
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route path="/" element={<Home movies={movies} />} />
            <Route path="/Trailer/:ytTrailerId" element={<Trailer />}></Route>
            <Route
              path="/Reviews/:movieId"
              element={
                <Reviews
                  getMovieData={getMovieData}
                  movie={movie}
                  reviews={reviews}
                  setReviews={setReviews}
                />
              }
            ></Route>
          </Route>
        </Routes>
      </div>
    );
 
}

export default App
