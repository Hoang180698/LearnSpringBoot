import React from "react";
import { Link } from "react-router-dom";
import { useGetBlogsQuery } from "../../app/services/blogs.service";
import { formatDate } from "../../utils/functionUtils";

function BlogList() {
    const { data, isLoading } = useGetBlogsQuery();

    if (isLoading) {
        return <h2>Loading ...</h2>;
    }

    return (
        <div className="container-fluid">
            <div className="row py-2">
                <div className="col-12">
                    <button type="button" className="btn btn-primary">
                        <i className="fas fa-plus"></i> Viết bài
                    </button>
                    <button type="button" className="btn btn-info">
                        <i className="fas fa-redo"></i> Refresh
                    </button>
                </div>
            </div>
            <div className="row">
                <div className="col-12">
                    <div className="card">
                        <div className="card-body">
                            <table className="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Tiêu đề</th>
                                        <th>Tác giả</th>
                                        <th>Danh mục</th>
                                        <th>Trạng thái</th>
                                        <th>Ngày tạo</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {data.length > 0 &&
                                        data.map((b) => (
                                            <tr key={b.id}>
                                                <td>
                                                    <Link to={`/admin/blogs/${b.id}`}>{b.title}</Link>
                                                </td>
                                                <td>
                                                    <Link to={`/admin/users/${b.user.id}`}>{b.user.name}</Link>
                                                </td>
                                                <td>
                                                    {b.categories.map(c => c.name).join(", ")}
                                                </td>
                                                <td>{b.status ? "Công khai" : "Nháp"}</td>
                                                <td>{formatDate(b.createdAt)}</td>
                                            </tr>
                                        ))}
                                </tbody>
                            </table>

                            <div
                                className="d-flex justify-content-center mt-3"
                                id="pagination"
                            >
                                <ul className="pagination mb-0">
                                    <li
                                        className="paginate_button page-item previous disabled"
                                        id="example2_previous"
                                    >
                                        <a
                                            href="#"
                                            aria-controls="example2"
                                            data-dt-idx="0"
                                            tabIndex="0"
                                            className="page-link"
                                        >
                                            Previous
                                        </a>
                                    </li>
                                    <li className="paginate_button page-item active">
                                        <a
                                            href="#"
                                            aria-controls="example2"
                                            data-dt-idx="1"
                                            tabIndex="0"
                                            className="page-link"
                                        >
                                            1
                                        </a>
                                    </li>
                                    <li className="paginate_button page-item">
                                        <a
                                            href="#"
                                            aria-controls="example2"
                                            data-dt-idx="2"
                                            tabIndex="0"
                                            className="page-link"
                                        >
                                            2
                                        </a>
                                    </li>
                                    <li className="paginate_button page-item">
                                        <a
                                            href="#"
                                            aria-controls="example2"
                                            data-dt-idx="3"
                                            tabIndex="0"
                                            className="page-link"
                                        >
                                            3
                                        </a>
                                    </li>
                                    <li className="paginate_button page-item">
                                        <a
                                            href="#"
                                            aria-controls="example2"
                                            data-dt-idx="4"
                                            tabIndex="0"
                                            className="page-link"
                                        >
                                            4
                                        </a>
                                    </li>
                                    <li className="paginate_button page-item">
                                        <a
                                            href="#"
                                            aria-controls="example2"
                                            data-dt-idx="5"
                                            tabIndex="0"
                                            className="page-link"
                                        >
                                            5
                                        </a>
                                    </li>
                                    <li className="paginate_button page-item">
                                        <a
                                            href="#"
                                            aria-controls="example2"
                                            data-dt-idx="6"
                                            tabIndex="0"
                                            className="page-link"
                                        >
                                            6
                                        </a>
                                    </li>
                                    <li
                                        className="paginate_button page-item next"
                                        id="example2_next"
                                    >
                                        <a
                                            href="#"
                                            aria-controls="example2"
                                            data-dt-idx="7"
                                            tabIndex="0"
                                            className="page-link"
                                        >
                                            Next
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default BlogList;
