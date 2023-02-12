import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { deleteUser, getAllUser, getUserByName } from "../../app/slices/user.slice";

function UserList() {
  const users = useSelector((state) => state.user);
  const dispatch = useDispatch();

  const [title, setTitle] = useState("");

  useEffect(() => {
    dispatch(getAllUser());
  }, []);

    // tim kiem theo ten  
  const handleSearch = (event) => {
    if(event.key === 'Enter') {
        dispatch(getUserByName(title));
    }
  }
  const handleDeleteUser = (id) =>{
    dispatch(deleteUser(id));
  } 
  return (
    <>
      <div className="container mt-5 mb-5">
        <h2 className="text-center text-uppercase">Danh sách user</h2>

        <div className="row justify-content-center">
          <div className="col-md-10">
            <div className="d-flex justify-content-between align-items-center mt-5 mb-4">
              <Link to={"/users/create"} href="./create.html" className="btn btn-warning">
                Tạo user
              </Link>
              <input
                type="text"
                id="search"
                className="form-control w-50"
                placeholder="Tìm kiếm user"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
                onKeyDown={handleSearch}
              />
            </div>

            <div className="bg-light p-4">
              <table className="table table-hover">
                <thead>
                  <tr>
                    <th>STT</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th></th>
                  </tr>
                </thead>

                <tbody id="users">
                  {users.length === 0 && (
                    <tr>Không có user nào trong danh sách</tr>
                  )}
                  {users.length > 0 &&
                    users.map((user, index) => (
                      <tr>
                        <td>{index}</td>
                        <td>{user.name}</td>
                        <td>{user.email}</td>
                        <td>{user.phone}</td>
                        <td>{user.address}</td>
                        <td>
                          <a
                            href="./detail.html?id=2"
                            className="btn btn-success"
                          >
                            Xem chi tiết
                          </a>
                          <button className="btn btn-danger" onClick={() => handleDeleteUser(user.id)}>Xóa</button>
                        </td>
                      </tr>
                    ))}
                </tbody>
              </table>

              <p className="message d-none"></p>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default UserList;
