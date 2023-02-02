import React, { useEffect, useRef, useState } from "react";
import videoTiktok from "./video.mp4";

const colors = ["red", "green"];
function Blog() {
  const inputRef = useRef();
  const videoRef = useRef();
  const colorRef = useRef();
  const [color, setColor] = useState("red");
  const play = () => {
    videoRef.current.play();
  };

  const pause = () => {
    videoRef.current.pause();
  };

  // Random 1 color trong mang mau ben tren
  // Mỗi lần random không được trùng với màu đang co trong state
  const randomColor = () => {
    while (true) {
        let newColor = colors[Math.floor(Math.random() * colors.length)];
        if (newColor !== colorRef.current.style.backgroundColor) {
            setColor(newColor);
            break;
        }
    }
    console.log(colorRef.current.style.backgroundColor)
  }

  console.log(inputRef);
  useEffect(() => {
    console.log(inputRef);
    inputRef.current.focus();
  }, []);
  return (
    <>
      <h1>useRef() Hook</h1>

      <input type="text" placeholder="Enter name..." ref={inputRef}></input>

      <hr />

      <video src={videoTiktok} style={{ height: 400 }} ref={videoRef}></video>
      <button onClick={play}>Play</button>
      <button onClick={pause}>Pause</button>
      <hr />
      <div
        style={{
          height: 200,
          width: 200,
          border: "1px solid black",
          backgroundColor: color,
        }}
        ref={colorRef}
      ></div>
      <button onClick={randomColor}>Random background color</button>
    </>
  );
}

export default Blog;
