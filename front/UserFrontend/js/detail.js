const API_URL = "http://localhost:8080/api/v1";
const fullname = document.getElementById('fullname');
const email = document.getElementById('email');
const phone = document.getElementById('phone');
const address = document.getElementById('address');
const update = document.getElementById('btn-save');
const updatePass = document.getElementById('btn-change-password');
const btnForgotPass = document.getElementById('btn-forgot-password');
const avatarPreviewEl = document.getElementById('avatar-preview');
const avatar = document.getElementById("avatar");

const modalImageEl = new bootstrap.Modal(document.getElementById('modal-image'), {
    keyboard: false
  })

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
        if (user.address === t.name) {
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
    avatarPreviewEl.src = `http://localhost:8080${user.avatar}`;
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
const btnChoseImage = document.getElementById("btn-chose-image");
const btnDeleteImage = document.getElementById("btn-delete-image");
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
            <div class="image-item" onclick="choseImage(this)">
                <img src="http://localhost:8080${i}" alt="ảnh" data-url=${i}>
            </div>
        `
    });
    imageContainerEl.innerHTML = html;
}

// Phân Trang
const renderPaginationAndRenderImg = arr => {
    $('.pagination-container').pagination({
        dataSource: arr,
        pageSize : 4,
        callback: function(data, pagination) {
           console.log(data);
           console.log(pagination);
           renderImages(data);
           btnChoseImage.disabled = true;
           btnDeleteImage.disabled = true;
        }
    })
}

// Chọn 1 hình ảnh
const choseImage = (imageEl) => { 
    // Xóa ảnh được active trước đó nếu có
    const imageActiveEl = document.querySelector(".image-active");
    if(imageActiveEl) {
        imageActiveEl.classList.remove("image-active")
    }
     // highlight được hình ảnh
    imageEl.classList.add("image-active");
    //actve nut chức năng
    btnChoseImage.disabled = false;
    btnDeleteImage.disabled = false;
}

// Xóa ảnh
btnDeleteImage.addEventListener("click", async () => {
    try {
        const imageActiveEl = document.querySelector(".image-active img");
        if (!imageActiveEl) return;

        const url = imageActiveEl.src;
        console.log(url);

        // Xóa trên server
        await axios.delete(url);

        // Xóa trên client
        // http://localhost:8080/api/v1/users/1/files/1671191936
        // /api/v1/users/1/files/1671191936
        // /api/v1/users/1/files/1671191937
        // /api/v1/users/1/files/1671191938
        images = images.filter(i => !url.includes(i))

        // Render lại image
        renderPaginationAndRenderImg(images);
    } catch (error) {
        console.log(error)
    }
})

// update avatar

btnChoseImage.addEventListener("click", async () => {
    try {
        const imageActiveEl = document.querySelector(".image-active img");
        if (!imageActiveEl) return;

        const url = imageActiveEl.dataset.url;
        console.log(url);

        await axios.put(`${API_URL}/users/${id}/update-avatar`, {
            avatar : url
        });
        avatarPreviewEl.src = `http://localhost:8080${url}`
        // Render lại image
        
        // Đóng modal
        modalImageEl.hide();
    } catch (error) {
        console.log(error)
    }
})

//upload ảnh
avatar.addEventListener("change", async (e) => {
    try {
        // Lấy ra file upload
        const file = e.target.files[0];
        console.log(file);

        // Tạo đối tượng form data
        const formData = new FormData();
        formData.append("file", file);

        // Gọi API
        const res = await axios.post(`${API_URL}/users/${id}/files`, formData);

        // Cập nhật UI
        images.unshift(res.data);
        renderPaginationAndRenderImg(images);

    } catch (error) {
        console.log(error)
    }
})

getImages();
