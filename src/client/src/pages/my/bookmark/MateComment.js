import React from 'react'
import heart from "../../../assets/icons/heart_r.png";
import quest from "../../../assets/icons/question_g.png";
import { Link } from 'react-router-dom';



const MateComment = () => {

  const mates = [
    { id: 1, title: "1 토요일에 용산에서 함께 열공하실 분!", author: "잠못드는콩", quest: 5, heart: 6, cmmnt: 7 },
    { id: 2, title: "2 토요일에 용산에서 함께 열공하실 분!", author: "잠못드는콩", quest: 5, heart: 6, cmmnt: 7 },
    { id: 3, title: "3 토요일에 용산에서 함께 열공하실 분!", author: "잠못드는콩", quest: 5, heart: 6, cmmnt: 7 },
    { id: 4, title: "4 토요일에 용산에서 함께 열공하실 분!", author: "잠못드는콩", quest: 5, heart: 6, cmmnt: 7 },
  ];

  const cmnts = [
    { id: 1, cont: "1 일대일 채팅 봐주세요", author: "잠못드는콩", mate_id: 1, quest: 5, heart: 6 },
    { id: 2, cont: "2 일대일 채팅 봐주세요", author: "잠못드는콩", mate_id: 1, quest: 5, heart: 6 },
    { id: 3, cont: "3 일대일 채팅 봐주세요", author: "잠못드는콩", mate_id: 2, quest: 5, heart: 6 },
    { id: 4, cont: "4 일대일 채팅 봐주세요", author: "잠못드는콩", mate_id: 2, quest: 5, heart: 6 },
  ];

  function mateCont() {
    return (cmnts.map((cmnte) => (
      <li className="mate_con" key={cmnte.id} style={{height:120}}>
        <Link to={`/mate/${cmnte.id}`}>
          <h4>{mates[cmnte.mate_id - 1].title}</h4>
          <h4>{cmnte.cont}</h4>
          <ul className="mate_emotion">
            <li><img src={quest} alt="quest" /><span>{cmnte.quest}</span></li>
            <li><img src={heart} alt="heart" /><span>{cmnte.heart}</span></li>
          </ul>
        </Link>
      </li>
    )))
  }



  return (
    <>
      <div className="mate">
        <div>
          <ul>
            {mateCont()}
          </ul>
          <h3>@bnzMate</h3>
        </div>
      </div>
    </>
  )
}

export default MateComment