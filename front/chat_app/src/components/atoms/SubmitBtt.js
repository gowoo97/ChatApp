import styles from './SubmitBtt.module.css'



const SubmitBtt = (props) => {
    const design=props.design;
    return(
        <>
            <button className={styles[design]} >{ props.value }</button>
        </>
    )
   }




export default SubmitBtt;