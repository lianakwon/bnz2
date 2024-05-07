import axios from 'axios'
import { useEffect } from 'react';

import MainBanner from './MainBanner';
import MainText from "./MainText";
import MainIcons from "./MainIcons";
import MainMate from "./MainMate";
import MainToday from "./MainToday";



const Main = () => {

  useEffect(() => { getIndex(); }, [])

  const getIndex = async () => {
    await axios.get(`http://localhost:8080/`)
      .then(response => { console.log(response); })
      .catch(error => { console.log(error); });
  }

  return (
    <div className="inner_m">
      <MainBanner />
      <MainText />
      <MainIcons />
      <MainMate />
      <MainToday />
    </div>
  )
}

export default Main