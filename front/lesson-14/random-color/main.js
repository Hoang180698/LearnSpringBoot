const btnRdColorName = document.getElementById('btn-random-color-name');
const colorEl = document.getElementById("color");


// Lắng nghe sự kiện trên từng nút
btnRdColorName.addEventListener("click", async function() {
    try {
        let res = await axios.get("http://localhost:8080/random-color?type=1");
        console.log(res);

        document.body.style.backgroundColor = res.data;
        colorEl.innerHTML = res.data;
    } catch (error) {
        console.log(error);
    }
})

// Lắng nghe trên toàn bộ các nút
const btns = document.querySelectorAll("button");
// for (let i = 0; i < btns.length; i++) {
//     // btns.forEach((btn), index) => btn.addEventListener("click", async () => {

//     // });
//     btns[i].addEventListener("click", async function() {
//         try {
//             let res = await axios.get(`http://localhost:8080/random-color?type=${i + 1}`);
//             console.log(res);
    
//             document.body.style.backgroundColor = res.data;
//             colorEl.innerHTML = res.data;
//         } catch (error) {
//             console.log(error);
//         }
//     }); 
// }

// Nếu type không phải 1, 2, 3 mà là type bất kỳ 2 5 6?
btns.forEach(btn => {
    btn.addEventListener("click", async () => {
        try {
            let type = btn.dataset.type;
            let res = await axios.get(`http://localhost:8080/random-color?type=${type}`);
            console.log(res);
    
            document.body.style.backgroundColor = res.data;
            colorEl.innerHTML = res.data;
        } catch (error) {
            console.log(error);
        }
    } )
})