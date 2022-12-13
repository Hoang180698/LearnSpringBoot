const getBtn = document.getElementById("get-btn");
const postBtn = document.getElementById("post-btn");
const bmi = document.getElementById("bmi");

getBtn.addEventListener("click", async function() {
    try {
        let res = await axios.get("http://localhost:8080/bmi-get", {
            params : {
                height : document.getElementById("height").value,
                weight : document.getElementById("weight").value
            }
        });              

        console.log(res);
        bmi.innerHTML = res.data;

    } catch (error) {
        console.log(error);
    }
})

postBtn.addEventListener("click", async function() {
    try {
        let res = await axios.post('http://localhost:8080/bmi-post', {
            height : document.getElementById("height").value,
            weight : document.getElementById("weight").value
          });

        console.log(res);
        bmi.innerHTML = res.data;

    } catch (error) {
        console.log(error);
    }
})