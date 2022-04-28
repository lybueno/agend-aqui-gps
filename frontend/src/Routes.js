import Home from "pages/Home"
import Cadastro from "pages/Cadastro"
import { BrowserRouter, Route } from "react-router-dom"

const Routes = () => {
    return(
        <BrowserRouter>
            <Route component ={Home} path="/" exact />
            <Route component={Cadastro} path="/cadastro" />
        </BrowserRouter>
    )
}

export default Routes;