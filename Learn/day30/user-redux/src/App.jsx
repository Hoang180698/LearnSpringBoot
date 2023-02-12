import { Route, Routes } from "react-router-dom"
import UserCreate from "./components/user/UserCreate"
import UserList from "./components/user/UserList"

function App() {
  
  return (
    <>
      <Routes>
        <Route path="users" element={<UserList />}></Route>
        <Route path="users/create" element={<UserCreate />}></Route>
      </Routes>
    </>
  )
}

export default App
