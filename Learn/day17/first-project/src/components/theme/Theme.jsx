import React, { useState } from "react";

function Theme() {
    const themes = [
        {
            colorHeading: "#2C3639", // light theme
            colorText: "#3F4E4F",
            bg: "#F9F5EB",
        },
        {
            colorHeading: "#EAE3D2", // dark theme
            colorText: "#F9F5EB",
            bg: "#100720",
        },
      ];
    const [theme, setTheme] = useState(0);
    // let themeWeb;
    // if (theme === "light") themeWeb = themes[0];
    // if (theme === "dark") themeWeb = themes[1];
  return (
    <div style={{backgroundColor : themes[theme].bg}}>
      <select value={theme} onChange ={(e) => setTheme(e.target.value)}>
        <option value="0">Light Theme</option>
        <option value="1">Dark Theme</option>
      </select>

      <h2 style={{color : themes[theme].colorHeading}}>Lorem ipsum dolor sit, amet consectetur adipisicing elit.</h2>
      <p style={{color : themes[theme].colorText}}>
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis placeat
        necessitatibus, vitae laboriosam in quos, nesciunt modi error sit porro,
        reprehenderit voluptatem dolore libero incidunt. Illo mollitia fugit
        quam inventore?
      </p>
    </div>
  );
}

export default Theme;
