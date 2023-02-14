import React from "react";
import { Route, Routes } from "react-router-dom";
import Layout from "./components/layout/Layout";
import BlogDetail from "./pages/BlogDetail";
import BlogsCategory from "./pages/BlogsCategory";
import Categories from "./pages/Categories";
import Home from "./pages/Home";
import Search from "./pages/Search";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route index element={<Home />}></Route>
        <Route path="search" element={<Search />}></Route>
        <Route path="tags" element={<Categories />}></Route>
        <Route path=":blogId/:blogSlug" element={<BlogDetail />}></Route>
        <Route path="categories/:nameTag" element={<BlogsCategory/>}></Route>
      </Route>
    </Routes>
  );
}

export default App;
