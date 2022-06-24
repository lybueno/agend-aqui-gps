import Navbar from "components/Navbar";
import { useEffect, useState, useContext } from "react";
import { Schedule } from "types/schedule";
import { AuthContext, AuthProvider } from "contexts/auth";
import axios from "axios";
import { idText } from "typescript";


const SchedulesAvailabe = () => {
  
    const { user, typeUser } = useContext(AuthContext);
    const [data, setData] = useState([])


    useEffect(() => {
      axios
        .get(`http://localhost:8080/availables`)
        .then((response) => {
          const dado = response.data;
          console.log(response);
          setData(dado);
          console.log(dado);
        });
    }, [data.length])


    async function updateSchedule(id: String){
      let body = JSON.stringify({
        client: user
      })
      try {
        let res = await fetch(`http://localhost:8080/schedule/update/${id}`, {
          method: "POST",
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: body
      })
      if (res.status === 200) {
          alert("O agendamento foi realizado com sucesso.")
      } else {
          alert("ops! Ocorreu um erro ao realizar o agendamento. Tente mais tarde.")
      }
    } catch (e) {
        console.log(e)
    }
  }
      
    

    
    if(data.length===0){
        
        return (
          <div className="container">
            <Navbar />
            <h1>Sem Horários Disponíveis</h1>
          </div>
        );
    }else{
        return (
          <div className="container">
            ID USER: {user}
            <Navbar />
            {data.map((schedule: Schedule) => (
              <div className="col-sm-6 col-lg-4 col-xl-3">
                {schedule.id}
                <br></br>
                {schedule.date} <br />
                <p>Prestador: {schedule.provider.nomeCompleto}</p>
                <button type="submit" onClick={() => {updateSchedule((schedule.id).toString())}}>Agendar Horário</button>
              </div>
            ))}
          </div>
        );
    }

}   

export default SchedulesAvailabe;