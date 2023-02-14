import React from 'react'
import { Outlet } from 'react-router-dom'
import Header from '../header/Header'

function Layout() {
  return (
    <>
     <Header />
     <main className="main">
        <Outlet />
    </main>
    </>
  )
}

export default Layout