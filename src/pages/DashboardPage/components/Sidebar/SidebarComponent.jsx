import logo from "../../../../assets/img/logo_ec.webp";

import { Sidebar, Menu, MenuItem, SubMenu } from "react-pro-sidebar";


import {
  ArrowsRightLeftIcon,
  BanknotesIcon,
  BuildingStorefrontIcon,
  ChartBarIcon,
  ChartPieIcon,
  HomeIcon,
} from "@heroicons/react/24/solid";
import { Link } from "react-router-dom";

function SidebarComponent({ toggle, handleCloseToggle }) {
  return (
    <Sidebar toggled={toggle} onBackdropClick={handleCloseToggle}>
      <div className=" flex justify-center py-2">
        <img className="h-20 w-20" src={logo} alt="logo Expenses Control" />
      </div>
      <Menu>
        <MenuItem
          icon={
            <HomeIcon className=" h-8 w-8 py-1 text-cyan-400 cursor-pointer" />
          }
        >
          <Link to='/dashboard/inicio'>Inicio</Link>
        </MenuItem>
        <MenuItem
          icon={
            <BanknotesIcon className=" h-8 w-8 py-1 text-cyan-400 cursor-pointer" />
          }
        >
          Ingresos
        </MenuItem>
        <MenuItem
          icon={
            <ChartBarIcon className=" h-8 w-8 py-1 text-cyan-400 cursor-pointer" />
          }
        >
          Gastos
        </MenuItem>
        <MenuItem
          icon={
            <BuildingStorefrontIcon className=" h-8 w-8 py-1 text-cyan-400 cursor-pointer" />
          }
        >
          <Link to='/dashboard/establecimientos'>Establecimientos</Link>
        </MenuItem>
        <MenuItem
          icon={
            <ChartPieIcon className=" h-8 w-8 py-1 text-cyan-400 cursor-pointer" />
          }
        >
          Métricas
        </MenuItem>
        <SubMenu
          icon={
            <ArrowsRightLeftIcon className=" h-8 w-8 py-1 text-cyan-400 cursor-pointer" />
          }
          label="Movimientos"
        >
          <MenuItem>Lista de movimientos</MenuItem>
        </SubMenu>
      </Menu>
    </Sidebar>
  );
}

export default SidebarComponent;
