import './styles.css'
import Navbar from "components/Navbar";

const Cadastro = () => {
    return(
        <>
            <Navbar />
            <div className="base-card login-card">
                <h1>CADASTRO</h1>
                <form>
                    <div className="mb-4">
                        <input
                            type="text"
                            className="form-control base-input"
                            placeholder="Nome completo"
                            name="nome_completo"
                        />
                    </div>
                    <div className="mb-4">
                        <input
                            type="text"
                            className="form-control base-input"
                            placeholder="Email"
                            name="username"
                        />
                    </div>
                    <div className="mb-4">
                        <input
                            type="text"
                            className="form-control base-input"
                            placeholder="CPF"
                            name="cpf"
                        />
                    </div>
                    <div className="mb-4">
                        <input
                            type="text"
                            className="form-control base-input"
                            placeholder="Telefone"
                            name="telefone"
                        />
                    </div>
                    <div className="mb-2">
                        <input
                            type="password"
                            className="form-control base-input "
                            placeholder="Password"
                            name="senha"
                        />
                    </div>
                    <div className="login-submit">
                        <input type="submit" value="Cadastrar" className='btn'></input>
                    </div>
                </form>
            </div>
        </>
    );
}

export default Cadastro;