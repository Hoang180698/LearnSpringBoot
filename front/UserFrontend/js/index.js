const API_URL = "http://localhost:8080/api/v1";
const usersInfo = document.getElementById("users");
const search = document.getElementById("search")

let users = [];

const getUsers = async() => {
    try {
        let res = await axios.get(`${API_URL}/allUsers`);
        console.log(res);
        users = res.data;

        // Hiện thị lên trên giao diện
        renderUser(users);
    } catch (error) {
        console.log(error);
    }
}

// render danh sach user
const renderUser = arr => {
    usersInfo.innerHTML = "";
    let html = "";
    arr.forEach((ele, i) => {
        html += `
        <tr>
            <td>${i + 1}</td>
            <td>${ele.name}</td>
            <td>${ele.email}</td>
            <td>${ele.phone}</td>
            <td>${ele.address}</td>
            <td>
            <a href="./detail.html?id=${ele.id}" class="btn btn-success">Xem chi tiết</a>
            <button onclick="deleteUser(${arr[i].id})" class="btn btn-danger">Xóa</button>
            </td>
        </tr>
    `     
    });
    usersInfo.innerHTML = html;
}

const deleteUser = async id => {
    try {
        await axios.delete(`${API_URL}/users/${id}`);
        users = users.filter(x => x.id != id);
    
        renderUser(users);
    } catch (error) {
        console.log(error);
    }
  
}

// chuc nang tim kiem
search.addEventListener("keydown", async function(event) {
    console.log(event);
    if (event.key == "Enter") {
        try {
            let name = document.querySelector('input').value;
            let res = await axios.get(`${API_URL}/search?name=${name}`);
            console.log(res);
            users = res.data;
    
            renderUser(users);
        } catch (error) {
            console.log(error);
        }
    }
});

getUsers();