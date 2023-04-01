import StyleInput from "../atoms/StyleInput";


function LabelInput(props){
    return(
        <div>
            <label>{props.text}</label>
            <StyleInput class={props.class}></StyleInput>
        </div>
    )

}

export default LabelInput;