const address = document.getElementById('address');
const btnSave = document.getElementById('btn-save');

const getProvinces = async() => {
    try {
        // Gọi API
        let res = await axios.get("https://provinces.open-api.vn/api/p/");
        // console.log(res);

        renderProvinces(res.data); // render cac tinh
    } catch (error) {
        console.log(error);
    }
}

const renderProvinces = arr => {
    arr.forEach(t => {
        let option = document.createElement("option");
        option.value = t.name;
        option.innerText = t.name;
        address.appendChild(option);
    });
}

btnSave.addEventListener("click", async function() {
    try {
        let res = await axios.post("http://localhost:8080/api/v1/users", {
            name : document.getElementById('name').value,
            email : document.getElementById('email').value,
            phone : document.getElementById('phone').value,
            address : address.value,
            password : document.getElementById('address').value
        });
        console.log("Tạo user thành công")
        console.log(res);
    } catch (error) {
        console.log(error);
    }
})

getProvinces();