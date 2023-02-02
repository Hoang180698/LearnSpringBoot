import axios from "axios";
import React, { useEffect, useState } from "react";

const API_URL = "http://localhost:8080/api/v1/todos";

function TodoList() {
  const [todos, setTodos] = useState([]);
  const [title, setTitle] = useState("");
  useEffect(() => {
    const fetchTodos = async () => {
      try {
        let res = await axios.get(API_URL);
        setTodos(res.data);
      } catch (error) {
        console.log(error);
      }
    };
    fetchTodos();
  }, []);
  const handleAdd = async () => {
        try {
            if (title !== "") {
              let res = await axios.post(API_URL,  {
                title : title
              });
          setTodos([...todos, res.data]);
          console.log(res.data);
            }
        } catch (error) {
          console.log(error);
        }
  };
  const handleUpdateTitle = async (id) => {
    try {
        let todo = todos.find(e => e.id === id);
        let newTitle = window.prompt("Title", todo.title);
        await axios.put(`${API_URL}/${id}`,  {
            title : newTitle,
            status : todo.status
          });
          const newTodos = todos.map((p) => {
            if (p.id === id) {
              return { ...p, title: newTitle};
            }
            return p;
          });
          setTodos(newTodos);
    } catch (error) {
      console.log(error);
    }
  };
  const handleDelete = async (id) => {
    try {
      await axios.delete(`${API_URL}/${id}`);
      const newTodos = [...todos];
      setTodos(newTodos.filter(x => x.id !== id));
  } catch (error) {
    console.log(error);
  }
  };
  const handleToggleStatus = async (id) => {
    try {
      let todo = todos.find(e => e.id === id);
      await axios.put(`${API_URL}/${id}`,  {
          status : !todo.status
        });
        const newTodos = todos.map((p) => {
          if (p.id === id) {
            return { ...p, status: !todo.status};
          }
          return p;
        });
        setTodos(newTodos);
  } catch (error) {
    console.log(error);
  }
  };

  return (
    <>
      <h2>TodoList App</h2>
      <input
        type="text"
        placeholder="Enter title ..."
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />
      <button onClick={handleAdd}>Add</button>
      <ul>
        {todos.length === 0 && <li>Không có công việc trong danh sách</li>}
        {todos.length > 0 &&
          todos.map((todo) => (
            <li key={todo.id}>
              <input
                type="checkbox"
                checked={todo.status}
                onChange={() => {
                  handleToggleStatus(todo.id);
                }}
              />
              <span className={todo.status ? "active" : ""}>{todo.title}</span>
              <button onClick={() => handleUpdateTitle(todo.id)}>Update</button>
              <button onClick={() => handleDelete(todo.id)}>Delete</button>
            </li>
          ))}
      </ul>
    </>
  );
}

export default TodoList;
