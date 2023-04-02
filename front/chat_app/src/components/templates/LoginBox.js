import LoginInput from "../atoms/LoginInput.js";
import SubmitBtt from '../atoms/SubmitBtt.js';
import LoginButtons from "../molecules/LoginButtons.js";
import styles from './LoginBox.module.css';

const LoginBox = (props) => {

    return (
        <div className={styles.container1}>
            <h1>Login</h1>
            <LoginInput design="login" placeholder="type your ID"></LoginInput>
            <LoginInput design="login" placeholder="type your PW"></LoginInput>
            <LoginButtons></LoginButtons>
        </div>
    )


}



export default LoginBox;