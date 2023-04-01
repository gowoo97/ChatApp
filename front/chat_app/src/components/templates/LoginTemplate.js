
import Box from '../organisms/Box.js';
import styles from './LoginTemplate.module.css';

function LoginTemplate(props){
    return(
        <div className={`${styles.loginTemplate}`}>
            <h1 style={ {textAlign:"center"}}>Login</h1>
            <Box class="login" idText="ID:" pwText="PW:"></Box>
        </div>
    )
}



export default LoginTemplate;