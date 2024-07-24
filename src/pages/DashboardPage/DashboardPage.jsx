import { useState, useEffect } from "react";
import { Routes, Route, Navigate } from "react-router-dom";

import TopNavbar from "./components/TopNavbar/TopNavbar";
import SidebarComponent from "./components/Sidebar/SidebarComponent";
import EstablishmentPage from "./views/EstablishmentPage/EstablishmentPage";
import ExpensesPage from './views/ExpensesPage/ExpensesPage';
import MetricsPage from './views/MetricsPage/MetricsPage';
import MovementListPage from './views/MovementPage/pages/MovementListPage/MovementListPage'
import HomePage from "./views/HomePage/HomePage";
import ReceiptsPage from "./views/ReceiptspPage/ReceiptsPage";



function DashboardPage() {
  const [toggled, setToggled] = useState(false);

  const handleOpenToggle = () => {
    setToggled(true);
    console.log('hola');
  };

  const handleCloseToggle = () => {
    setToggled(false);
  };

  return (
    <section className="flex h-screen bg-gray-200">
      <SidebarComponent
        toggle={toggled}
        handleCloseToggle={handleCloseToggle}
      />
      <div className="flex flex-col w-full">
        <TopNavbar handleOpenToggle={handleOpenToggle}/>
        <div className=" dark:bg-slate-950 p-2 dark:text-gray-50 h-screen">
          <Routes>
            <Route path="inicio" element={<HomePage />} />
            <Route path="establecimientos" element={<EstablishmentPage />} />
            <Route path="ingresos" element={<ReceiptsPage />} />
            <Route path="gastos" element={<ExpensesPage />} />
            <Route path="metricas" element={<MetricsPage />} />
            <Route path="movimientos" element={<MovementListPage />} />
            <Route path="*" element={<Navigate to="/dashboard/inicio" />} />
          </Routes>
        </div>
      </div>
    </section>
  );
}

export default DashboardPage;
