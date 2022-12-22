import React, { useState } from "react";

function List() {
  const [isShow, setIsShow] = useState(true);
  const [item, setItem] = useState("");
  const [items, setItems] = useState(["Item 1", "Item 2", "Item 3"]);
  const handleRemove = () => {
    if (items.length === 0) {
      alert("khong con gi de xoa");
    } else {
      // const newItems = [...items];
      // newItems.pop();
      // setItems(newItems);
      const newItems = items.slice(0, items.length - 1);
      setItems(newItems);
    }
  };
  const handleAdd = () => {
    if (item === "") {
      alert("tiêu đề không được để trống");
    } else {
      setItems([...items, item]);
      setItem("");
    }
  };
  const handleToggle = () => {
   setIsShow(!isShow)
  };
  return (
    <>
      <button onClick={handleToggle}>{isShow ? "Hide" : "Show"}</button>

      <input
        type="text"
        value={item}
        placeholder="Enter title..."
        onChange={(e) => setItem(e.target.value)}
      />
      <button onClick={handleAdd}>Add</button>

      <button onClick={handleRemove}>Remove</button>
      {isShow && (
        <ul>
          {items.map((item, index) => (
            <li key={index}>{item}</li>
          ))}
        </ul>
      )}
    </>
  );
}

export default List;
