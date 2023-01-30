import React, { useState, useEffect } from 'react'
import axios from 'axios'

export default function Board({loginMid}) {

    const [ blist, setBlist ] = useState([]);

    // 글 리스트 출력 함수 호출
    useEffect(getboardlist, [])

    let mid;
    if(loginMid) {
        mid = loginMid;
    }

    // 글 리스트 출력
    function getboardlist() {
        axios
            .get("/board/blist")
            .then((res) => {
                setBlist(res.data)
             })
            .catch((err) => { alert(err) })
    }

    // 글 등록
    function bwrite() {

        let info = {
            btitle : document.querySelector(".btitle").value,
            bcontent : document.querySelector(".bcontent").value
        }

        if(mid == undefined || mid == null) {
            alert("비회원은 글을 작성할 수 없습니다.")
        } else {
            axios
                .post("/board/bwrite", info)
                .then((res) => {
                    if(res.data == true) {
                        alert("글 등록 성공!!")
                        window.location.href="/board/board"
                    }
                })
                .catch((err) => { alert(err) })
        }

    }

    // 글 조회
    function loadView(bno) {
        window.location.href = "/board/view/"+bno
    }

    return (
        <div>
            <form>
                제목<input type="text" className="btitle" /> <br />
                내용<input type="text" className="bcontent" /> <br />
                <button type="button" onClick={bwrite}>글쓰기</button>
            </form>

            <table className="btable">
                <tr>
                    <td>글 번호</td>
                    <td>제목</td>
                    <td>내용</td>
                    <td>회원 ID</td>
                    <td>작성일</td>
                </tr>
                {
                    blist.map( ( b ) => {
                        return (
                            <tr>
                                <td> { b.bno } </td>
                                <td style={{ color: "blue", cursor: "pointer", fontSize: "20px", fontWeight: 700 }} onClick={() => loadView(b.bno)}> { b.btitle } </td>
                                <td> { b.bcontent } </td>
                                <td> { b.mid } </td>
                                <td> { b.bdate } </td>
                            </tr>
                        )
                    } )
                }
            </table>

        </div>
    )
}
