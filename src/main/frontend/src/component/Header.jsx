import React from 'react'
import { Link } from 'react-router-dom'

export default function Header() {
    return (
        <div>
            <Link to="/">메인 홈</Link>
            <Link to="/member/login">로그인</Link>
            <Link to="/member/signup">회원가입</Link>
        </div>
    )
}
