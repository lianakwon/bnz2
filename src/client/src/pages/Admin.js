import axios from 'axios'
import React, { useEffect } from 'react'

const Admin = () => {

  useEffect(() => { getLoad(); }, []);

  function getLoad() {
    axios.get("http://localhost:8080/admin/")
      .then(response => { console.log(response) })
      .catch(error => { console.log(error) });
  };

  

  return (
    <div>Admin</div>
  )
}

export default Admin