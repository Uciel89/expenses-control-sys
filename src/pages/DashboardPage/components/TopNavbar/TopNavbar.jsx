import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { useLocation } from "react-router-dom";

function TopNavbar() {
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
    <nav class="flex items-center justify-between w-full px-4 border-b border-gray-200 bg-gray-50 p-3">
      <div className="flex gap-2">
        <div class="lg:hidden">
          <button class="flex items-center px-3 py-2 border rounded text-teal-200 border-teal-400 hover:text-white hover:border-white">
            <svg
              class="fill-current h-3 w-3"
              viewBox="0 0 20 20"
              xmlns="http://www.w3.org/2000/svg"
            >
              <title>Menu</title>
              <path d="M0 3h20v2H0V3zm0 6h20v2H0V9zm0 6h20v2H0v-2z" />
            </svg>
          </button>
        </div>
        <div class="flex items-center flex-shrink-0 text-slate-900 mr-6">
          <span class="font-semibold text-xl tracking-tight first-letter:uppercase">
            {namePage}
          </span>
        </div>
      </div>
      <div class="block :flex lg:items-end justify-end lg:w-auto">
        <div
          onClick={handleOpenMenu}
          class="relative w-10 h-10 cursor-pointer overflow-hidden bg-gray-100 rounded-full dark:bg-gray-600"
        >
          <img
            src="https://ui-avatars.com/api/?name=Uciel-Daro&background=2dd4bf&color=fff&size=128"
            alt=""
          />
        </div>
      </div>
      {isVisibleMenu && (
        <div
          class="absolute right-2 top-16 z-10 mt-2 w-56 origin-top-right rounded-md bg-white shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none"
          role="menu"
          aria-orientation="vertical"
          aria-labelledby="menu-button"
          tabindex="-1"
        >
          <div class="py-1" role="none">
            <a
              href="#"
              class="text-gray-700 block px-4 py-2 text-sm hover:bg-gray-100"
              role="menuitem"
              tabindex="-1"
              id="menu-item-0"
            >
              Ajustes
            </a>
            <form method="POST" action="#" role="none">
              <button
                type="submit"
                class="text-gray-700 block w-full px-4 py-2 text-left text-sm hover:bg-gray-100"
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
