import React from 'react'
import { Link, useNavigate } from 'react-router-dom';

const Detail = () => {

  const navigate = useNavigate();

  const clickTitle = () => { navigate(-1); }

  const teams = [
    { id: 1, title: "team_1", members: ["mem01", "mem02", "mem03", "mem04"] },
    { id: 2, title: "team_2", members: ["mem01", "mem02", "mem03"] },
    { id: 3, title: "team_3", members: ["mem01", "mem02"] },
    { id: 4, title: "team_4", members: ["mem01"] },
    { id: 5, title: "team_5", members: ["mem01", "mem02", "mem03", "mem04"] },
    { id: 6, title: "team_6", members: ["mem01", "mem02", "mem03"] },
    { id: 7, title: "team_7", members: ["mem01", "mem02"] },
    { id: 8, title: "team_8", members: ["mem01"] }
  ];

  function teamTag() {
    return (
      teams.map((team, index) => {
        return (
          <li key={team.id}>
            <Link to={`/team/${team.id}`}>
              <p className='thumb'></p>
              <p className='title'>{team.title}</p>
              <p className='content'>{memberTag(index)}</p>
              <p className='more'>팀 채팅 보기</p>
            </Link></li>)
      })
    )
  }

  function memberTag(index) {
    const team = teams[index];
    return (
      team.members.map((member) => {
        return (
          <p className='member' key={index}>{member}</p>)
      })
    )
  }



  return (
    <>
      <div id='my' className="inner_m detail">
        <div id='team'>
          <div className='team'>
            <h2 onClick={clickTitle} className='link_back'>스터디 | 프로젝트</h2>
            <ul>
              {teamTag()}
            </ul>
          </div>
        </div>
      </div>
    </>
  )
}

export default Detail