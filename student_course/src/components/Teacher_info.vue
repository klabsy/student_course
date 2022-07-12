<template>
  <div style="height: 100%;" class="loginstyle">
    <el-row style="height: 8%;background-color: #67c6b5;text-align: center;color: white;">
      <el-col :span="2" :offset="8">
        <div class="head">
          <router-link to="/teacher">
            <span class="headhd">Home</span>
            <span class="headhh">主页</span>
          </router-link>
        </div>
      </el-col>
      <el-col :span="2" :offset="1">
        <div class="head">
          <router-link to="/itroduction">
            <span class="headhd">System</span>
            <span class="headhh">简介</span>
          </router-link>
        </div>
      </el-col>
      <el-col :span="2" :offset="1">
        <div class="head">
          <router-link to="/teacher">
            <span class="headhd">More</span>
            <span class="headhh">更多</span>
          </router-link>
        </div>
      </el-col>
    </el-row>
    <el-row style="height: 5%;padding: 25px 0;"></el-row>

    <el-row style="height: 75%;">
      <el-col :span="3"></el-col>

      <el-col :span="18">
        <el-row class="bodystyle">
          <el-col :span="7">
            <div class="zuoce">
              <el-row class="zuocehead">
                <div>
                  <el-row class="zuoceimage">
                    <el-avatar :size="100" style="margin-top: 10px;">
                      <img src="https://z3.ax1x.com/2021/05/04/gnKXVg.jpg"/>
                    </el-avatar>
                  </el-row>
                  <el-row class="userinfo">老师</el-row>
                  <el-row class="userinfo">201215122</el-row>
                </div>
              </el-row>
              <el-row style="height: 10%">
                <div>
                  <router-link to="/teacher" class="alink">
                    首页
                  </router-link>
                </div>
              </el-row>
              <el-row style="height: 10%">
                <div>
                  <router-link to="/teacher_info" class="alink">
                    学生信息
                  </router-link>
                </div>
              </el-row>
              <el-row style="height: 10%">
                <div>
                  <router-link to="/teacher_addinfo" class="alink">
                    新增学生
                  </router-link>
                </div>
              </el-row>
              <el-row style="height: 10%">
                <div>
                  <router-link to="/teacher_course" class="alink">
                    课程管理
                  </router-link>
                </div>
              </el-row>
              <el-row style="height: 10%">
                <div>
                  <router-link to="/teacher_addcourse" class="alink">
                    新增课程
                  </router-link>
                </div>
              </el-row>
              <el-row style="height: 10%">
                <div>
                  <router-link to="/teacher_grade" class="alink">
                    科目成绩
                  </router-link>
                </div>
              </el-row>
            </div>
          </el-col>
          <el-col :span="1"></el-col>
          <el-col :span="16" class="youce">
            <div style="background-color: #ffffff4D;z-index: 100;border-radius: 30px;">
              <el-row
                style="height: 100%; border-radius: 30px;padding: 15px; background-color: rgba(210, 250, 231, 0.87);">
                <el-row class="tabletitle">
                  <h1>学生信息</h1>
                </el-row>
                <el-row class="tablehead">
                  <el-col :span="5">
                    姓名
                  </el-col>
                  <el-col :span="4">
                    性别
                  </el-col>
                  <el-col :span="5">
                    科目
                  </el-col>
                  <el-col :span="4">
                    年龄
                  </el-col>
                  <el-col :span="6">
                    操作
                  </el-col>
                </el-row>
                <el-row class="tablebody" v-for="value in info" :key="value.cno" >
                  <el-col :span="5" >
                    {{ value.sname }}
                  </el-col>
                  <el-col :span="4">
                    {{ value.ssex }}
                  </el-col>
                  <el-col :span="5">
                    {{ value.sdept }}
                  </el-col>
                  <el-col :span="4">
                    {{ value.sage }}
                  </el-col>
                  <el-col :span="3">
                    <div style="width: 90%;margin: 0 auto;">
                      <el-button type="mini" @click="get_upgradeinfo(value.sno)">修改</el-button>
                    </div>
                  </el-col>
                  <el-col :span="3">
                    <div style="width: 90%;margin: 0 auto;">
                      <el-button type="mini" @click="delinfo(value.sno)">删除</el-button>
                    </div>
                  </el-col>
                </el-row>

              </el-row>
            </div>
          </el-col>
        </el-row>
      </el-col>

      <el-col :span="3"></el-col>
    </el-row>
    <div class="sec2_circle1"></div>
    <div class="sec2_circle2"></div>
    <div class="sec2_circle3"></div>

  </div>


</template>

<script>
export default {
  data() {
    return {
      dialogTableVisible: false,
      dialogaddFormVisible: false,
      dialogupgradeFormVisible: false,
      formLabelWidth: '80px',
      item:{},
      info: [
        {
          Sno: 111,
          Sname: "",
          Ssex: "",
          Sdept: "",
          Sage: null
        }
      ]
    }
  },
  beforeCreate() {
    this.$http.get('/api/student_course_springMVC_war_exploded/student/get_allStudent')
      .then(res => {
        this.info = res.data
        console.log(this.info)
      })
      .catch(err => {
        console.log(err + "错误")
      })
  },
  mounted() {
    // console.log(this.tableData)
  },
  methods: {
    get_info(){
      this.$http.get('/api/student_course_springMVC_war_exploded/student/get_allStudent')
        .then(res => {
          this.info = res.data
          // console.log(this.info)
          // console.log("test")
        })
        .catch(err => {
          console.log(err + "错误")
        })
    },
    delinfo(sno) {
      console.log(sno);
      this.$http.delete('/api/student_course_springMVC_war_exploded/student/del_Student/' + sno)
        .then(res => {
          this.get_info()
          // this.info = res.data
          // console.log(this.info)

          console.log("test")
        })
        .catch(err => {
          console.log(err + "错误")
        })
    },
    get_upgradeinfo(sno) {
      console.log(sno)
      this.$router.push({
        path:'/teacher_upinfo',
        query:{Sno:sno}
      });

    }

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
  color: #03ff2a;
}

.head {
  color: white;
}

.head:hover {
  background-color: #FFFFFfcc;
  transition: all .5s;
}

.headhd {
  height: 20px;
  size: 16px;
}

.headhh {
  height: 20px;
  size: 14px;
}

.bodystyle {
  background-color: #e7e7e7;
  border-radius: 30px;
}

.zuoce {
  background-color: rgba(210, 250, 231, 0.87);
  border-radius: 30px;
  text-align: center;
  align-items: center;

}

.zuocehead {
  height: 30%;
  background-color: rgba(255, 255, 255, 1);
  border-radius: 30px;
}

.zuoceimage {
  height: 70%;

}

.userinfo {
  height: 15%;
  color: #071797;
}

.alink {
  color: #071797;
}

.alink:hover {
  transition: all .5s;
  background-color: #e7e7f1;
  border-radius: 30px;
  z-index: 99;
}

.youce {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
}


/* 小圆点 */
.sec2_circle1 {
  background: white;
  background: linear-gradient(
    to right bottom,
    rgba(203, 255, 255, 0.3),
    rgba(237, 255, 254, 0.3)
  );
  height: 20rem;
  width: 20rem;
  position: absolute;
  border-radius: 10%;
  bottom: 45%;
  left: 33%;
  z-index: 1;
}

.sec2_circle2 {
  background: white;
  background: linear-gradient(
    to right bottom,
    rgba(206, 255, 228, 0.8),
    rgba(255, 255, 255, 0.3)
  );
  height: 20rem;
  width: 20rem;
  position: absolute;
  border-radius: 10%;
  top: 15%;
  right: 5%;
  transform: rotate(45deg);
  z-index: 1;
}

.sec2_circle3 {
  background: white;
  background: linear-gradient(
    to right bottom,
    rgba(255, 225, 225, 0.8),
    rgba(255, 255, 255, 0.3)
  );
  height: 20rem;
  width: 20rem;
  position: absolute;
  border-radius: 10%;
  bottom: 5%;
  right: 80%;
  z-index: 1;
}

.tabletitle {
  height: 10%;
  text-align: center;
  background-color: rgba(255, 255, 255, 0.3);
  margin-top: 10px;
  font-family: KaiTi;
  color: #121313;
  padding: 10px;

}

.tablehead {
  height: 10%;
  background-color: #555555;
  text-align: center;
  color: #fff;
  text-transform: uppercase;
  padding: 18px;

}

.tablebody {
  height: 10%;
  padding: 10px;
  /*background-color: #c9c9c9;*/
  text-align: center;
  border: 1px solid gray;
}
</style>
