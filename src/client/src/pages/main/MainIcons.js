import React from 'react'
import { Link } from 'react-router-dom'
import bubbles from "../../assets/images/bubbles.png";
import bulbs from "../../assets/images/bulbs.png";
import calendar from "../../assets/images/calendar.png";
import office from "../../assets/images/office.png";
import puzzle from "../../assets/images/puzzle.png";

const MainIcons = () => {

  return (
    <>
      <div className="icons">
        <div className="icons"><ul>
          <li><Link to="/mate">
            <p className="thumb"><img src={puzzle} alt='puzzle' style={{transform: "scaleX(-1)"}} /></p>
            <p className="title">빈즈메이트</p>
            <p className="decs">함께 공부하실 콩?</p></Link></li>
          <li><Link to="/today">
            <p className="thumb"><img src={bulbs} alt='bulbs' style={{width:"100%", margin:0}} /></p>
            <p className="title">빈즈투데이</p>
            <p className="decs">도와줘, 콩들아!</p></Link></li>
          <li><Link to="/office">
            <p className="thumb"><img src={office} alt='office' style={{margin:"12% 0 0 3%"}}  /></p>
            <p className="title">빈즈오피스</p>
            <p className="decs">함께 공유해요, 콩!</p></Link></li>
          <li><Link to="/talk">
            <p className="thumb"><img src={bubbles} alt='bubbles' /></p>
            <p className="title">빈즈톡</p>
            <p className="decs">콩들과 소통해요.</p></Link></li>
          <li><Link to="/planner">
            <p className="thumb"><img src={calendar} alt='calendar' style={{width:"90%", margin:"6% 8% 0 0"}} /></p>
            <p className="title">빈즈플래너</p>
            <p className="decs">콩콩, 오늘도 화이팅.</p></Link></li>
        </ul></div>
      </div>
    </>
  )
}

export default MainIcons