import React from "react";
import { Link, useParams } from "react-router-dom";
import { useGetBlogsQuery } from "../app/services/blogs.service";
import { formatDate } from "../utils/functionUtils";

function BlogsCategory() {
  const { data: blogs, isLoading } = useGetBlogsQuery();

  const tagName = useParams();

  if (isLoading) {
    return <h2>Loading ...</h2>;
  }
  return (
    <>

      <h1>{tagName.nameTag}</h1>
      <br />

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

export default BlogsCategory;
