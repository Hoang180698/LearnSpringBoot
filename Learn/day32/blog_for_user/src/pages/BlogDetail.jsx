import React from 'react'
import { useParams } from 'react-router-dom';
import { useGetBlogByIdQuery } from '../app/services/blogs.service';
import { formatDate } from '../utils/functionUtils';

function BlogDetail() {
    const { blogId } = useParams();
    const { data: blog, isLoading } = useGetBlogByIdQuery(blogId);
    console.log(blog)
    if (isLoading) {
        return <h2>Loading...</h2>
    }
  return (
    <>
        <article className="post-single">
            <header className="post-header">
                <h1 className="post-title">{blog.title}</h1>
                <div className="post-meta"><span>{formatDate(blog.publishedAt)}</span>
                </div>
            </header>
            <div className='post-content'>
                {blog.content}
            </div>
        </article>
    </>
  )
}

export default BlogDetail