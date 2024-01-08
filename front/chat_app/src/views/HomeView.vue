<template>
  <div class="home">
    <profile></profile>
    <div>
        <FriendBox></FriendBox>
    </div>
    <div id="bottom">
      <Bottom></Bottom>
    </div>
  </div>
</template>


<script>
import profile from '../components/Profile-component.vue';
import FriendBox from '../components/Friend-box.vue';
import Bottom from '../components/Bottom-component.vue';
export default {

  components:{
    profile,
    FriendBox,
    Bottom
  }

}
</script>


<style scoped>
#home{
  height:100vh;
}
#bottom{
    position:fixed;
    bottom:0px;
    width:100%;
}
</style>