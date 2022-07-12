<template>
  <div id="wrapper">
    <h1>学生选课信息</h1>
    <router-link to="/">学生信息</router-link>

    <el-table
      :data="info.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
      style="width: 120%">
      <el-table-column
        label="学号"
        prop="sno"
        width="100">
      </el-table-column>
      <el-table-column
        label="姓名"
        prop="sname"
        width="80">
      </el-table-column>
      <el-table-column
        label="课程号"
        prop="cno">
      </el-table-column>
      <el-table-column
        label="课程名"
        prop="cname">
      </el-table-column>
      <el-table-column
        label="成绩"
        prop="grade"
        width="120">
      </el-table-column>
      <el-table-column
        label="学分"
        prop="ccredit">
      </el-table-column>
      <el-table-column
        align="right">
        <template slot="header" slot-scope="scope">
          <el-col :span="12">
            <el-input
              v-model="search"
              size="mini"
              placeholder="输入关键字搜索"/>
          </el-col>
          <el-button
            size="mini"
            type="danger"
            @click="addinfo"
          >add</el-button>
        </template>
        <template slot-scope="scope">
<!--          <el-button-->
<!--            size="mini"-->
<!--            @click="get_upgradeinfo(scope.$index, scope.row)">Edit</el-button>-->
          <el-button
            size="mini"
            type="danger"
            @click="delinfo(scope.$index, scope.row)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>

<!--    添加-->
    <el-dialog title="添加课程" :visible.sync="dialogaddFormVisible" width="30%">
      <el-form :model="a_info">
        <el-select v-model="cno" placeholder="课程名">
          <el-option
            v-for="item in options"
            :key="item.cno"
            :label="item.cname"
            :value="item.cno">
          </el-option>
        </el-select>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogaddFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addinfo">确 定</el-button>
      </div>
    </el-dialog>
<!--    &lt;!&ndash;    编辑&ndash;&gt;-->
<!--    <el-dialog title="编辑科目" :visible.sync="dialogupgradeFormVisible" width="30%">-->
<!--      <el-form :model="g_info">-->
<!--        <el-form-item label="科目名" :label-width="formLabelWidth">-->
<!--          <el-input v-model="g_info.cname" ></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="Cpno" :label-width="formLabelWidth">-->
<!--          <el-input v-model="g_info.cpno" ></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="Ccredit" :label-width="formLabelWidth">-->
<!--          <el-input v-model="g_info.ccredit" ></el-input>-->
<!--        </el-form-item>-->
<!--      </el-form>-->
<!--      <div slot="footer" class="dialog-footer">-->
<!--        <el-button @click="dialogupgradeFormVisible = false">取 消</el-button>-->
<!--        <el-button type="primary" @click="upgradeinfo(g_info.cno)">确 定</el-button>-->
<!--      </div>-->
<!--    </el-dialog>-->
  </div>
</template>

<script>

export default {
  name: 'Course',
  data() {
    return {
      dialogTableVisible: false,
      dialogaddFormVisible: false,
      dialogupgradeFormVisible: false,

      formLabelWidth: '80px',
      search: '',
      info: [],
      a_info:{},
      g_info:{},
      cno:null,
      options:[]
    }
  },
  beforeCreate() {
    console.log(this.$route.query.Sno)

    this.$http.post('/api/student_course_springMVC_war_exploded/sc/id_UpdateSc/'+this.$route.query.Sno)
      .then(res => {
        this.info = res.data
        console.log(this.info)
      })
      .catch(err => {
        console.log(err + "错误")
      })
  },
  methods:{
    get_info(){
      this.$http.post('/api/student_course_springMVC_war_exploded/sc/id_UpdateSc/'+this.$route.query.Sno)
        .then(res => {
          this.info = res.data
          console.log(this.info)
        })
        .catch(err => {
          console.log(err + "错误")
        })
    },
    addinfo() {
      this.$http.get('/api/student_course_springMVC_war_exploded/course/get_allCourse')
        .then(res => {
          this.options = res.data
          this.dialogaddFormVisible = true
        })
        .catch(err => {
          console.log(err + "错误")
        })

      this.a_info.cno = this.cno
      this.a_info.sno = this.$route.query.Sno
      console.log(this.a_info)
      this.$http.post('/api/student_course_springMVC_war_exploded/sc/add_Sc',this.a_info)
        .then(res => {
          // this.info = res.data
          // console.log(this.info)
          console.log("test")
          this.get_info()
          this.dialogaddFormVisible = false
        })
        .catch(err => {
          console.log(err + "错误")
        })
    },

    delinfo(index, row) {
      console.log(index, row);
      console.log(row.cno);
      this.$http.delete('/api/student_course_springMVC_war_exploded/sc/del_Sc/'+ this.$route.query.Sno +"/"+row.cno)
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
    // get_upgradeinfo(index, row){
    //   console.log(row)
    //   this.$http.post('/api/student_course_springMVC_war_exploded/course/id_UpdateCourse/'+row.cno)
    //     .then(res => {
    //       this.g_info = res.data
    //       // console.log(this.g_info)
    //       this.dialogupgradeFormVisible = true
    //       // console.log("test")
    //     })
    //     .catch(err => {
    //       console.log(err + "错误")
    //     })
    // },
    // upgradeinfo(cno) {
    //   this.$http.put('/api/student_course_springMVC_war_exploded/course/updateCourse/'+cno,this.g_info)
    //     .then(res => {
    //       // this.info = res.data
    //       this.get_info()
    //       this.dialogupgradeFormVisible = false
    //       // console.log(this.info)
    //       console.log("test")
    //     })
    //     .catch(err => {
    //       console.log(err + "错误")
    //     })
    // }


  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#wrapper {
  display: block;
  width: 850px;
  background: #fff;
  margin: 0 auto;
  padding: 10px 17px;
  /*-webkit-box-shadow: 2px 2px 3px -1px rgba(0,0,0,0.35);*/
  box-shadow: 0 19px 38px rgba(0,0,0,0.30), 0 15px 12px rgba(0,0,0,0.22);
}

#keywords {
  margin: 0 auto;
  font-size: 1.2em;
  margin-bottom: 15px;
}


#keywords thead {
  cursor: pointer;
  background: #c9dff0;
}
#keywords thead tr th {
  font-weight: bold;
  padding: 12px 30px;
  padding-left: 42px;
}
#keywords thead tr th span {
  padding-right: 20px;
  background-repeat: no-repeat;
  background-position: 120% 120%;
}

#keywords thead tr th.headerSortUp, #keywords thead tr th.headerSortDown {
  background: #acc8dd;
}

#keywords thead tr th.headerSortUp span {
  background-image: url('https://i.imgur.com/SP99ZPJ.png');
}
#keywords thead tr th.headerSortDown span {
  background-image: url('https://i.imgur.com/RkA9MBo.png');
}


#keywords tbody tr {
  color: #555;
}
#keywords tbody tr td {
  text-align: center;
  padding: 15px 10px;
}
#keywords tbody tr td.lalign {
  text-align: left;
}
</style>
