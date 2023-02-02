import { cleanup } from '@testing-library/react';
import React, { useEffect, useState } from 'react'

function Menu() {
    const [time, setTime] = useState(() => {
        let now = new Date();
        return now.toLocaleString();
    });
    useEffect(() => {
        const handleScroll = () => {
            console.log("scroll event")
        };

        window.addEventListener("scroll", handleScroll);

        // Clean up
        return () => {
            window.removeEventListener("scroll", handleScroll);
        }
    },[]);

    // Timer - setInterval
    useEffect(() => {
        const interval = setInterval(() => {
            console.log("interval");
            let now = new Date();
            setTime(now.toLocaleString());
        }, 1000);
        
    // clean up
        return () => {
            clearInterval(interval);
        }
    },[]);

    
  return (
    <div>
        <h1>Menu component</h1>
        <h2>Time : {time}</h2>
    </div>
  )
}

export default Menu