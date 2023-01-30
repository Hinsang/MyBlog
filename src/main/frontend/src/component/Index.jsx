import react, { useState, useEffect } from 'react';
import Header from './Header';
import Footer from './Footer';
import Home from './Home';
import Login from './member/Login';
import Signup from './member/Signup'
import Board from './board/Board'
import BoardView from './board/BoardView'
import axios from 'axios'
import { BrowserRouter, Routes, Route } from 'react-router-dom';

export default function Index(props) {

    const [ mid , setMid ] = useState(null);

    useEffect(() => {
        axios
            .get("/member/getloginInfo")
            .then( (response) => {
                if(response.data !== "") {
                    setMid( response.data.mid );
                } else {
                    setMid( null )
                }
            } )
            .catch((err) => alert(err))
    }, [])

    return (
        <div className="main_inner">
            <BrowserRouter>
                <Header mid={mid} />
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/member/login" element={<Login />} />
                    <Route path="/member/signup" element={<Signup />} />
                    <Route path="/board/board" element={<Board loginMid={mid} />} />
                    <Route path="/board/view/:bno" element={<BoardView mid={mid} />} />
                </Routes>
                <Footer />
            </BrowserRouter>
        </div>
    )
}
