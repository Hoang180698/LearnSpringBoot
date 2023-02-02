import React, { useState } from "react";
import { faker } from "@faker-js/faker";
const orders = [
  { id: 1, total: 100000 },
  { id: 2, total: 200000 },
  { id: 3, total: 300000 },
];
function Content() {
  // Tính toán phức tạp, cần thời gian thực hiện
  const [total, setTotal] = useState(() => {
    return orders.reduce((a, b) => a + b.total, 0);
  });

  const [count, setCount] = useState(0);
  const [products, setProducts] = useState([
    { id: 1, name: "sản phẩm 1", price: 10000 },
    { id: 2, name: "sản phẩm 2", price: 20000 },
    { id: 3, name: "sản phẩm 1", price: 30000 },
  ]);
  const [user, setUser] = useState({
    id: 1,
    name: "Bùi Hiên",
    email: "hien@gmail.com",
  });

  const increment = () => {
    setCount(count + 1); // Bất đồng bộ
    console.log(count);
  };

  const decrement = () => {
    setCount((count) => count - 1); // state mới được tính toán từ state cũ
    setCount((count) => count - 1);
    setCount((count) => count - 1);
  };
  const updatePrice = () => {
    const productId = 1;
    const newPrice = Math.floor(Math.random() * (50000 - 10000 + 1)) + 10000;

    const newProduct = products.map((p) => {
      if (p.id === productId) {
        return { ...p, price: newPrice };
      }
      return p;
    });
    setProducts(newProduct);
  };
  const updateName = () => {
    const randomName = faker.name.fullName();
    setUser({ ...user, name: randomName });
  };
  return (
    <>
      {console.log("render")}
      <h2>Total: {total}</h2>

      <h1>Count : {count}</h1>
      <button onClick={increment}>Increment</button>
      <button onClick={decrement}>Decrement</button>

      <hr />

      <h2>Danh sách sản phẩm</h2>
      <ul>
        {products.map((p) => (
          <li key={p.id}>
            {p.id}-{p.name}-{p.price}
          </li>
        ))}
      </ul>

      <button onClick={updatePrice}>Update price</button>

      <hr />

      <h2>Thông tin user</h2>
      <p>Id : {user.id}</p>
      <p>Name: {user.name}</p>
      <p>email: {user.email}</p>
      <button onClick={updateName}>Update name</button>
    </>
  );
}

export default Content;
