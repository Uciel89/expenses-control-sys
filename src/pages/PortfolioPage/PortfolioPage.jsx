import React from "react";
import Header from "./components/Header/Header";
import Footer from "./components/Footer/Footer";
import { Routes } from "react-router-dom";
import { Route } from "react-router-dom";
import HomePage from "./pages/HomePage";

function PortfolioPage() {
  return (
    <>
      <Header />
      <Routes>
        <Route path="/" element={<HomePage />}/>
        <Route path="/servicios/categorías" />
        <Route path="/servicios/métrica" />
        <Route path="/servicios/ingresos" />        
        <Route path="/equipo" />
      </Routes>
      <Footer />
    </>
  );
}

export default PortfolioPage;
