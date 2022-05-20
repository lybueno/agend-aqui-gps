import Navbar from "components/Navbar";
import { useEffect, useState } from "react";
import { Schedule } from "types/schedule";


const SchedulesAvailabe = () => {


    const [data, setData] = useState([])
    var idData = localStorage.getItem("id-client");
     

    useEffect(()=> {
      const id = localStorage.getItem("id-client");
        fetch(`http://localhost:8080/schedule/client/${id}`)
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
            <h1>NADAAAAAAAAAAAAA</h1>
        </div>)
    }else{
        return (
          <div>
            {idData}
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