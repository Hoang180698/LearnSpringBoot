import React, { useState } from "react";

function User() {
  const [data, setData] = useState([
    {
      id: 1,
      name: "Bùi Hiên",
      email: "hien@gmail.com",
      address: "Thái Bình",
    },
    {
      id: 2,
      name: "Thu Hằng",
      email: "hang@gmail.com",
      address: "Hải Dương",
    },
    {
      id: 3,
      name: "Minh Duy",
      email: "duy@gmail.com",
      address: "Hưng Yên",
    },
  ]);
  const [random, setRandom] = useState(Math.floor(Math.random() * data.length));
  const handleRandom = () => {
    let newRandom = random;
    while (newRandom === random) {
      newRandom = Math.floor(Math.random() * data.length);
    }
    setRandom(newRandom);
  };
  const handleRemove = () => {
    const newData = [...data];
    newData.splice(random, 1);
    setData(newData);
    setRandom(Math.floor(Math.random() * newData.length));
  };
  return (
    <>
      {data.length > 0 && (
        <div>
          <h2 style={{ color: "red" }}>{data[random].name}</h2>
          <ul>
            <li>Email: {data[random].email}</li>
            <li>Address: {data[random].address}</li>
          </ul>
          {data.length > 1 && (
            <button onClick={handleRandom}> Random user </button>
          )}
          <button onClick={handleRemove}> Delete user </button>
        </div>
      )}
      {data.length === 0 && <p>Không còn user nào trong danh sách</p>}
    </>
  );
}

export default User;
