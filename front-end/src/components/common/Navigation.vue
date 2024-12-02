<template>
    <div class="navigation">
      <p class="logo">멍글멍글</p>
    </div>
</template>

<script setup>
const logout = function() {
  sessionStorage.removeItem('access-token')
}

</script>

<style scoped>
.navigation {
  height: 10%;
  font-family: 'meetMe';
  font-size: 70px;
  position: absolute;
  padding-left: 60px;
  padding-top: 30px;
}
</style>