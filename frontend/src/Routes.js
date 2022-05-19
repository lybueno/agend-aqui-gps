import Home from "pages/Home"
import Cadastro from "pages/Cadastro"
import SchedulesAvailabe from "pages/SchedulesAvailable"
import { BrowserRouter, Route } from "react-router-dom"
import { useState, useContext } from "react"

import { AuthContext, AuthProvider } from "contexts/auth"

const Routes = () => {

    return (
      <AuthProvider>
        <BrowserRouter>
    
            <Route component={Home} path="/" exact />
            <Route component={Cadastro} path="/cadastro" />
            <Route component={SchedulesAvailabe} path="/schedule" />
        
        </BrowserRouter>
      </AuthProvider>
    );  
}

export default Routes;