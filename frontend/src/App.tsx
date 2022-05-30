import './assets/styles/custom.scss';
import './App.css';

import Home from "pages/Home"
import Cadastro from "pages/Cadastro"
import SchedulesAvailabe from "pages/SchedulesAvailable"
import { BrowserRouter, Route, Routes } from "react-router-dom"
import { AuthContext, AuthProvider } from "contexts/auth"

function App() {
  return (
    <BrowserRouter>
      <AuthProvider>
        <Routes>
          <Route element={<Home/>} path="/" />
          <Route element={<Cadastro/>} path="/cadastro" />
          <Route element={<SchedulesAvailabe/>} path="/schedule" />
        </Routes>
      </AuthProvider>
    </BrowserRouter>
  
  );
}

export default App;
