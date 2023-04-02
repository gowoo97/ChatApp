import styles from './LoginInput.module.css';


const LoginInput = (props) => {
    const design=props.design;
    return (
        <>
            <input className={styles[design]} placeholder={props.placeholder}></input>
        </>

    )
}



export default LoginInput;