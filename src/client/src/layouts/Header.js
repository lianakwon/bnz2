import React, { useEffect } from 'react'
import { Link } from 'react-router-dom';
import alert from '../assets/icons/alert.png'
import edit from '../assets/icons/edit_l.png'
import mypage from '../assets/icons/mypage.png'
import bnzMate from '../assets/icons/bnzMate.png'
import bnzOffice from '../assets/icons/bnzOffice.png'
import bnzPlan from '../assets/icons/bnzPlan.png'
import bnzTalk from '../assets/icons/bnzTalk.png'
import bnzToday from '../assets/icons/bnzToday.png'
import axios from 'axios';

const Header = () => {

  useEffect(() => { onLoad(); },    []  )
  const onLoad = async () => {
    console.log("onLoad");
    await axios.get("http://localhost:8080/onLoad")
      .then(response => {
        console.log(response.data);
      })
      .catch(error => {
        console.log(error);
      })
  };




  return (
    <div id="header">
      <div className="inner_l">
        <div className='header_left'>
          <Link to='/'>codbnz</Link>
        </div>
        <div className='header_center'>
          <ul>
            <li><Link to='/mate'><img src={bnzMate} alt='bnzMate' /></Link></li>
            <li><Link to='/office'><img src={bnzOffice} alt='bnzOffice' /></Link></li>
            <li><Link to='/today'><img src={bnzToday} alt='bnzToday' /></Link></li>
            <li><Link to='/talk'><img src={bnzTalk} alt='bnzTalk' /></Link></li>
            <li><Link to='/plan'><img src={bnzPlan} alt='bnzPlan' /></Link></li>
          </ul>
        </div>
        <div className='header_right'>
          <ul>
            <li><Link to='#'><img src={alert} alt='alert' /></Link></li>
            <li><Link to='/account/login'><img src={edit} alt='login' /></Link></li>
            <li><Link to='/my'><img src={mypage} alt='mypage' /></Link></li>
          </ul>
        </div>
      </div>
    </div>
  );
}

export default Header;