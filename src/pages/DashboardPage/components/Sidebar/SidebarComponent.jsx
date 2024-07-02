import logo from "../../../../assets/img/logo_ec.svg";
import './SidebarComponent.css';

import { Sidebar, Menu, MenuItem, SubMenu, sidebarClasses } from "react-pro-sidebar";

import {
  ArrowsRightLeftIcon,
  BanknotesIcon,
  BuildingStorefrontIcon,
  ChartBarIcon,
  ChartPieIcon,
  HomeIcon,
  XMarkIcon,
} from "@heroicons/react/24/solid";

import { Link } from "react-router-dom";
import { useState } from "react";
import { useLocation } from "react-router-dom";
import { useEffect } from "react";
import { getItem } from "../../../../utilities/local-storage-utils";

function SidebarComponent({ toggle, handleCloseToggle }) {
  const location = useLocation();

  const [selected, setSelected] = useState(location.pathname.split("/")[2]);

  const theme = getItem('theme');

  useEffect(() => {
    const pathName = location.pathname.split("/")[2];
    if (pathName) {
      setSelected(pathName);
    }
  }, [location]);

  return (
    <Sidebar
      toggled={toggle}
      breakPoint="1023px"
      onBackdropClick={handleCloseToggle}
      className=" dark:bg-black"
      rootStyles={{
        borderColor: theme === 'dark' && 'rgb(55 65 81)',
        [`.${sidebarClasses.container}`]: {
          backgroundColor: theme === 'dark' ? '#0f172a' : 'rgb(243 244 246)',

        },
      }}
    >
      <div className="flex flex-col justify-center items-center py-2 w-full gap-2 px-2 mb-2">
        <div className="close-toggle justify-end w-full">
          <XMarkIcon onClick={handleCloseToggle} className=" h-8 w-8 text-gray-950 dark:text-gray-50 cursor-pointer" />
        </div>
        <img className="h-20 w-20" src={logo} alt="logo Expenses Control" />
      </div>
      <Menu
        menuItemStyles={{
          label: {
            color: theme === 'dark' && '#f9fafb'
          },
          button: {
            [`:hover`]: {
              background: theme === 'dark' && '#475569'
            },
            [`&.ps-active`]: {
              backgroundColor: theme === 'dark' ? '#475569' : '#f3f3f3',
              fontWeight: '600'
            },
          },
          subMenuContent: {
            background: theme === 'dark' && '#0b101e'
          }
        }}
      >
        <MenuItem
          icon={
            <HomeIcon className=" h-8 w-8 py-1 text-cyan-400 cursor-pointer" />
          }
          component={<Link to='/dashboard/inicio' />}
          active={selected === 'inicio'}
          onClick={() => setSelected('inicio')}
        >
          Inicio
        </MenuItem>
        <MenuItem
          icon={
            <BanknotesIcon className=" h-8 w-8 py-1 text-cyan-400 cursor-pointer" />
          }
          component={<Link to='/dashboard/ingresos' />}
          active={selected === 'ingresos'}
          onClick={() => setSelected('ingresos')}
        >
          Ingresos
        </MenuItem>
        <MenuItem
          icon={
            <ChartBarIcon className=" h-8 w-8 py-1 text-cyan-400 cursor-pointer" />
          }
          component={<Link to='/dashboard/gastos' />}
          active={selected === 'gastos'}
          onClick={() => setSelected('gastos')}
        >
          Gastos
        </MenuItem>
        <MenuItem
          icon={
            <BuildingStorefrontIcon className=" h-8 w-8 py-1 text-cyan-400 cursor-pointer" />
          }
          component={<Link to='/dashboard/establecimientos' />}
          active={selected === 'establecimientos'}
          onClick={() => setSelected('establecimientos')}
        >
          Establecimientos
        </MenuItem>
        <MenuItem
          icon={
            <ChartPieIcon className=" h-8 w-8 py-1 text-cyan-400 cursor-pointer" />
          }
          component={<Link to='/dashboard/metricas' />}
          active={selected === 'metricas'}
          onClick={() => setSelected('metricas')}
        >
          Métricas
        </MenuItem>
        <MenuItem
          icon={
            <ArrowsRightLeftIcon className=" h-8 w-8 py-1 text-cyan-400 cursor-pointer" />
          }
          component={<Link to='/dashboard/movimientos' />}
          active={selected === 'movimientos'}
          onClick={() => setSelected('movimientos')}
          rootStyles={{
            color: theme === 'dark' && '#f9fafb'
          }}
        >Movimientos</MenuItem>
      </Menu>
    </Sidebar>
  );
}

export default SidebarComponent;
