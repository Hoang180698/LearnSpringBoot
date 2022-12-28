import React, { useState } from 'react'
import "./shopping.css"
function Shopping() {
    const [products, setProducts] = useState([
        {
            id: 1,
            name: "Sản phẩm 1",
            image: "https://images.unsplash.com/photo-1523381294911-8d3cead13475?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGNsb3RoZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
            price: 300000,
            count: 1,
            size : "M"
         },
         {
            id: 2,
            name: "Sản phẩm 2",
            image: "https://images.unsplash.com/photo-1612423284934-2850a4ea6b0f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjl8fGNsb3RoZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
            price: 400000,
            count: 1,
            size : "L"
         },
         {
            id: 3,
            name: "Sản phẩm 3",
            image: "https://images.unsplash.com/photo-1564584217132-2271feaeb3c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fGNsb3RoZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
            price: 500000,
            count: 1,
            size : "XL"
         }
      ]);

    // Tăng số lượng sản phẩm
    const handleAdd = (id) => {
        const newProducts = products.map((p) => {
            if (p.id === id) {
                return {...p, count: p.count + 1}
            }
            return p;
        })
        setProducts(newProducts);
    }
    
    // Giảm số lượng sản phẩm
    const handleSub = (id) => {
        const newProducts = products.map((p) => {
            if (p.id === id) {
                if (p.count === 1) {
                    alert("Số lượng sản phẩm phải lớn hơn 1");
                    return p;
                }
                return {...p, count: p.count - 1}
            }
            return p;
        })
        setProducts(newProducts);
    }
    
    // Xóa sản phẩm khỏi cart
    const handleRemove = (index) => {
        let isWant = window.confirm("Bạn có muốn xóa sản phẩm này không");
        if (isWant) {
            const newProducts = [...products];
            newProducts.splice(index, 1)
            setProducts(newProducts);
        }
    }

    // Tính giá tiền
    const subtotal = products.reduce((a, b) => a + b.price * b.count, 0);

  return (
    <>
      <div className="shopping-cart-container mt-5">
        <div className="container">
            <div className="row">
                <div className="col-md-12">
                    <div className="mb-4">
                        <h2>Shopping Cart</h2>
                    </div>
                </div>
            </div>

            {products.length ===0 && <p className="fst-italic message">Không có sản phẩm trong giỏ hàng</p>}
            <div className="row shopping-cart">
                <div className="col-md-8">
                    <div className="product-list">
                        {products.length > 0 && products.map((product, index) => (
                            <div className="product-item d-flex border mb-4" key={product.id}>
                            <div className="image">
                                <img src={product.image} alt={product.name} />
                            </div>
                            <div className="info d-flex flex-column justify-content-between px-4 py-3 flex-grow-1">
                                <div>
                                    <div className="d-flex justify-content-between align-items-center">
                                        <h2 className="text-dark fs-5 fw-normal">
                                            {product.name} ({product.size})
                                        </h2>
                                        <h2 className="text-danger fs-5 fw-normal">
                                            {product.price} VND
                                        </h2>
                                    </div>
                                    <div className="text-black-50">
                                        <div className="d-inline-block me-3">
                                            <button className="border py-2 px-3 d-inline-block fw-bold bg-light" onClick={() => handleSub(product.id)}>-</button>
                                            <span className="py-2 px-3 d-inline-block fw-bold">{product.count}</span>
                                            <button className="border py-2 px-3 d-inline-block fw-bold bg-light" onClick={() => handleAdd(product.id)}>+</button>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <button className="text-primary border-0 bg-transparent fw-light" onClick={() => handleRemove(index)}>
                                        <span><i className="fa-solid fa-trash-can"></i></span>
                                        Xóa
                                    </button>
                                </div>
                            </div>
                        </div>
                        ))}
                    </div>
                </div>
                <div className="col-md-4">
                    <div className="bill">
                        <div className="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                            <span className="text-black-50">Tạm tính:</span>
                            <span className="text-primary" id="sub-total-money">{subtotal} VND</span>
                        </div>
                        <div className="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                            <span className="text-black-50">VAT (10%):</span>
                            <span className="text-primary" id="vat-money">{subtotal/10} VND</span>
                        </div>
                        <div className="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
                            <span className="text-black-50">Thành tiền:</span>
                            <span className="text-primary" id="total-money">{subtotal + subtotal/10}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </>
  )
}

export default Shopping