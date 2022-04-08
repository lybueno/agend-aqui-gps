import ButtonIcon from "components/ButtonIcon";
import "./styles.css";

const CardLogin = () => {
  return (
    <div className="base-card login-card">
      <h1>LOGIN</h1>
      <form>
        <div className="mb-4">
          <input
            type="text"
            className="form-control base-input"
            placeholder="Email"
            name="username"
          />
        </div>
        <div className="mb-2">
          <input
            type="password"
            className="form-control base-input "
            placeholder="Password"
            name="password"
          />
        </div>
        <a href="link" className="login-link-recover">
          Esqueci a senha
        </a>
        <div className="login-submit">
          <ButtonIcon />
        </div>
        <div className="signup-container">
          <span className="not-registered">Não tem Cadastro?</span>
          <a href="link" className="login-link-register">
            CADASTRAR
          </a>
        </div>
      </form>
    </div>
  );
};

export default CardLogin;
