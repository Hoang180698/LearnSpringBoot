import React, { useState } from 'react';
import './App.css';

function App() {
  const colorList = ['#3498db', '#9b59b6', '#e74c3c', '#2c3e50', '#d35400'];
  const [count, setCount] = useState(5);
  const [colors, setColors] = useState(colorList);
  const removeBox = (index) => {
    const newColors = [...colors];
    newColors.splice(index, 1);
    setColors(newColors);
    setCount(count - 1);
  }
  const addBox = () => {
    setColors(colors.concat(colorList));
    setCount(count + 5);
  }
  return (
    <div className="wrap">
        <h1> JS DOM</h1>
        <button id="btn" onClick={addBox}>More boxes</button>
        <h4 id="score"> Total box:<span className="points"> {count}</span></h4>
        <div className="boxes">
          {colors.map((color, index) => (
            <div className='box' style={{backgroundColor : color}} onClick={() => removeBox(index)}>
            </div>
          ))}
        </div>
    </div>
  );
}

export default App;
