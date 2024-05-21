import React from "react";
import "./styles/style.css";

import logo from "../../assets/img/logo_ec.webp";
import { ArrowLeftIcon, EnvelopeIcon } from "@heroicons/react/24/outline";
import { Link } from "react-router-dom";
import { EyeIcon } from "@heroicons/react/20/solid";
import { Routes } from "react-router-dom";
import { Route } from "react-router-dom";
import SignIn from "./pages/SignInPage";
import SignUpPage from "./pages/SignUpPage";

function LoginPage() {
  return (
    <section className="h-screen relative">
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
      <div
        className="absolute inset-x-0 -top-40 z-10 transform-gpu overflow-hidden blur-3xl sm:-top-80"
        aria-hidden="true"
      >
        <div
          className="relative left-[calc(50%-11rem)] aspect-[1155/678] w-[36.125rem] -translate-x-1/2 rotate-[30deg] bg-gradient-to-tr from-[#22D3EE] to-[#1C1C1C] opacity-30 sm:left-[calc(50%-30rem)] sm:w-[72.1875rem]"
          style={{
            clipPath:
              "polygon(74.1% 44.1%, 100% 61.6%, 97.5% 26.9%, 85.5% 0.1%, 80.7% 2%, 72.5% 32.5%, 60.2% 62.4%, 52.4% 68.1%, 47.5% 58.3%, 45.2% 34.5%, 27.5% 76.7%, 0.1% 64.9%, 17.9% 100%, 27.6% 76.8%, 76.1% 97.7%, 74.1% 44.1%)",
          }}
        />
      </div>
      <Routes>
        <Route path="/login" element={<SignIn />} />
        <Route path="/register" element={<SignUpPage />} />
      </Routes>
      <div
        className="absolute inset-x-0 z-0 transform-gpu overflow-hidden blur-3xl top-60"
        aria-hidden="true"
      >
        <div
          className="relative left-[calc(50%+3rem)] max-sm:top-28 top-[calc(100%-13rem)] max-sm:h-96 sm:top-[calc(100%-30rem)] aspect-[1155/678] w-[36.125rem] -translate-x-1/2 bg-gradient-to-tr from-[#A3E635] to-[#1C1C1C] opacity-30 sm:left-[calc(50%+36rem)] sm:w-[72.1875rem]"
          style={{
            clipPath:
              "polygon(74.1% 44.1%, 100% 61.6%, 97.5% 26.9%, 85.5% 0.1%, 80.7% 2%, 72.5% 32.5%, 60.2% 62.4%, 52.4% 68.1%, 47.5% 58.3%, 45.2% 34.5%, 27.5% 76.7%, 0.1% 64.9%, 17.9% 100%, 27.6% 76.8%, 76.1% 97.7%, 74.1% 44.1%)",
          }}
        />
      </div>
    </section>
  );
}

export default LoginPage;
