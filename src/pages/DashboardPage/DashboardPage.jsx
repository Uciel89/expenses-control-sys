import { useState, useEffect } from "react";

import TopNavbar from "./components/TopNavbar/TopNavbar";
import SidebarComponent from "./components/Sidebar/SidebarComponent";
import { Routes } from "react-router-dom";
import { Route } from "react-router-dom";
import EstablishmentPage from "./views/EstablishmentPage/EstablishmentPage";
import HomePage from "./views/HomePage/HomePage";


function DashboardPage() {
  const [toggled, setToggled] = useState(true);

  const handleOpenToggle = () => {
    setToggled(true);
  };

  const handleCloseToggle = () => {
    setToggled(true);
  };

  return (
    <section className="flex h-screen">
      <SidebarComponent
        toggled={toggled}
        handleCloseToggle={handleCloseToggle}
      />
      <div className="flex flex-col w-full">
        <TopNavbar />
        <Routes>
          <Route path="/dashboard/inicio" element={<HomePage />} />
          <Route path="/dashboard/establecimientos" element={<EstablishmentPage />} />
        </Routes>
      </div>
    </section>
  );
}

export default DashboardPage;
