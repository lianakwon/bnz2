import React from 'react'
import { Link, useNavigate } from 'react-router-dom';
import bubbles from "../../../assets/images/bubbles.png";

const UpdateIMG = () => {

  const navigate = useNavigate();

  const clickTitle = () => { navigate(-1); }

  const profile = [
    { title: "아이디", cont: "liana" },
    { title: "비밀번호", cont: "liana199619" },
    { title: "이메일", cont: "kmr199619@gmail.com" },
    { title: "닉네임", cont: "소세지" },
    { title: "상태메세지", cont: "소세지조아" }
  ]



  return (
    <>
      <div id='my' className="inner_m">
        <div id='profile'>
          <h2 onClick={clickTitle} className='link_back'>프로필 편집</h2>
          <div className='profile_thum'>
            <div className='thum'></div>
          </div>
          <div className='profile_cont'>
            <table>
              <colgroup>
                <col style={{ 'width': '12%' }}></col>
                <col style={{ 'width': '80%' }}></col>
              </colgroup>
              {profile.map((item) => {
                return (
                  <tr>
                    <th className='title'>{item.title}</th>
                    <td>{item.cont}</td>
                  </tr>
                )
              })}
            </table>
          </div>
        </div>

        <form>
          <p className='title'>모양</p>
          <div className='select shape'>
            <ul>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li></ul></div>

          <p className='title'>색</p>
          <div className='select color'>
            <ul>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li></ul></div>

          <p className='title'>눈</p>
          <div className='select eyes'>
            <ul>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li></ul></div>

          <p className='title'>표정</p>
          <div className='select face'>
            <ul>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li>
              <li><Link><img src={bubbles} alt='shape_1' /></Link></li></ul></div>
          <div className='buttons'>
            <Link to="/my" style={{ textAlign: 'center' }}>취소</Link>
            <button type='submit'>수정</button>
          </div>
        </form>
      </div>
    </>
  )
}

export default UpdateIMG