<template>
    <div class="content">
        <div class="left-area">
            <MainLeftView />
        </div>
        <div class="right-area">
            <RouterView/>
        </div>
    </div>
</template>

<script setup>
import MainLeftView from './MainLeftView.vue';
</script>

<style scoped>

</style>