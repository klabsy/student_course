<template>
  <div style="height: 100%;" class="loginstyle">
    <el-row style="height: 25%;">
    </el-row>
    <el-row style="height: 50%;">
      <el-col :span="3">

      </el-col>
      <el-col :span="18">
        <el-row>
          <el-col :span="4">
          </el-col>
          <el-col :span="4">
          </el-col>
          <el-col :span="8" class="bodystyle">
            <el-row style="height: 30%">
              <div style="margin-top: 50px;">
                <h1 class="h1style" style="">学生选课系统</h1>
              </div>
            </el-row>
            <el-row style="height: 70%;border-radius: 30px;">
              <el-form :model="login">
                <el-row style="height: 30%;">
                  <el-col :span="6">
                    <el-form-item label="用户名:"></el-form-item>
                  </el-col>
                  <el-col :span="13">
                    <el-input v-model="login.username"></el-input>
                  </el-col>
                  <el-col :span="4">
                  </el-col>
                </el-row>

                <el-row style="height: 30%;">
                  <el-col :span="6">
                    <el-form-item label="密码:"></el-form-item>
                  </el-col>
                  <el-col :span="13">
                    <el-input v-model="login.pwd"></el-input>
                  </el-col>
                  <el-col :span="4">
                  </el-col>
                </el-row>
                <el-row style="height: 15%">
                  <div style="width: 30%;margin: 0 auto;">
                    <el-button type="primary" @click="logininfo">登录</el-button>
                  </div>
                </el-row>
              </el-form>

            </el-row>

          </el-col>
          <el-col :span="4">
          </el-col>
          <el-col :span="4">
          </el-col>
        </el-row>
      </el-col>

      <el-col :span="3">

      </el-col>
    </el-row>
    <div class="sec1_circle1"></div>
    <div class="sec1_circle2"></div>
    <div class="sec1_circle3"></div>
  </div>


</template>

<script>
export default {
  name: 'Course',
  data() {
    return {
      login: {
        username: "201215122",
        pwd: "123"
      }
    }
  },
  beforeCreate() {
  },
  methods: {
    logininfo() {
      console.log(this.login)
      this.$http.post('/api/student_course_springMVC_war_exploded/user/login', this.login)
        .then(res => {
          console.log(res.data)
          if (res.data === "100") {
            this.$router.push({
              path: '/admin',
            });
          } else if (res.data === "10") {
            this.$router.push({
              path: '/teacher',
            });
          } else {
            this.$router.push({
              path: '/student',
              query: {Sno: this.login.username}
            });
          }


        })
        .catch(err => {
          console.log(err + "错误")
        })
    },
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.loginstyle {
  background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);
}

a {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  color: white;
  text-decoration: none;
}

a:hover {
  color: #2afa2a;
}

.h1style {
  font-family: KaiTi;
  background-image: -webkit-linear-gradient(bottom, #5fe849, #1fc18c, #1a3130);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

.bodystyle {
  /*background-color: #e7e7e7;*/
  border-radius: 30px;
  text-align: center;

  /*设置阴影*/
  box-shadow: 20px 20px 50px rgba(0, 0, 0, 0.5);
  /*设置圆角*/
  /*设置上边界和左边界亮纹，使card有一种层次感*/
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  border-left: 1px solid rgba(255, 255, 255, 0.5);

  /*设置背景样式*/
  background: rgba(255, 255, 255, 0.1);
  /*让透过card的底部元素模糊化,达到毛玻璃效果*/
  backdrop-filter: blur(5px);
}

/* -------背景圆点------ */
.sec1_circle1 {
  background: white;
  background: linear-gradient(
    to right bottom,
    rgba(255, 255, 255, 0.8),
    rgba(255, 255, 255, 0.3)
  );
  height: 20rem;
  width: 20rem;
  position: absolute;
  border-radius: 50%;
  top: 5%;
  right: 15%;
}

.sec1_circle2 {
  background: white;
  background: linear-gradient(
    to right bottom,
    rgba(255, 255, 255, 0.8),
    rgba(247, 255, 174, 0.3)
  );
  height: 20rem;
  width: 20rem;
  position: absolute;
  border-radius: 50%;
  top: 10%;
  left: 5%;
}

.sec1_circle3 {
  background: white;
  background: linear-gradient(
    to right bottom,
    rgba(248, 202, 202, 0.8),
    rgba(255, 255, 255, 0.3)
  );
  height: 20rem;
  width: 20rem;
  position: absolute;
  border-radius: 50%;
  bottom: 1%;
  right: 55%;
}

</style>
