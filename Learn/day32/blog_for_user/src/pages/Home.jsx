import React, { useEffect } from "react";
import { Link } from "react-router-dom";
import { useGetBlogsQuery } from "../app/services/blogs.service";
import { useGetCategoriesQuery } from "../app/services/categories.service";
import { formatDate } from "../utils/functionUtils";

function Home() {
  const { data : blogs, isLoading } = useGetBlogsQuery();

  const { data : categories } = useGetCategoriesQuery();

  // useEffect(() => {
    
  // },[])
  // console.log(categories);
  // console.log(data);
  if (isLoading) {
    return <h2>Loading ...</h2>;
  }
  return (
    <>
      <header className="entry-header">
        <h1>
          <span>🐈</span> Blog app <span>🐈</span>
        </h1>
        <br />
      </header>
     
      <ul class="terms-tags top-tags"> 
      {categories.map((c) => (
        <li><Link to={`/categories/${c.name}`}>{c.name}<sup><strong><sup>{c.used}</sup></strong></sup></Link></li>
      ))} 
      </ul>
      {blogs.length > 0 &&
        blogs.map((b) => (
          <Link to={`/${b.id}/${b.slug}`}>
            <article className="post-entry">
              <header className="entry-header">
                <h2>{b.title}</h2>
              </header>
              <div className="entry-content">{b.content}</div>
              <footer className="entry-footer">
                <span>{formatDate(b.publishedAt)}</span>
              </footer>
            </article>
          </Link>
        ))}
    </>
  );
}

export default Home;
