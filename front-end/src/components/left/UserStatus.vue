<template>
    <div>
        <div class="status-param">
            <img class="status-icon" src="http://localhost:5173/src/assets/icons/love.png"/>
            <progress class="status-progress" value="70" min="0" max="100"></progress>
        </div>
        <div class="status-param">
            <img class="status-icon" src="http://localhost:5173/src/assets/icons/compass.png"/>
            <progress class="status-progress" value="30" min="0" max="100"></progress>
        </div>
        <div class="status-param">
            <img class="status-icon" src="http://localhost:5173/src/assets/icons/user-account.png"/>
            <progress class="status-progress" value="50" min="0" max="100"></progress>
        </div>
        <div class="status-param">
            <img class="status-icon" src="http://localhost:5173/src/assets/icons/idea-bulb.png"/>
            <progress class="status-progress" value="90" min="0" max="100"></progress>
        </div>
        
    </div>
</template>

<script setup>

</script>

<style scoped>
.status-param{
    position: relative;
    height: 8rem;
    border-bottom: 3px solid #3E2A0E;
}
.status-icon{
    zoom:15%;
    margin-top: 13rem;
}
.status-progress{
    appearance: none;
    position: relative;
    margin-left: 3rem;
    border: 5px solid #3E2A0E;
    border-radius: 20px;
    width: 24rem;
    height: 3rem;
    top: 2.2rem;
    overflow : hidden;
}
.status-progress::-webkit-progress-bar{
    background: white;
}
.status-progress::-webkit-progress-value{
    background: #FFA726;
}
</style>