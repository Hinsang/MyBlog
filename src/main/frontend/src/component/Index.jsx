import react from 'react';
import Header from './Header';
import Footer from './Footer';
import Home from './Home';
import Login from './member/Login';
import Signup from './member/Signup'
import { BrowserRouter, Routes, Route } from 'react-router-dom';

export default function Index() {
    return (
        <div>
            <BrowserRouter>
                <Header />
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/member/login" element={<Login />} />
                    <Route path="/member/signup" element={<Signup />} />
                </Routes>
                <Footer />
            </BrowserRouter>
        </div>
    )
}
