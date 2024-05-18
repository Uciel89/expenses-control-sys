import React from "react";
import "./styles/style.css";

import logo from "../../assets/img/logo_ec.webp";
import { ArrowLeftIcon, AtSymbolIcon, EnvelopeIcon } from "@heroicons/react/24/outline";
import { Link } from "react-router-dom";
import { EyeIcon, LockClosedIcon } from "@heroicons/react/20/solid";

function LoginPage() {
  return (
    <section className="h-screen">
      <div className="area">
        <ul className="circles">
          <li></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
        </ul>
      </div>

      <div className="flex min-h-full flex-1 flex-col justify-start px-6 py-12 lg:px-8 backdrop-blur-sm">
        <div className="w-full">
          <Link to="/" className="block w-2">
            <ArrowLeftIcon className="h-10 py-1 text-slate-50 cursor-pointer hover:text-slate-300" />
          </Link>
        </div>
        <div>
          <div className="sm:mx-auto sm:w-full sm:max-w-sm">
            <img
              className="mx-auto h-24 w-auto"
              src={logo}
              alt="Logo Expenses Control"
            />
            <h2 className="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-slate-50">
              Acceda a su cuenta
            </h2>
          </div>

          <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
            <form className="space-y-6" action="#" method="POST">
              <div>
                <label
                  htmlFor="email"
                  className="block text-sm font-medium leading-6 text-slate-50"
                >
                  Correo Electrónico
                </label>
                <div className="mt-2 relative">
                  <input
                    id="email"
                    name="email"
                    type="email"
                    autoComplete="email"
                    placeholder="example@example.com"
                    required
                    className="block w-full rounded-md h-12 border-0 py-1.5 px-3
                    text-gray-900 shadow-sm ring-2 ring-inset ring-cyan-600 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-cyan-700 sm:text-sm sm:leading-6"
                  />
                  <EnvelopeIcon className=" h-6 font-medium absolute right-2 top-3 text-gray-600"/>
                </div>
              </div>

              <div>
                <div className="flex items-center justify-between">
                  <label
                    htmlFor="password"
                    className="block text-sm font-medium leading-6 text-slate-50"
                  >
                    Contraseña
                  </label>
                  <div className="text-sm">
                    <a
                      href="#"
                      className="font-semibold text-slate-50 hover:text-slate-300"
                    >
                      Olvidaste tu contraseña?
                    </a>
                  </div>
                </div>
                <div className="mt-2 relative">
                  <input
                    id="password"
                    name="password"
                    type="password"
                    autoComplete="current-password"
                    placeholder="•••••••••"
                    required
                    className="block w-full rounded-md border-0 py-1.5 h-12 px-3 text-gray-900 shadow-sm ring-2 ring-inset ring-cyan-600 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-cyan-700 sm:text-sm sm:leading-6"
                  />
                  <EyeIcon className="h-6 absolute right-2 top-3 text-gray-500" />
                </div>
              </div>

              <div>
                <button
                  type="submit"
                  className="flex w-full justify-center rounded-md bg-cyan-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-cyan-800 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-cyan-600"
                >
                  Iniciar sesión
                </button>
              </div>
            </form>

            <p className="mt-10 text-center text-sm text-gray-400">
              Not tienes cuenta ?{" "}
              <a
                href="#"
                className="font-semibold leading-6 text-orange-500 hover:text-orange-600"
              >
                Regístrate ahora
              </a>
            </p>
          </div>
        </div>
      </div>
    </section>
  );
}

export default LoginPage;
