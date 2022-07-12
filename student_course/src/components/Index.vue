<template>
  <div class="loginBox">
<!--        <router-link to="/teacher">学生信息</router-link>-->
    <h1>登陆</h1>
    <form>
      <div class="info">
        <input type="text" required>
        <p>用户名</p>
      </div>

      <div class="info">
        <input type="password" required>
        <p>密码</p>
      </div>
      <button>登陆</button>
      <label class="text">没有账号?点此<router-link to="/teacher">登录</router-link></label>
    </form>
  </div>


</template>

<script>
export default {
  name: 'Course',
  data() {
    return {
    }
  },
  beforeCreate() {},
  methods:{}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>



.loginBox {
  background-color: rgba(0, 0, 0, 0.4);
  padding: 20px 40px;
  color: #fff;
  border-radius: 10px;
  width: 25%;
  margin: 150px auto;
}

.loginBox h1 {
  text-align: center;
}

.info {
  position: relative;
  width: 300px;
  margin: 20px 0 40px;
}

.loginBox .info input {
  display: block;
  width: 100%;
  background-color: transparent;
  border: 0;
  font-size: 18px;
  border-bottom: 2px solid #fff;
  padding: 15px 0;
  color: #fff;
}

.info input:focus,
.info input:valid {
  outline: 0;
  border-bottom-color: lightblue;
}

.info p {
  position: absolute;
  top: -5px;
  left: 0;
  pointer-events: none;
}

form button {
  width: 100%;
  border: 0;
  background-color: #add8e6;
  padding: 15px;
  border-radius: 10px;
  cursor: pointer;
}

.info p span {
  display: inline-block;
  font-size: 18px;
  min-width: 5px;
  transition: 0.3s cubic-bezier(0.68, -0.55, 0.265, 1.55);
}

.info input:focus+p span,
.info input:valid+p span {
  color: #adcdc6;
  transform: translateY(-30px);
}

.text {
  display: block;
  margin-top: 30px;
}

.text a {
  color: #adcdc6;
  text-decoration: none;
}
</style>
