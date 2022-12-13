const API_URL = "http://localhost:8080/api/v1"
const todoListEl = document.getElementById('todoList');
const addBtn = document.getElementById('add');

let todos = [];
const getTodos = async() => {
    try {
        // Gọi API
        let res = await axios.get(`${API_URL}/todos`);
        console.log(res);
        todos = res.data; // Lưu lại dữ liệu trả về từ server

        // Hiện thị lên trên giao diện
        renderTodos(todos);
    } catch (error) {
        console.log(error);
    }
}
const renderTodos = arr => {
    todoListEl.innerHTML = "";
    if (arr.length === 0) {
        todoListEl.innerHTML = `<li>Không có công việc nào trong danh sách</li>`;
        return;
    }
    let html = "";
    arr.forEach(t => {
        html += `
        <li>
            <input type="checkbox" ${t.status ? "checked" : ""}>
            <span class=${t.status ? "todo-active" : ""}>${t.title}</span>
            <button onclick="changeStatus(${t.id})">Change satus</button>
            <button onclick="updateTitle(${t.id}, ${t.status})">Update Title</button>
            <button onclick="deleteTodo(${t.id})">Delete</button>
        </li>
    `
    });
    todoListEl.innerHTML = html;
}

//Cập nhật trạng thái
const changeStatus = async id => {
    try {
        let sta;
        for (let i = 0; i < todos.length; i++) {
            if (todos[i].id == id) {
                todos[i].status = !todos[i].status;
                sta = todos[i].status;
                break;
            }
        }
        let res = await axios.put(`${API_URL}/todos/${id}`,  {
            status : sta
          });

        renderTodos(todos);
    } catch (error) {
        console.log(error);
    }
}

//Xóa todo
const deleteTodo = async id => {
    // console.log(id);
    try {
        // Gọi API
        await axios.delete(`${API_URL}/todos/${id}`);
        todos = todos.filter(x => x.id != id);

        renderTodos(todos);
    } catch (error) {
        console.log(error);
    }
   
}

// cập nhật title 
const updateTitle = async (id, sta) => {
    // console.log(id);
    try {
        // Gọi API
        let res = await axios.put(`${API_URL}/todos/${id}`,  {
            title : document.getElementById('todo-input').value,
            status : sta
          });
        for (let i = 0; i < todos.length; i++) {
            if (todos[i].id == id) {
                todos[i] = res.data;
                break;
            }
        }

        renderTodos(todos);
    } catch (error) {
        console.log(error);
    }
}

//Thêm todo
addBtn.addEventListener("click", async function() {
    try {
        // Gọi API
        let res = await axios.post(`${API_URL}/todos`,  {
            title : document.querySelector("input").value
          });
        todos.push(res.data);

        renderTodos(todos);
    } catch (error) {
        console.log(error);
    }
})

// Vừa vào trang sẽ gọi
getTodos();