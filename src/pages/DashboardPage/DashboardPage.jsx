import React from 'react'
import TopNavbar from './components/TopNavbar/TopNavbar'
import SidebarComponent from './components/Sidebar/SidebarComponent'
import { useState } from 'react'

function DashboardPage() {
  const [toggled, setToggled] = useState(true);

  const handleOpenToggle = () => {
    setToggled(true)
  }

  const handleCloseToggle = () => {
    setToggled(true)
  }

  return (
    <section className='flex h-screen'>
      <SidebarComponent toggled={toggled} handleCloseToggle={handleCloseToggle}/>
      <div className='flex flex-col px-2 py-2'>
        <TopNavbar />
      </div>
    </section>
  )
}

export default DashboardPage