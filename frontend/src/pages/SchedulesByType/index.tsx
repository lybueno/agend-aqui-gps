import Navbar from "components/Navbar";
import { useEffect, useState, useContext } from "react";
import { Schedule } from "types/schedule";
import { AuthContext } from "contexts/auth";
import axios from "axios";


const SchedulesAvailabe = () => {
  
    const { user, typeUser } = useContext(AuthContext);
    const [data, setData] = useState([])



    useEffect(() => {
      axios
        .get(`http://localhost:8080/schedule/${typeUser}/${user.id}`)
        .then((response) => {
          const dado = response.data;
          console.log(response);
          setData(dado);
          console.log(dado);
        });
    }, [data.length])

    
    if(data.length===0){
        
        return (
          <div className="container">
            <Navbar />
            ID USER: {user.id}
            <h1>Sem Agendamentos</h1>
          </div>
        );
    }else{
        return (
          <div className="container">
            ID USER: {user.id}
            <Navbar />
            {data.map((schedule: Schedule) => (
              <div className="col-sm-6 col-lg-4 col-xl-3">
                {schedule.id}
                <br></br>
                {schedule.date} <br />
                <p>Prestador: {schedule.provider.nomeCompleto}</p>
                {/* {!schedule.client.nomeCompleto:} <p>Cliente: {schedule.client.nomeCompleto</p> ? }</p> */}
                {/* {schedule.client.nomeCompleto && <p>Cliente: {schedule.client.nomeCompleto}?</p> } */}
              </div>
            ))}
          </div>
        );
    }

}   

export default SchedulesAvailabe;