import SubmitBtt from "../atoms/SubmitBtt";




const LoginButtons = (props) => {
    return(
        <div>
            <SubmitBtt design="login" value="Login"></SubmitBtt>
            <SubmitBtt design="login" value="Register"></SubmitBtt>
        </div>
    )

}


export default LoginButtons;