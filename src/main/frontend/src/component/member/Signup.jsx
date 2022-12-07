import React from 'react'
import axios from 'axios'

export default function Signup() {

    function signup() {
        let info = {
            mid : document.querySelector(".mid").value,
            mpw : document.querySelector(".mpw").value
        }

        axios.post("/member/signup", info)
        .then(
            (res) => {
                let result = res.data
                if(result != 0) {
                    alert("회원가입 성공!!")
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
        <div>
            <h1>회원가입</h1>
            <form>
                아이디<input type="text" class="mid" /><br />
                패스워드<input type="text" class="mpw" /><br />
                <button type="button" onClick={signup}>회원가입</button>
            </form>
        </div>
    )
}
