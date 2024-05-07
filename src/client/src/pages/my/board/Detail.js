import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom';
import Mate from './Mate';
import Today from './Today';
import MateComment from './MateComment';
import TodayComment from './TodayComment';

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
            <h2 onClick={clickTitle} className='link_back'>작성한 게시글 관리</h2>
            <input type="radio" id="tab1" name="tab" /><label for="tab1">작성한 게시글</label>
            <input type="radio" id="tab2" name="tab" /><label for="tab2">작성한 댓글</label>
            <div class="like board tab tab1">
              <Mate />
              <Today />
            </div>
            <div class="like cmmnt tab tab2">
              <MateComment />
              <TodayComment />
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default Detail