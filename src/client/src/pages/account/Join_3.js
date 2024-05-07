import React from 'react'
import { useNavigate } from 'react-router-dom';



const Join_4 = () => {

  const navigate = useNavigate();

  const clickTitle = () => { navigate(-1); }



  return (
    <div className='inner_login'>
      <h1 onClick={clickTitle}>회원가입</h1>
      <form action='join4'>
        <div className='thumb'>

        </div>
        <h3>회원가입 성공!</h3>
        <div>
          <a href='/login'>로그인 화면으로 가기</a>
        </div>
        <div>
          <p> </p>
          <p> </p>
        </div>
      </form>
    </div>
  )
}

export default Join_4