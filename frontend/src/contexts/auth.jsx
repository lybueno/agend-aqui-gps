import React, {createContext, useState, useEffect} from 'react';

export const AuthContext = React.createContext();

export const AuthProvider = ({children}) => {
    const [user, setUser] = useState("teste")
    const [loading, setLoading] = useState(true)

    useEffect(() => {
        const recoveredUser = localStorage.getItem(`user`)

        if(recoveredUser){
            setUser(JSON.parse(recoveredUser));
        }

        setLoading(false)
    }, [])

    const login = async (email, password) => {
        console.log(email + "-- " + password)
        var loggedUser = null
        
        const info = await fetch(`http://localhost:8080/users/login/${email}`)
        const seila = await info.json()
    
        setUser(seila.email)

    
        return info

    }

    const logout = () => {
        console.log("logout")
    };

    return(<AuthContext.Provider value={{authenticatred: !!user, user, login, logout}}>
        {children}
    </AuthContext.Provider>
    )
    
}