import Home from "pages/Home"
import Cadastro from "pages/Cadastro"
import AddSchedule from "pages/AddSchedule";
import SchedulesByType from "pages/SchedulesByType";
import SchedulesAvailabe from "pages/SchedulesAvailabe";
import { BrowserRouter, Route } from "react-router-dom"
import { useState, useContext } from "react"

import { AuthContext, AuthProvider } from "contexts/auth"

const Routes = () => {

    return (
      <AuthProvider>
        <BrowserRouter>
          <Route component={Home} path="/" exact />
          <Route component={Cadastro} path="/cadastro" />
          <Route component={AddSchedule} path="/addSchedule" />
          <Route component={SchedulesByType} path="/schedule" />
          <Route component={SchedulesAvailabe} path="/scheduleAvailabe" />
        </BrowserRouter>
      </AuthProvider>
    );  
}

export default Routes;