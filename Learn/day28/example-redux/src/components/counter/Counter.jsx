import React from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { decrement, increment } from '../../app/actions/counterActions';

function Counter() {
    // Lấy ra được dữ liệu từ store và hiển thị
    const counter = useSelector(state => state.counter.value);
    console.log(counter)
    const dispatch = useDispatch();

    // Sử dụng để gửi action lên store để xử lý
    const handleDecrement = () => {
        dispatch(decrement())
    };
    const handleIncrement = () => {
        dispatch(increment());
    };
  return (
    <>
        <h1>Counter : {counter}</h1>
        <button onClick={handleDecrement}> - </button>
        <button onClick={handleIncrement}> + </button>
    </>
  )
}

export default Counter