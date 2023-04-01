import LabelInput from "../molecules/LabelInput";
import styles  from './Box.module.css';



const Box =  (props) => {
    return(
        <div className={`${ styles.box }`}>
            
            <LabelInput text="ID:" class="login"></LabelInput>
            <LabelInput text="PW:" class="login"></LabelInput>
        </div>
    )
}

export default Box;