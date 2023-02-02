import React, { useState } from 'react'
import Content from './components/content/Content'
import Post from './components/post/Post'
import Menu from './components/menu/Menu'
import Blog from './components/blog/Blog';
import TodoList from './components/todoList/TodoList';

function App() {
  // const [isShow, setIsShow] = useState(true);
  // const toggle = () => {
  //   setIsShow(!isShow);
  // }
  return (
    <>
      <TodoList />
    </>
  )
}

export default App