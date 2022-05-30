import Navbar from "components/Navbar";
import { useEffect, useState, useContext } from "react";
import { Schedule } from "types/schedule";
import { AuthContext } from "contexts/auth";


const SchedulesAvailabe = () => {
    const { user } = useContext(AuthContext);
    const [data, setData] = useState([])
     

    useEffect(()=> {
        fetch(`http://localhost:8080/schedule/client/${user}`)
          .then((response) => response.json())
          .then((res) => {
            setData(res);
          });
    }, [])

    // console.log(data)
    // console.log(localStorage.getItem('res.id'))
    
    if(data.length === 0){
        
        return(<div>
            <Navbar />
            ID USER: {user}
            <h1>NADAAAAAAAAAAAAA</h1>
        </div>)
    }else{
        return (
          <div>
            ID USER: {user}
            <Navbar />
            {data &&
              data.map((schedule: Schedule, index) => (
                <div className="col-sm-6 col-lg-4 col-xl-3" key={index}>
                  {schedule.id}
                  <br></br>
                  {schedule.date} <br/>
                  <p>Prestador: {schedule.provider.nomeCompleto}</p>
                  <p>Cliente: {schedule.client.nomeCompleto}</p>
                </div>
              ))}
          </div>
        );
    }

}   

export default SchedulesAvailabe;