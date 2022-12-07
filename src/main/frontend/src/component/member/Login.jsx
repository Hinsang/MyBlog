import React from 'react'

export default function Login() {
    return (
        <div>
            <h1>로그인</h1>
            <form>
                아이디<input type="text" class="mid" /><br />
                패스워드<input type="text" class="mpw" /><br />
                <button type="button">로그인</button>
            </form>
        </div>
    )
}
