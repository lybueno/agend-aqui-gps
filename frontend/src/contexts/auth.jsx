
import React, {createContext, useState, useEffect} from 'react';

import { useNavigate } from 'react-router-dom';

export const AuthContext = React.createContext();

export const AuthProvider = ({children}) => {
    const navigate = useNavigate()

    const [user, setUser] = useState(null)
    const [typeUser, setTypeUser] = useState(null);
    const [loading, setLoading] = useState(true)


    const login = async (email, password) => {

        
        const sqlUser = await fetch(`http://localhost:8080/users/login/${email}`)
        const infoUser = await sqlUser.json()
    
        if(infoUser.id){
            setUser(infoUser)
            if(infoUser.roles[0].authority === "ROLE_PROVIDER"){
                setTypeUser("provider")
            }else{
                setTypeUser("client");
            }
            navigate("/schedule")
        }
        
    
    
        return infoUser

    }

    const logout = () => {
        console.log("logout")
    };

    return(<AuthContext.Provider value={{user, login, logout, typeUser}}>
        {children}
    </AuthContext.Provider>
    )
    
}