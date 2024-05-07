import React from 'react'
import Profile from './Profile'
import Team from './Team'
import Bookmark from './Bookmark'
import Board from './Board'

const My = () => {

  return (
    <>
      <div id='my' className="inner_m">
        <div id='profile'><Profile /></div>
        <div id='team'><Team /></div>
        <div id='bookmark'><Bookmark /></div>
        <div id='board'><Board /></div>
      </div>
    </>
  )
}

export default My