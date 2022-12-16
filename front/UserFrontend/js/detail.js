const API_URL = "http://localhost:8080/api/v1";
const fullname = document.getElementById('fullname');
const email = document.getElementById('email');
const phone = document.getElementById('phone');
const address = document.getElementById('address');
const update = document.getElementById('btn-save');
const updatePass = document.getElementById('btn-change-password');
const btnForgotPass = document.getElementById('btn-forgot-password');

// lấy id qua url
let url_wed = window.location.href;
let url = new URL(url_wed);
let search_params = url.searchParams; 
let id = search_params.get('id');

if (!id) {
    window.location.href = "./404.html";
}

let user;

const getProvinces = async() => {
    try {
        let res = await axios.get("https://provinces.open-api.vn/api/p/");
        // console.log(res);

        renderProvinces(res.data);
    } catch (error) {
        console.log(error);
    }
}
const renderProvinces = arr => {
    arr.forEach(t => {
        let option = document.createElement("option");
        option.value = t.name;
        option.innerText = t.name;
        if (user.address == t.name) {
            option.selected = true;
        }
        address.appendChild(option);
    });
}

const getUser = async() => {
    try {
        // Gọi API
        let res = await axios.get(`${API_URL}/users/${id}`);
        console.log(res);
        user = res.data; 

        renderUser(user);
    } catch (error) {
        console.log(error);
    }
}
const renderUser = user => {
    fullname.value = user.name;
    email.value = user.email;
    phone.value = user.phone;
}

// cập nhật thông tin
update.addEventListener("click", async function() {
    try {
        let res = await axios.put(`${API_URL}/users/${id}`, {
            name : fullname.value,
            phone : phone.value,
            address : address.value
        });
        console.log("Cập nhật thành công")
        console.log(res);
    } catch (error) {
        console.log(error);
    }
})

// cập nhật password
updatePass.addEventListener("click", async function() {
    try {
        res = await axios.put(`${API_URL}/users/${id}/update-password`, {
            oldPassword : document.getElementById('old-password').value,
            newPassword : document.getElementById('new-password').value
        });
        console.log(res);
    } catch (error) {
        console.log(error);
    }
})

// quên password
btnForgotPass.addEventListener("click", async function() {
    try {
        res = await axios.post(`${API_URL}/users/${id}/forgot-password`);
        console.log(res.data);
    } catch (error) {
        console.log(error);
    }
})

getUser();
getProvinces();


// Truy cập
const imageContainerEl = document.querySelector(".image-container");
// Quản lý ảnh
let images = [];

const getImages = async () => {
    try {
        let res = await axios.get(`${API_URL}/users/${id}/files`);
        console.log(res);

        images = res.data;
        renderPaginationAndRenderImg(images);
    } catch (error) {
        console.log(error);
    }
}

// Hiển thị trên UI
const renderImages = arr => {
    imageContainerEl.innerHTML = "";
    let html = "";
    arr.forEach(i => {
        html += `
            <div class="image-item">
                <img src="http://localhost:8080${i}" alt="ảnh">
            </div>
        `
    });
    imageContainerEl.innerHTML = html;
}
// Phân Trang
const renderPaginationAndRenderImg = arr => {
    $('.pagination-container').pagination({
        dataSource: arr,
        pageSize : 8,
        callback: function(data, pagination) {
           console.log(data);
           console.log(pagination);
           renderImages(data);
        }
    })
}

getImages();
