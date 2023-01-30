import React, { useState, useEffect } from 'react';
import { useParams } from "react-router-dom";
import axios from 'axios';

export default function BoardView({mid}) {
    const params = useParams();

    const [ board, setBoard ] = useState({})
    const [ ubtn, setUbtn ] = useState(false)
    const [ clist, setClist ] = useState([])

    useEffect(
        () => { axios
            .get("/board/getview", { params : { bno : params.bno } })
            .then((res) => { console.log(res.data); setBoard(res.data) })
            .catch((err) => { alert(err) })
        }
    , [])

    useEffect(
        cread
    , [])

    // 글 수정
    function bupdate() {
        let info = {
            bno : params.bno,
            btitle : document.querySelector('.btitle').value,
            bcontent : document.querySelector('.bcontent').value
        }

        axios
            .put("/board/bupdate", info)
            .then((res) => {
                if(res.data == true) {
                    alert("글 수정 성공!!")
                    window.location.href="/board/board"
                }
            })
            .catch((err) => { alert(err) })

    }

    // 수정 폼 생성
    function updateForm() {

        if(ubtn == true) {
            setUbtn(false)
        } else if(ubtn == false) {
            setUbtn(true)
        }

    }

    // 글 삭제
    function bdelete() {
        if(window.confirm("정말 삭제하시겠습니까??")) {
            console.log(true)
            axios
                .delete("/board/bdelete", { params : { bno : params.bno } })
                .then((res) => {
                    if(res.data == true) {
                        alert("글 삭제 성공!!")
                        window.location.href = "/board/board"
                    }
                })
                .catch((err) => { alert(err) })
        }
    }

    // 댓글 등록
    function cwrite() {

        let cinfo = {
            bno : params.bno,
            ccontent : document.querySelector('.ccontent').value
        }

        if(mid == null) {
            alert("로그인 해주세요!!")
        } else {
            axios
                .post("/comment/cwrite", cinfo)
                .then((res) => {
                    if(res.data == true) {
                        alert("댓글 등록 성공!!")
                        window.location.reload();
                    }
                })
                .catch((err) => { alert(err) })
        }

    }

    // 댓글 출력
    function cread() {
        axios.get("/comment/clist", { params : { bno : params.bno } })
        .then((res) => {
            setClist(res.data)
            console.log(res.data)
        })
        .catch((err) => {
            alert(err)
        })
    }

    return (
        <div>
            <div>{board.bno}</div>
            <div>{board.btitle}</div>
            <div>{board.bcontent}</div>

            {
                mid == board.mid ?
                (
                    <div>
                        <button type="button" onClick={updateForm}>수정</button>
                        <button type="button" onClick={bdelete}>삭제</button>
                    </div>
                )
                :
                null
            }

            <div className="updateForm">
            {
                ubtn ?
                    (
                        <div>
                            제목 <input type="text" className="btitle" /> <br />
                            내용 <input type="text" className="bcontent" /> <br />
                            <button type="button" onClick={bupdate}>수정</button>
                        </div>
                    )
                :
                    null
            }
            </div>
            <div>
                <h4>댓글</h4>
                내용 <input type="text" className="ccontent" /> <br />
                <button type="button" onClick={cwrite}>댓글 등록</button>
            </div>
            {
                clist.map((c) => {
                    return (
                        <>
                            <div>
                                <span>{c.mid}</span> <br />
                                <span>{c.ccontent}</span> <br />
                                <span>{c.cdate}</span> <br />
                            </div>
                            <br />
                        </>
                    )
                })
            }
        </div>
    )

}
