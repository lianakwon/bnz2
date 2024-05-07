import { Route, BrowserRouter, Routes } from 'react-router-dom';

import Header from './layouts/Header'
import Footer from './layouts/Footer'
import Main from './pages/main/Main'
import Admin from './pages/Admin'

import Chat from './pages/chat/Chat'
import Mate from './pages/mate/Mate'
import Today from './pages/today/Today'
import Folio from './pages/folio/Folio'
import Plan from './pages/plan/Plan'

import Login from './pages/account/Login'
import Join1 from './pages/account/Join_1'
import Join2 from './pages/account/Join_2'
import Join3 from './pages/account/Join_3'

import My from './pages/my/main/My'
import Profile from './pages/my/profile/Update'
import ProfileIMG from './pages/my/profile/UpdateIMG'
import Team from './pages/my/team/Detail'
import Board from './pages/my/board/Detail';
import Bookmark from './pages/my/bookmark/Detail';


function App() {
  return (
    <BrowserRouter>
      <Header />

      <div id='main'>
        <Routes>
          
          <Route path="" element={<Main />} />
          <Route path="/admin" element={<Admin />} />

          <Route path="/today"  element={<Today />} />
          <Route path="/mate"   element={<Mate />} />
          <Route path="/folio"  element={<Folio />} />
          <Route path="/chat"   element={<Chat />} />
          <Route path="/plan"   element={<Plan />} />

          <Route path="/account/login"  element={<Login />} />
          <Route path="/account/join/1" element={<Join1 />} />
          <Route path="/account/join/2" element={<Join2 />} />
          <Route path="/account/join/3" element={<Join3 />} />

          <Route path="/my"             element={<My />} />
          <Route path="/my/profile"     element={<Profile />} />
          <Route path="/my/profile_img" element={<ProfileIMG />} />
          <Route path="/my/team"        element={<Team />} />
          <Route path="/my/board"       element={<Board />} />
          <Route path="/my/bookmark"    element={<Bookmark />} />

        </Routes>
      </div>

      <Footer />
    </BrowserRouter>
  );
}

export default App;
