import React from 'react'
// import axios from 'axios'
import heart from "../../assets/icons/heart_r.png";
import cmmnt from "../../assets/icons/alert.png";
import quest from "../../assets/icons/question_g.png";
// import thum from "../../assets/icons/no_thum.png";
import { Link } from 'react-router-dom';

const MainMate = () => {

  const mates = [
    { id: 1, title: "1 토요일에 용산에서 함께 열공하실 분!", author: "잠못드는콩", quest: 5, heart: 6, cmmnt: 7 },
    { id: 2, title: "2 토요일에 용산에서 함께 열공하실 분!", author: "잠못드는콩", quest: 5, heart: 6, cmmnt: 7 },
    { id: 3, title: "3 토요일에 용산에서 함께 열공하실 분!", author: "잠못드는콩", quest: 5, heart: 6, cmmnt: 7 },
    { id: 4, title: "4 토요일에 용산에서 함께 열공하실 분!", author: "잠못드는콩", quest: 5, heart: 6, cmmnt: 7 },
    { id: 5, title: "5 토요일에 용산에서 함께 열공하실 분!", author: "잠못드는콩", quest: 5, heart: 6, cmmnt: 7 },
    { id: 6, title: "6 토요일에 용산에서 함께 열공하실 분!", author: "잠못드는콩", quest: 5, heart: 6, cmmnt: 7 },
    { id: 7, title: "7 토요일에 용산에서 함께 열공하실 분!", author: "잠못드는콩", quest: 5, heart: 6, cmmnt: 7 },
    { id: 8, title: "8 토요일에 용산에서 함께 열공하실 분!", author: "잠못드는콩", quest: 5, heart: 6, cmmnt: 7 }
  ];

  const tags = [
    { id: 1, goals: ["goal", "goal", "goal", "goal"], areas: ["area", "area", "area"], parts: ["part", "part", "part"], langs: ["lang"], spces: ["spce"] },
    { id: 2, goals: ["1 goal", "2 goal", "3 goal"], areas: ["area", "area", "area"], parts: ["part", "part", "part"], langs: ["lang"], spces: ["spce"] },
    { id: 3, goals: ["3 goal", "goal"], areas: ["area", "area", "area"], parts: ["part", "part", "part"], langs: ["lang"], spces: ["spce"] },
    { id: 4, goals: ["4 goal"], areas: ["area", "area", "area"], parts: ["part", "part", "part"], langs: ["lang"], spces: ["spce"] },
    { id: 5, goals: ["5 goal", "goal", "goal", "goal"], areas: ["area", "area", "area"], parts: ["part", "part", "part"], langs: ["lang"], spces: ["spce"] },
    { id: 6, goals: ["6 goal", "goal", "goal"], areas: ["area", "area", "area"], parts: ["part", "part", "part"], langs: ["lang"], spces: ["spce"] },
    { id: 7, goals: ["7 goal", "goal"], areas: ["area", "area", "area"], parts: ["part", "part", "part"], langs: ["lang"], spces: ["spce"] },
    { id: 8, goals: ["8 goal"], areas: ["area", "area", "area"], parts: ["part", "part"], langs: ["lang", "lang"], spces: ["spce"] },
  ];

  function mateCont() {
    return (mates.map((mate, index) => (
      <li className="mate_con" key={mate.id}>
        <Link to={`/mate/${mate.id}`}>
          <h4>{mate.title}</h4>
          <p>{mate.author}</p>
          <ul className="mate_emotion">
            <li><img src={quest} alt="quest" /><span>{mate.quest}</span></li>
            <li><img src={heart} alt="heart" /><span>{mate.heart}</span></li>
            <li><img src={cmmnt} alt="cmmnt" /><span>{mate.cmmnt}</span></li>
          </ul>
          <ul className="tagWrap">{mateTags(index)}</ul>
        </Link>
      </li>
    )))
  }

  function mateTags(index) {
    const tag = tags[index];
    return (<>
      <li className="goal"> {tag.goals.map((item, index) => <span key={index}>{item}</span>)} </li>
      <li className="area"> {tag.areas.map((item, index) => <span key={index}>{item}</span>)} </li>
      <li className="part"> {tag.parts.map((item, index) => <span key={index}>{item}</span>)} </li>
      <li className="lang"> {tag.langs.map((item, index) => <span key={index}>{item}</span>)} </li>
      <li className="spce"> {tag.spces.map((item, index) => <span key={index}>{item}</span>)} </li>
    </>);
  }



  return (
    <>
      <div className="mate">
        <div className="title_area">
          <h2>빈즈메이트</h2>
          <Link to="/mate" className="more">빈즈메이트 더보기</Link>
        </div>
        <div>
          <ul>
            {mateCont()}
          </ul>
        </div>
      </div>
    </>
  )
}

export default MainMate