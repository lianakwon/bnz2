import axios from 'axios'
import { useEffect, useState } from 'react';
import { Link, useNavigate, useSearchParams } from 'react-router-dom';



const Login = () => {
  
  const navigate = useNavigate();

  const clickTitle = () => { navigate(-1); }

  // const [loginDTO, setLoginDTO] = useState({ username: "", password: "" });
  // const { username, password } = loginDTO;
  const [username, setusername] = useState("");
  const [password, setpassword] = useState("");
  const [errorUN, setErrorUN] = useState("");
  const [errorPW, setErrorPW] = useState("");

  useEffect(() => { document.querySelector("input[name='username']").focus(); }, []);

  // const onChangeLogin = (e) => { setLoginDTO({ [e.target.name]: e.target.value }); };
  const onChangeUsername = (e) => { setusername(e.target.value); };
  const onChangePassword = (e) => { setpassword(e.target.value); };

  useEffect((e) => { isValid(e); },
    [username, password]
  )

  function isValid() {
    const isValidUN = (un) => { const regex = /^[a-z]+[a-z0-9]{5,11}$/g; return regex.test(un); };
    const isValidPW = (pw) => { const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/; return regex.test(pw); };

    if (username === "" || isValidUN(username)) { setErrorUN(""); }
    else { setErrorUN("영소문자, 숫자 포함 6-13자"); }

    if (password === "" || isValidPW(password)) { setErrorPW(""); }
    else { setErrorPW("대/소문자, 숫자 포함 8-20자"); }
  };

  function activeEnter(e) {
    if (e.key === "Enter") {
      e.preventDefault();
      if (e.target.name === "username") { document.querySelector('input[name="password"]').focus(); }
      if (e.target.name === "password") { postLogin(e); }
    }
  }

  const postLogin = async (e) => {
    e.preventDefault();
    console.log("post : " + username + " + " + password);
    await axios.post("http://localhost:8080/account/login", { username: username, password: password })
      .then(response => {
        console.log(response.data);
        console.log("success : " + username + " + " + password);
        alert(`로그인 완료! 아이디 : ${username}, 비밀번호 ${password}`);
        navigate(`/`);
      })
      .catch(error => {
        console.log(error);
        console.log("error : " + username + " + " + password);
        navigate(`/account/login`);
        alert(`아이디/패스워드를 확인해주세요.`);
        document.querySelector('input[name="username"]').focus();
      })
  };

  const [searchParams] = useSearchParams();
  const accessToken = searchParams.get('access_token');
  const refreshToken = searchParams.get('refresh_token');




  return (
    <>
      <div className='inner_login'>
        <h1 onClick={clickTitle}>로그인</h1>
        <form onSubmit={postLogin}>
          <div>
            <input type='text' id='username' name='username' placeholder='아이디' value={username} onChange={onChangeUsername} onKeyDown={activeEnter} />
            {errorUN ? (<p className="error-message id">{errorUN}</p>) : (<p className="error-message id"> </p>)}
          </div>
          <div>
            <input type='password' id='password' name='password' placeholder='비밀번호' value={password} onChange={onChangePassword} onKeyDown={activeEnter} />
            {errorPW ? (<p className="error-message pw">{errorPW}</p>) : (<p className="error-message pw"> </p>)}
          </div>
          <div>
            <button type="submit">로그인</button>
          </div>
        </form>
      </div>
      <div className='inner_login bottom'>
        <div className='left'>
          <Link to='/account/join/1'>회원가입</Link>
          {/* <Link to='#'>비밀번호 찾기</Link> */}
        </div>
        <div className='right'>
          <Link to='/account/login/oauth/kakao' className='kakao'>KAKAO</Link>
          <Link to='/account/login/oauth/google' className='google'>Google</Link>
          <Link to='/account/login/oauth/naver' className='naver'>NAVER</Link>
        </div>
        <p style={{ display: 'none' }}>Access Token : {accessToken}</p>
        <p style={{ display: 'none' }}>Refresh Token : {refreshToken}</p>
      </div>
    </>
  )
}

export default Login