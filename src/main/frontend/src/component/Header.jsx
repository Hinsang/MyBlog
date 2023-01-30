import React from 'react'
import { Link } from 'react-router-dom'
import styles from '../css/Index.css'
import axios from 'axios'

export default function Header({mid}) {

    function logout() {
        axios
            .get("/member/logout")
            .then((res) => {
                window.location.href="/"
            })
            .catch((err) => { alert(err) })
    }

    return (
        <div>
            <div className="header_menu">
                {
                    mid !== null ?
                    (
                    <>
                        <Link to="/">메인 홈</Link> |&nbsp;
                        <Link to="/board/board">게시판</Link> |&nbsp;
                        <span style={{fontSize: 20}}>{mid}님 반갑습니다.</span> |&nbsp;
                        <span style={{fontSize: 20, cursor: "pointer"}} onClick={logout}>로그아웃</span>
                    </>
                    )
                    :
                    (
                    <>
                        <Link to="/">메인 홈</Link> |&nbsp;
                        <Link to="/board/board">게시판</Link> |&nbsp;
                        <Link to="/member/login">로그인</Link> |&nbsp;
                        <Link to="/member/signup">회원가입</Link>
                    </>
                    )
                }
            </div>
        </div>
    )
}
