    import React from 'react'
    import axios from 'axios'

    export default function Login() {

        function login() {
            let info = {
                mid : document.querySelector(".mid").value,
                mpw : document.querySelector(".mpw").value
            }

            axios
            .post("/member/setlogin", info)
            .then(
                (res) => {
                    let result = res.data
                    if(result == 1) {
                        alert("로그인 성공!!")
                        window.location.href="/"
                    } else if(result == 2) {
                        alert("비밀번호가 일치하지 않습니다.")
                    } else if(result == 0) {
                        alert("존재하는 ID가 없습니다.")
                    }
                }
            )
            .catch(
                (err) => {
                    console.log(err)
                }
            )
        }

        return (
            <div className="inner">
                <h1>로그인</h1>
                <form>
                    아이디<br />
                    <input type="text" className="mid" /><br />
                    패스워드<br />
                    <input type="text" className="mpw" /><br />
                    <button type="button" onClick={login}>로그인</button>
                </form>
            </div>
        )
    }
