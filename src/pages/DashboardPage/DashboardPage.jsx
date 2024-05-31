import { useState, useEffect } from "react";

import { getCuentasRequest } from '../../services/cuenta.service'

import TopNavbar from "./components/TopNavbar/TopNavbar";
import SidebarComponent from "./components/Sidebar/SidebarComponent";


function DashboardPage() {
  const [toggled, setToggled] = useState(true);
  const [cuentas, setCuentas] = useState({});

  const handleOpenToggle = () => {
    setToggled(true);
  };

  const handleCloseToggle = () => {
    setToggled(true);
  };

  const fetchCuentas = async () => {
    const res = await getCuentasRequest();
    setCuentas(res);
  }

  useEffect(() => {
    fetchCuentas()
  },[])

  return (
    <section className="flex h-screen">
      <SidebarComponent
        toggled={toggled}
        handleCloseToggle={handleCloseToggle}
      />
      <div className="flex flex-col px-2 py-2">
        <TopNavbar />
      </div>
      <div>{JSON.stringify(cuentas)}</div>
    </section>
  );
}

export default DashboardPage;
