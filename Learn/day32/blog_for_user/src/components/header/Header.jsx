import React from 'react'
import { Link } from 'react-router-dom'

function Header() {
  return (
    <>
       <header className="header">
        <nav className="nav">
            <div className="logo"><Link to={"/"} >Hoang.dev</Link>
            </div>
            <ul id="menu">
                <li><Link to={"/search"}><span>Search</span></Link></li>
                <li><Link to={"/tags"} ><span>Tags</span></Link></li>
            </ul>
        </nav>
        </header>
    </>
  )
}

export default Header