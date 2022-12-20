import React, { useState } from 'react'
import "./Counter.css"

// Vòng đời
// Mounting : Quá trình component được gắn vào Dom (1 lần)
// Updating : Quá trình component được render lại (re-render) (nhiều lần)
// Unmounting : Quá trình component được xóa khỏi Dom (1 lần)
function Counter() {
    const [count, setCount] = useState(10);
    const decrement = () => {
        setCount(count - 1)
    };
    const increment = () => {
        setCount(count + 1);
    };
    return (
        <div className="main-container">
            {console.log("render")}
            <h1 className="title">Đếm số</h1>
            <h1 id="counter" style={{ color: "#333333" }}>{count}</h1>
            <div className="btn-container">
                <button className="btn counterBtn prevBtn" onClick={decrement}>Trừ</button>
                <button className="btn counterBtn nextBtn" onClick={increment}>Cộng</button>
            </div>
         </div>
  )
}

export default Counter