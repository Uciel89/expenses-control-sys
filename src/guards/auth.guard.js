import { Navigate } from "react-router-dom";
import { Outlet } from "react-router-dom";

export const AuthGuard = () => {
    const userState = useSelector((store) => store.user);    
    return userState.token ? <Outlet /> : <Navigate replace to='/user/login'/>
}

export default AuthGuard;