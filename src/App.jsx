import './App.css'

import { BrowserRouter, Routes, Route} from 'react-router-dom'
import LoginPage from './pages/LoginPage/LoginPage'
import PortfolioPage from './pages/PortfolioPage/PortfolioPage'
import DashboardPage from './pages/DashboardPage/DashboardPage'
import { Navigate } from 'react-router-dom'

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<PortfolioPage />}/>
        <Route path='/users/*' element={<LoginPage />} />
        <Route path='/documentation' />
        <Route path='/dashboard' element={<DashboardPage />} />
        <Route path='*' element={<Navigate to='/' />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
