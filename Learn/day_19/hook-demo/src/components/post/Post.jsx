import axios from "axios";
import React, { useEffect, useState } from "react";

/*
useEffect(callback, dependences)

-TH1 : useEffect(callback) : Được gọi sau mỗi lần rerender
-TH2 : useEffect(callback, []) : Chỉ được gọi 1 lần duy nhất sau lần render đầu tiên
-TH3 : useEffect(callback, [deps]): Được gọi khi deps thay đổi giá trị

Đặc điểm chung : Đều chạy sau lần render đầu tiên
*/

function Post() {
  const [count, setCount] = useState(0);
  const [count1, setCount1] = useState(0);
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [type, setType] = useState("posts");

  // TH1: useEffect(callback)
  //   useEffect(() => {
  //     console.log("useEffect(callback)");
  //   })

  // TH2 : useEffect(callback, [])
  //   useEffect(() => {
  //     console.log("useEffect(callback, [])");
  //   }, []);

  //TH3 : useEffect(callback, [deps]);
  //   useEffect(() => {
  //     console.log("useEffect(callback, [deps])");
  //   }, [count]);

  useEffect(() => {
    const getPosts = async () => {
      try {
        setLoading(true);
        let res = await axios.get(
          `https://jsonplaceholder.typicode.com/${type}`
        );
        console.log(res);

        setPosts(res.data);

        setTimeout(() => {
          setLoading(false);
        }, 500);
      } catch (error) {
        console.log(error);
      }
    };

    getPosts();
  }, [type]);

  const increment = () => {
    setCount(count + 1);
  };
  const decrement = () => {
    setCount(count - 1); // state mới được tính toán từ state cũ
  };

  const increment1 = () => {
    setCount1(count1 + 1);
  };
  const decrement1 = () => {
    setCount1(count1 - 1); // state mới được tính toán từ state cũ
  };

  if (loading) {
    return <h2>Loading ...</h2>;
  }
  return (
    <>
      {console.log("render")}
      <h1>Count : {count}</h1>
      <button onClick={increment}>Increment</button>
      <button onClick={decrement}>Decrement</button>
      <hr />

      <h1>Count : {count1}</h1>
      <button onClick={increment1}>Increment</button>
      <button onClick={decrement1}>Decrement</button>
      <hr />

      <h2>Type: {type}</h2>
      {/* <button
        onClick={() => setType("posts")}
        style={type === "posts" ? { backgroundColor: "red" } : {}}
      >
        posts
      </button>
      <button
        onClick={() => setType("comments")}
        style={type === "comments" ? { backgroundColor: "red" } : {}}
      >
        comments
      </button>
      <button
        onClick={() => setType("albums")}
        style={type === "albums" ? { backgroundColor: "red" } : {}}
      >
        allbums
      </button> */}

      {["posts", "comments", "albums"].map((ele, i) => (
        <button
          key={i}
          onClick={() => setType(ele)}
          style={type === ele ? { backgroundColor: "red" } : {}}
        >
          {ele}
        </button>
      ))}

      <ul>
        {posts.map((p) => (
          <li key={p.id}>{p.title || p.body}</li>
        ))}
      </ul>
    </>
  );
}

export default Post;
