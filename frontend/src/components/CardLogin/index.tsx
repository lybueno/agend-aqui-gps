import ButtonIcon from "components/ButtonIcon";
import React, { useState, useContext } from "react";
import "./styles.css";

import { AuthContext } from "contexts/auth";
import { User } from "types/user";
import { Link } from "react-router-dom";

const CardLogin = () => {
  const { login, user } = useContext(AuthContext);

  const [email, setEmail] = useState("")
  const [teste, setTeste] = useState("teste")
  const [password, setPassword] = useState("");


  const handleSubmit = async (e: { preventDefault: () => void; }) => {
    e.preventDefault()
    const teste = await login(email, password)
  

  };


  return (
    <div className="login-card">
      <h1>LOGIN</h1>
      <form onSubmit={handleSubmit}>
        <div className="mb-4">
          <input
            value={email}
            type="text"
            className="form-control base-input"
            placeholder="Email"
            name="username"
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
        <div className="mb-2">
          <input
            value={password}
            type="password"
            className="form-control base-input "
            placeholder="Password"
            name="password"
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>
        <div className="login-submit">
          {/* <Link to="/schedule"> */}
            <ButtonIcon />
          {/* </Link> */}
        </div>
        <div className="signup-container">
          <span className="not-registered">Não tem Cadastro?</span>
          <a href="/cadastro" className="login-link-register">
            CADASTRAR
          </a>
        </div>
      </form>
    </div>
  );
};

export default CardLogin;