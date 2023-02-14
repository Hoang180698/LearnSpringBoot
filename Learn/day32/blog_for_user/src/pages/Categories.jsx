import React from "react";
import { Link } from "react-router-dom";
import { useGetCategoriesQuery } from "../app/services/categories.service";

function Categories() {
  const { data: categories, isLoading } = useGetCategoriesQuery();
  if (isLoading) {
    return <h2>Loading ...</h2>;
  }
  return (
    <>
      <h1>Tags</h1>
      <ul class="terms-tags top-tags">
        {categories.map((c) => (
          <li>
            <Link to={`/categories/${c.name}`}>
              {c.name}
              <sup>
                <strong>
                  <sup>{c.used}</sup>
                </strong>
              </sup>
            </Link>
          </li>
        ))}
      </ul>
    </>
  );
}

export default Categories;
