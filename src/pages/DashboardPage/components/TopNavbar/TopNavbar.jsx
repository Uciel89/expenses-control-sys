import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { useLocation } from "react-router-dom";

import DarkThemeButton from '../../../../components/DarkThemeButton';
import { Bars3Icon } from "@heroicons/react/24/solid";

function TopNavbar({handleOpenToggle}) {
  const [namePage, setNamePage] = useState("");
  const location = useLocation();

  useEffect(() => {
    const pathName = location.pathname.split("/")[2];
    if (pathName) {
      setNamePage(pathName);
    }
  }, [location]);

  const [isVisibleMenu, setIsVisibleMenu] = useState(null);

  const handleOpenMenu = (event) => {
    setIsVisibleMenu((prev) => !prev);
  };
  return (
    <nav className="flex items-center justify-between w-full dark:bg-slate-900 dark:border-gray-700 px-4 border-b border-gray-200 bg-gray-100 p-3">
      <div className="flex gap-2">
        <div className="lg:hidden">
          <Bars3Icon onClick={handleOpenToggle} className=" h-8 w-8 py-1 text-gray-900 dark:text-cyan-400 cursor-pointer" />
        </div>
        <div className="flex items-center flex-shrink-0 text-slate-900 mr-6">
          <span className="font-semibold text-xl tracking-tight first-letter:uppercase dark:text-gray-50">
            {namePage}
          </span>
        </div>
      </div>
      <div className="flex items-center justify-end lg:w-auto">
        <DarkThemeButton />
        <div
          onClick={handleOpenMenu}
          className="relative w-10 h-10 cursor-pointer overflow-hidden bg-gray-100 rounded-full dark:bg-gray-600"
        >
          <img
            src="https://ui-avatars.com/api/?name=Uciel-Daro&background=2dd4bf&color=fff&size=128"
            alt=""
          />
        </div>

      </div>
      {isVisibleMenu && (
        <div
          className="absolute right-2 top-16 z-10 mt-2 w-56 origin-top-right rounded-md bg-white shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none"
          role="menu"
          aria-orientation="vertical"
          aria-labelledby="menu-button"
          tabindex="-1"
        >
          <div className="py-1" role="none">
            <a
              href="#"
              className="text-gray-700 block px-4 py-2 text-sm hover:bg-gray-100"
              role="menuitem"
              tabindex="-1"
              id="menu-item-0"
            >
              Ajustes
            </a>
            <form method="POST" action="#" role="none">
              <button
                type="submit"
                className="text-gray-700 block w-full px-4 py-2 text-left text-sm hover:bg-gray-100"
                role="menuitem"
                tabindex="-1"
                id="menu-item-3"
              >
                Cerrar Sesión
              </button>
            </form>
          </div>
        </div>
      )}
    </nav>
  );
}

export default TopNavbar;
