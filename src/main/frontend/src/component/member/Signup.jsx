import React from 'react'
import axios from 'axios'

export default function Signup() {

    function signup() {
        let info = {
            mid : document.querySelector(".mid").value,
            mpw : document.querySelector(".mpw").value
        }

        axios.post("/member/setsignup", info)
        .then(
            (res) => {
                let result = res.data
                if(result != false) {
                    alert("회원가입 성공!!")
                    window.location.href = "/"
                } else {
                    alert("회원가입 실패!!")
                }
            }
        )
        .catch(
            err => {
                console.log(err)
            }
        )

    }

    return (
        <div className="inner">
            <h1>회원가입</h1>
            <form className="signup_form">
                아이디<input type="text" className="mid" /><br />
                패스워드<input type="text" className="mpw" /><br />
                <button type="button" onClick={signup}>회원가입</button>
            </form>
        </div>
    )
}
