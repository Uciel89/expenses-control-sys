import React from "react";

import logo from "../../../assets/img/logo_ec.webp";
import { ArrowLeftIcon, EnvelopeIcon } from "@heroicons/react/24/solid";
import { Link } from "react-router-dom";
import { EyeIcon } from "@heroicons/react/20/solid";
import { EyeSlashIcon, UserIcon } from "@heroicons/react/24/solid";
import { useState } from "react";

function SignUpPage() {
  const [password, setPassword] = useState("");
  const [repeatPassword, setRepeatPassword] = useState("");

  const [showPassword, setShowPassword] = useState(false);
  const [showRepeatPassword, setShowRepeatPassword] = useState(false);

  const togglePasswordVisibility = () => {
    setShowPassword((prevState) => !prevState);
  };

  const toggleRepeatPasswordVisibility = () => {
    setShowRepeatPassword((prevState) => !prevState);
  };
  return (
    <div className="flex overflow-auto min-h-full z-20 relative h-screen flex-1 flex-col justify-start px-6 py-12 lg:px-8 backdrop-blur-sm">
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
            Crear una cuenta
          </h2>
        </div>

        <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
          <form className="space-y-6" method="POST">
            {/** Input User Name */}
            <div>
              <label
                htmlFor="user-name"
                className="block text-sm font-medium leading-6 text-slate-50"
              >
                Nombre de usuario
              </label>
              <div className="mt-2 relative">
                <input
                  id="user-name"
                  name="user-name"
                  type="text"
                  autoComplete="user-name"
                  placeholder="Example123"
                  required
                  className="block w-full rounded-md h-12 border-0 py-1.5 px-3
                    text-gray-900 shadow-sm ring-2 ring-inset ring-cyan-600 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-cyan-700 sm:text-sm sm:leading-6"
                />
                <UserIcon className=" h-6 font-medium absolute right-2 top-3 text-gray-600" />
              </div>
            </div>

            {/** Input Email */}
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
                <EnvelopeIcon className=" h-6 font-medium absolute right-2 top-3 text-gray-600" />
              </div>
            </div>

            {/** Input Password */}
            <div>
              <div className="flex items-center justify-between">
                <label
                  htmlFor="password"
                  className="block text-sm font-medium leading-6 text-slate-50"
                >
                  Contraseña
                </label>
              </div>
              <div className="mt-2 relative">
                <input
                  id="password"
                  name="password"
                  type={showPassword ? "text" : "password"}
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  autoComplete="current-password"
                  placeholder="•••••••••"
                  required
                  className="block w-full rounded-md border-0 py-1.5 h-12 px-3 text-gray-900 shadow-sm ring-2 ring-inset ring-cyan-600 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-cyan-700 sm:text-sm sm:leading-6"
                />
                <div className="flex items-center absolute right-2 top-3">
                  <input
                    id="show-password"
                    type="checkbox"
                    checked={showPassword}
                    onChange={togglePasswordVisibility}
                    className="hidden"
                  />
                  <label htmlFor="show-password" className="cursor-pointer">
                    {showPassword ? (
                      <EyeSlashIcon className=" h-6 w-6 font-medium text-gray-600" />
                    ) : (
                      <EyeIcon className="w-6 h-6 font-medium text-gray-600" />
                    )}
                  </label>
                </div>
              </div>
            </div>

            {/** Input Repeat Password */}
            <div>
              <div className="flex items-center justify-between">
                <label
                  htmlFor="repeat-password"
                  className="block text-sm font-medium leading-6 text-slate-50"
                >
                  Repetir contraseña
                </label>
              </div>
              <div className="mt-2 relative">
                <input
                  id="repeat-password"
                  name="repeat-password"
                  type={showRepeatPassword ? "text" : "password"}
                  value={repeatPassword}
                  onChange={(e) => setRepeatPassword(e.target.value)}
                  placeholder="•••••••••"
                  required
                  className="block w-full rounded-md border-0 py-1.5 h-12 px-3 text-gray-900 shadow-sm ring-2 ring-inset ring-cyan-600 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-cyan-700 sm:text-sm sm:leading-6"
                />
                <div className="flex items-center absolute right-2 top-3">
                  <input
                    id="show-repeat-password"
                    type="checkbox"
                    checked={showRepeatPassword}
                    onChange={toggleRepeatPasswordVisibility}
                    className="hidden"
                  />
                  <label
                    htmlFor="show-repeat-password"
                    className="cursor-pointer"
                  >
                    {showRepeatPassword ? (
                      <EyeSlashIcon className=" h-6 w-6 font-medium text-gray-600" />
                    ) : (
                      <EyeIcon className="w-6 h-6 font-medium text-gray-600" />
                    )}
                  </label>
                </div>
              </div>
            </div>

            <div>
              <button
                type="submit"
                className="flex w-full justify-center rounded-md bg-cyan-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-cyan-800 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-cyan-600"
              >
                Registrase
              </button>
            </div>
          </form>

          <p className="mt-10 text-center text-sm text-gray-400">
            Ya tienes cuenta ?{" "}
            <Link
              to="/users/login"
              className="font-semibold leading-6 text-orange-500 hover:text-orange-600"
            >
              Inicia sesión
            </Link>
          </p>
        </div>
      </div>
    </div>
  );
}

export default SignUpPage;
