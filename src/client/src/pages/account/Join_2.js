import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';

const Join_2 = () => {
  
  const navigate = useNavigate();
  const clickTitle = () => { navigate(-1); }

  const [joinDTO, setJoinDTO] = useState({ username: "", password1: "", password2: "", nickname: "", email: "", phone1: "010", phone2: "", phone3: "" });
  const { username, password1, password2, nickname, email, phone1, phone2, phone3 } = joinDTO;

  const onChangeJoin = (e) => { setJoinDTO({ ...joinDTO, [e.target.name]: e.target.value }); };

  const [errorUN, setErrorUN] = useState("");
  const [errorPW1, setErrorPW1] = useState("");
  const [errorPW2, setErrorPW2] = useState("");
  const [errorNN, setErrorNN] = useState("");
  const [errorEM, setErrorEM] = useState("");
  const [errorPH, setErrorPH] = useState("");

  useEffect((e) => { isValid(e); },
    // eslint-disable-next-line react-hooks/exhaustive-deps
    [joinDTO]
  )
  
  function isValid() {
    const isValidUN = (un) => { const regex = /^[a-z]+[a-z0-9]{5,11}$/g; return regex.test(un); };
    const isValidPW = (pw) => { const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/; return regex.test(pw); };
    const isValidNN = (nn) => { const regex = /^[a-z]+[a-z0-9]{5,}$/g; return regex.test(nn); };
    const isValidEM = (em) => { const regex = /^[a-zA-Z0-9+-.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/g; return regex.test(em); };
    const isValidPH = (ph) => { const regex = /^([0-9]{4,4})$/; return regex.test(ph); };

    if (username === "" || isValidUN(username)) { setErrorUN(""); }
    else { setErrorUN("영소문자, 숫자 포함 6-13자"); }

    if (password1 === "" || isValidPW(password1)) { setErrorPW1(""); }
    else { setErrorPW1("대/소문자, 숫자 포함 8-20자"); }

    if (password1 === password2) { setErrorPW2(""); }
    else { setErrorPW2("패스워드를 확인해주세요."); }

    if (nickname === "" || isValidNN(nickname)) { setErrorNN(""); }
    else { setErrorNN("영소문자, 숫자 포함 6-13자"); }

    if (email === "" || isValidEM(email)) { setErrorEM(""); }
    else { setErrorEM("올바른 이메일 형식으로 입력해주세요"); }

    if (phone2 === "" && phone3 === "") { setErrorPH(""); }
    if (isValidPH(phone2) && isValidPH(phone3)) { setErrorPH(""); }
    else { setErrorPH("전화번호는 숫자 3-4자리로 입력해주세요."); };
  }

  function isValidEvent(e) {
    if (e.target.name === "username") { const regex = /^[a-z]+[a-z0-9]{5,11}$/g; return regex.test(e.target.value); };
    if (e.target.name === "password1" || e.target.name === "password2") { const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/; return regex.test(e.target.value); };
    if (e.target.name === "nickname") { const regex = /^[a-z]+[a-z0-9]{5,}$/g; return regex.test(e.target.value); };
    if (e.target.name === "email") { const regex = /^[a-zA-Z0-9+-.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/g; return regex.test(e.target.value); };
    if (e.target.name === "phone1" || e.target.name === "phone2" || e.target.name === "phone3") { const regex = /^([0-9]{3,4})$/; return regex.test(e.target.value); };
  }

  function activeEnter(e) {
    if (e.key === "Enter") {
      e.preventDefault();
      console.log(joinDTO);
      if (e.target.name === "username" && isValidEvent(e)) { checkUsername(e); }
      if (e.target.name === "password1" && isValidEvent(e)) { document.querySelector("input[id='password2']").focus(); }
      if (e.target.name === "password2" && isValidEvent(e)) { document.querySelector("input[id='nickname']").focus(); }
      if (e.target.name === "nickname" && isValidEvent(e)) { document.querySelector("input[id='email']").focus(); }
      if (e.target.name === "email" && isValidEvent(e)) { document.querySelector("input[id='phone1']").focus(); }
      if (e.target.name === "phone1" && isValidEvent(e)) { document.querySelector("input[id='phone2']").focus(); }
      if (e.target.name === "phone2" && isValidEvent(e)) { document.querySelector("input[id='phone3']").focus(); }
      if (e.target.name === "phone3" && isValidEvent(e)) { submit(e); }
    }
  }

  const checkUsername = async (e) => {
    e.preventDefault();
    console.log(username);
    await axios.post("http://localhost:8080/account/check", {username})
      .then(response => {
        console.log(response);
        console.log("id check success");
        console.log(username);
        setErrorUN("사용 가능한 아이디입니다.");
        document.querySelector('input[name="password1"]').focus();
        return true;
      })
      .catch(errors => {
        console.log(errors);
        console.log(username);
        console.log("id check failed");
        setErrorUN("중복되는 아이디입니다.");
        document.querySelector('input[name="username"]').focus();
        return false;
      });

  }

  const submit = async (e) => {
    e.preventDefault();
    if (errorUN !== '') { document.querySelector("input[id='username']").focus(); }
    else if (errorPW1 !== '') { document.querySelector("input[id='password1']").focus(); }
    else if (errorPW2 !== '') { document.querySelector("input[id='password2']").focus(); }
    else if (errorNN !== '') { document.querySelector("input[id='nickname']").focus(); }
    else if (errorEM !== '') { document.querySelector("input[id='email']").focus(); }
    else if (errorPH !== '') { document.querySelector("input[id='phone2']").focus(); }
    else {
      await axios.post("http://localhost:8080/account/join", joinDTO)
        .then(response => { alert("회원가입 완료! 로그인 화면으로 이동합니다."); console.log("join success"); navigate(`/account/login`); })
        .catch(errors => { console.log("join failed"); navigate(`/account/join/2`); document.querySelector('input[name="username"]').focus(); });
    }
  }



  return (
    <div className='inner_login inner_join'>
      <h1 onClick={clickTitle}>회원가입</h1>
      <form onSubmit={submit}>
        <div>
          <input type='text' id='username' name='username' value={username} placeholder='아이디' onChange={onChangeJoin} onKeyDown={activeEnter} />
          <button type="submit" className='check' onClick={checkUsername}>아이디 중복 확인</button>
          {errorUN
            ? (<p className={checkUsername === true ? "error-message success" : "error-message"}>{errorUN}</p>)
            : (<p className="error-message"> </p>)}</div>
        <div>
          <input type='password' id='password1' name='password1' value={password1} placeholder='비밀번호' onChange={onChangeJoin} onKeyDown={activeEnter} />
          {errorPW1 ? (<p className="error-message">{errorPW1}</p>) : (<p className="error-message"> </p>)}</div>
        <div>
          <input type='password' id='password2' name='password2' value={password2} placeholder='비밀번호 확인' onChange={onChangeJoin} onKeyDown={activeEnter} />
          {errorPW2 ? (<p className="error-message">{errorPW2}</p>) : (<p className="error-message"> </p>)}</div>
        <div>
          <input type='text' id='nickname' name='nickname' value={nickname} placeholder='닉네임' onChange={onChangeJoin} onKeyDown={activeEnter} />
          {errorNN ? (<p className="error-message">{errorNN}</p>) : (<p className="error-message"> </p>)}</div>
        <div>
          <input type='text' id='email' name='email' value={email} placeholder='이메일' onChange={onChangeJoin} onKeyDown={activeEnter} />
          {errorEM ? (<p className="error-message">{errorEM}</p>) : (<p className="error-message"> </p>)}</div>
        <div className="phone">
          <input type='text' id='phone1' name='phone1' value={phone1} placeholder='010' onChange={onChangeJoin} onKeyDown={activeEnter} />-
          <input type='text' id='phone2' name='phone2' value={phone2} placeholder='0000' onChange={onChangeJoin} onKeyDown={activeEnter} />-
          <input type='text' id='phone3' name='phone3' value={phone3} placeholder='0000' onChange={onChangeJoin} onKeyDown={activeEnter} />
          {errorPH ? (<p className="error-message">{errorPH}</p>) : (<p className="error-message"> </p>)}
        </div>
        <div>
          <button type="submit" className={checkUsername ? "success" : "failed"}>회원가입</button>
        </div>
        <div>
          <p> </p>
          <p> </p>
        </div>
      </form>
    </div>
  )
}

export default Join_2