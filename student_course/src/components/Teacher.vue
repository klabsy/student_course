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
<!--              <el-row style="height: 10%">-->
<!--                <div>-->
<!--                  <router-link to="/teacher_addgrade" class="alink">-->
<!--                    添加成绩-->
<!--                  </router-link>-->
<!--                </div>-->
<!--              </el-row>-->
            </div>
          </el-col>
          <el-col :span="1"></el-col>
          <el-col :span="16" class="youce">
            <div style="background-color: #ffffff4D;border-radius: 30px;">
              <el-row>
                <el-col :span="24" style="height: 70%">
                  <div>
                    <el-avatar :size="200" style="margin-top: 100px;">
                      <img src="https://z3.ax1x.com/2021/05/04/gnKXVg.jpg"/>
                    </el-avatar>
                  </div>
                </el-col>
                <el-col :span="24" style="height: 30%">
                  <el-row style="height: 10%;color: #10d0e8;">
                    人生没有目的，只有过程，所谓的终极目的是虚无的。
                  </el-row>
                  <el-row style="height: 10%;margin-top: 10px;color: #10d0e8;">
                    人的情况和树相同。它愈想开向高处和明亮处，它的根愈要向下，
                  </el-row>
                  <el-row style="height: 10%;margin-top: 10px;color: #10d0e8;">
                    向泥土，向黑暗处，向深处，向恶。——尼采
                  </el-row>
                </el-col>
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
  name: 'Course',
  data() {
    return {}
  },
  beforeCreate() {
  },
  methods: {}
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
}

.youce {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
}

.poem {
  color: #93a8ff;
  margin-top: 100px;
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
}
</style>
