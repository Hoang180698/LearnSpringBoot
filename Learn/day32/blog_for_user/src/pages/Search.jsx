import React, { useState } from "react";
import { Link } from "react-router-dom";
import { useGetBlogsByKeywordQuery } from "../app/services/blogs.service";
import { formatDate } from "../utils/functionUtils";

function Search() {
  const [keyword, setKeyword] = useState("");

  const { data : blogs, isLoading } = useGetBlogsByKeywordQuery(keyword);

  if (isLoading) {
    return <h2>Loading ...</h2>;
  }

  return (
    <>
      <header class="page-header">
        <h1>
          Search
        </h1>
        <div class="post-description">Tìm kiếm bài viết</div>
        <div class="post-meta"></div>
      </header>
      <div id="searchbox">
        <input
          id="searchInput"
          autofocus
          placeholder="Tìm kiếm bài viết"
          aria-label="search"
          type="search"
          autocomplete="off"
          value={keyword}
          onChange={(e) => setKeyword(e.target.value)}
        />
        <ul id="searchResults" aria-label="search results"></ul>
      </div>
      {(blogs.length > 0 && keyword !== "") &&
        blogs.map((b) => (
          <Link to={`/${b.id}/${b.slug}`}>
            <article className="post-entry">
              <header className="entry-header">
                <h4>{b.title}</h4>
              </header>
            </article>
          </Link>
        ))}
    </>
  );
}

export default Search;
