import React from 'react'
import heart from "../../../assets/icons/heart_r.png";
import quest from "../../../assets/icons/question_g.png";
import { Link } from 'react-router-dom';



const TodayComment = () => {

  const todays = [
    { id: 1, thum: "../../assets/icons/no_thum.png", title: "1 List<T> 컴파일 에러가 납니다. 도와주세요", cont: "List<T> 컴파일 에러가 납니다. 도와주세요 List<T> 컴파일 에러가 납니다. 도와주세요", author: "콩", isAnswered: true, quest: 5, heart: 6, cmmnt: 7 },
    { id: 2, thum: "../../assets/icons/no_thum.png", title: "2 List<T> 컴파일 에러가 납니다. 도와주세요", cont: "List<T> 컴파일 에러가 납니다. 도와주세요 으악", author: "콩", isAnswered: false, quest: 5, heart: 6, cmmnt: 7 },
    { id: 3, thum: "../../assets/icons/no_thum.png", title: "3 List<T> 컴파일 에러가 납니다. 도와주세요", cont: "List<T> 컴파일 에러가 납니다. 도와주세요 List<T> 컴파일 에러가 납니다. 도와주세요", author: "콩", isAnswered: true, quest: 5, heart: 6, cmmnt: 7 },
    { id: 4, thum: "../../assets/icons/no_thum.png", title: "4 List<T> 컴파일 에러가 납니다. 도와주세요", cont: "List<T> 컴파일 에러가 납니다. 도와주세요 List<T> 컴파일 에러가 납니다. 도와주세요", author: "콩", isAnswered: true, quest: 5, heart: 6, cmmnt: 7 },
  ];

  const cmnts = [
    { id: 1, cont: "1 일대일 채팅 봐주세요", author: "잠못드는콩", mate_id: 1, quest: 5, heart: 6 },
    { id: 2, cont: "2 일대일 채팅 봐주세요", author: "잠못드는콩", mate_id: 1, quest: 5, heart: 6 },
    { id: 3, cont: "3 일대일 채팅 봐주세요", author: "잠못드는콩", mate_id: 2, quest: 5, heart: 6 },
    { id: 4, cont: "4 일대일 채팅 봐주세요", author: "잠못드는콩", mate_id: 2, quest: 5, heart: 6 },
  ];

  function todayCont() {
    return (cmnts.map((cmnte) => (
      <li className="today_con" key={cmnte.id} style={{height:120}}>
        <Link to={`/today/${cmnte.id}`}>
          <h4>{todays[cmnte.mate_id - 1].title}</h4>
          <h4>{cmnte.cont}</h4>
          <ul className="today_emotion">
            <li><img src={quest} alt="quest" /><span>{cmnte.quest}</span></li>
            <li><img src={heart} alt="heart" /><span>{cmnte.heart}</span></li>
          </ul>
        </Link>
      </li>
    )))
  }



  return (
    <>
      <div className="today">
        <div>
          <ul>
            {todayCont()}
          </ul>
          <h3>@bnzToday</h3>
        </div>
      </div>
    </>
  )
}

export default TodayComment