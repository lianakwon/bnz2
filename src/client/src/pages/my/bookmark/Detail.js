import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import Mate from './Mate'
import Today from './Today'
import MateComment from './MateComment'
import TodayComment from './TodayComment'

const Detail = () => {

  const navigate = useNavigate();

  const clickTitle = () => { navigate(-1); }


  useEffect(() => { loadPage(); }, [])

  function loadPage() { document.querySelector('input[id="tab1"]').click(); }



  return (
    <>
      <div id='my' className="inner_m detail">
        <div>
          <div id="tabs">
            <h2 onClick={clickTitle} className='link_back'>좋아요 | 궁금해요</h2>
            <input type="radio" id="tab1" name="tab" /><label for="tab1">좋아요 게시글</label>
            <input type="radio" id="tab2" name="tab" /><label for="tab2">좋아요 댓글</label>
            <input type="radio" id="tab3" name="tab" /><label for="tab3">궁금해요 게시글</label>

            <div class="like board tab tab1">
              <Mate category="like" />
              <Today category="like" /></div>

            <div class="like board tab tab2">
              <MateComment />
              <TodayComment /></div>
              
            <div class="qust board tab tab3">
              <Mate category="quest" />
              <Today category="quest" /></div>
          </div>
        </div>
      </div>
    </>
  )
}

export default Detail