import './styles.css'
import Navbar from "components/Navbar";
import { useState, useContext, useEffect } from 'react';
import { useNavigate } from "react-router-dom";
import { AuthContext } from "contexts/auth";
import axios from "axios";



const Cadastro = () => {
    const navigate = useNavigate();
    const { login, user } = useContext(AuthContext);

    const [data, setData] = useState("")

    const [useComplete, setUserComplete] = useState()


    // useEffect(() => {
    //   axios
    //     .get(`http://localhost:8080/schedule/${typeUser}/${user}`)
    //     .then((response) => {
    //       const dado = response.data;
    //       console.log(response);
    //       setData(dado);
    //       console.log(dado);
    //     });
    // }, [data.length]);

    

    let handleSubmit = async (e: { preventDefault: () => void; }) => {
      e.preventDefault();

      createSchedule()
    };

    async function createSchedule(){
        let body = JSON.stringify({
            date: data
        });
        try {
            console.log(body)
          let res = await fetch(`http://localhost:8080/schedule/add`, {
            method: "POST",
            headers: {
              Accept: "application/json",
              "Content-Type": "application/json",
            },
            body: body,
          });
          if (res.status === 201) {
            navigate("/schedules")
          } 
        } catch (e) {
          console.log(e);
        }
    }

    return (
      <>
        <Navbar />
        <div className="base-card login-card">
          <h1>CADASTRO</h1>
          <form onSubmit={handleSubmit}>
            {/* <div className="mb-4">
              <input
                type="text"
                className="form-control base-input"
                placeholder="Nome completo"
                name="nome_completo"
                onChange={(e) => setNome(e.target.value)}
              />
            </div>
            <div className="mb-4">
              <select
                className="form-control base-input"
                onChange={(e) => setTipo(e.target.value)}
              >
                <option value="" disabled selected>
                  Selecione uma opção
                </option>
                <option value="ROLE_CUSTOMER">Cliente</option>
                <option value="ROLE_PROVIDER">Prestador</option>
              </select>
            </div>
            <div className="mb-4">
              <input
                type="text"
                className="form-control base-input"
                placeholder="Email"
                name="username"
                onChange={(e) => setEmail(e.target.value)}
              />
            </div>
            <div className="mb-4">
              <input
                type="text"
                className="form-control base-input"
                placeholder="CPF"
                name="cpf"
                onChange={ (e) => setCpf(e.target.value)}
              />
            </div>
            <div className="mb-4">
              <input
                type="text"
                className="form-control base-input"
                placeholder="Telefone"
                name="telefone"
                onChange={(e) => setFone(e.target.value)}
              />
            </div>
            <div className="mb-2">
              <input
                type="password"
                className="form-control base-input "
                placeholder="Password"
                name="senha"
                onChange={(e) => setSenha(e.target.value)}
              />
            </div>
            <div className="login-submit">
              <input type="submit" value="Cadastrar" className="btn"></input>
            </div> */}
          </form>
        </div>
      </>
    );
}

export default Cadastro;