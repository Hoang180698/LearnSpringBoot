import { Link, Route, Router, Routes } from 'react-router-dom'
import './App.css'
import Counter from './components/counter/counter'
import NotFound from './components/not-found/NotFound'
import TodoList from './components/todoList/TodoList'

function App() {
  
  return (
    <>
      <ul>
        <li>
          <Link to={"/counter"}>Counter App</Link>
        </li>
        <li>
          <Link to={"/todolist"}>Todo App</Link>
        </li>
      </ul>

      <Routes>
        <Route path="/" element= {<Counter/>}/>
        <Route path="/counter" element={<Counter/>}/>
        <Route path="/todoList" element={<TodoList/>}/>
        <Route path="*" element={<NotFound/>}/>
      </Routes>
    </>
  )
}

export default App
