<template>
    <div id="page">
        <div id="registerBox">
            <h1>Registeration</h1>
            <input type="text" placeholder="이름" name="userName"/>
            <input type="text" placeholder="아이디" name="userId"/>
            <input type="text" placeholder="패스워드" name="userPw"/>
            <input type="text" placeholder="닉네임" name="userNickname"/>
            <input type="button" value="회원가입"/>
        </div>
    </div>
</template>


<script>
export default{

}
</script>



<style scoped>
#page{
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    height:100vh;
}
#registerBox{
    display:flex;
    justify-content:center;
    align-items: center;
    flex-direction: column;
    border: 1px solid rgb(179, 170, 170);
    width: 500px;
    min-width: 375px;
}
input{
    box-sizing: border-box;
    width: 270px;
    height: 30px;
    margin-bottom: 20px;
    border-radius: 5px;
    border: 1px solid rgb(179, 170, 170);
}
input[type='button']{
    background-color: rgb(18, 140, 240);
    cursor: pointer;
    color: white;

}
</style>