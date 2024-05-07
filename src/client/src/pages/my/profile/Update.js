// import axios from 'axios';
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

const Update = () => {

  const navigate = useNavigate();
  const clickTitle = () => { navigate(-1); }

  const [profile, setProfile] = useState({ username: "liana", password: "liana199619", email: "kmr199619@gmail.com", nickname: "소세지", message: "소세지조아" })
  const { username, password, email, nickname, message } = profile;

  const onChangeInput = (e) => { setProfile({ ...profile, [e.target.name]: e.target.value }); };

  const submit = (e) => {
    e.preventDefault();
  };



  return (
    <>
      <div id='my' className="inner_m">
        <div id='profile'>
          <h2 onClick={clickTitle} className='link_back'>프로필 편집</h2>
          <div className='profile_thum'>
            <div className='thum'></div>
          </div>
          <form className='profile_cont update' action='/my/profile' onSubmit={submit}>
            <div>
              <label for={username} className='title'>아이디</label>
              <input disabled type='text' value={username} name='username' id='username' onChange={onChangeInput} />
            </div>
            <div>
              <label for={password} className='title'>비밀번호</label>
              <input disabled type='text' value={password} name='password' id='password' onChange={onChangeInput} />
            </div>
            <div>
              <label for={email} className='title'>이메일</label>
              <input disabled type='text' value={email} name='email' id='email' onChange={onChangeInput} />
            </div>
            <div>
              <label for={nickname} className='title'>닉네임</label>
              <input type='text' value={nickname} name='nickname' id='nickname' onChange={onChangeInput} />
            </div>
            <div>
              <label for={message} className='title'>상태메세지</label>
              <input type='text' value={message} name='message' id='message' onChange={onChangeInput} />
            </div>
            <div className='buttons'>
              <Link to="/my">취소</Link>
              <button type='submit'>수정</button>
            </div>
          </form>
        </div>
      </div>
    </>
  )
}

export default Update