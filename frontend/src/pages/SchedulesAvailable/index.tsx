import Navbar from "components/Navbar";
import { useEffect, useState } from "react";
import { Schedule } from "types/schedule";


const SchedulesAvailabe = () => {


    const [data, setData] = useState([])

    useEffect(()=> {
        fetch(`http://localhost:8080/schedule/client/2`)
        .then(response => response.json())
        .then((res) => {
            setData(res);
        })
    }, [])

    console.log(data)
    console.log(localStorage.getItem('res.id'))
    
    if(data.length === 0){
        
        return(<div>
            <Navbar />
            <h1>NADAAAAAAAAAAAAA</h1>
        </div>)
    }else{
        return (
          <div>
            <Navbar />
            {data &&
              data.map((schedule: Schedule, index) => (
                <div className="col-sm-6 col-lg-4 col-xl-3" key={index}>
                  {schedule.id}
                </div>
              ))}
          </div>
        );
    }

}   

export default SchedulesAvailabe;