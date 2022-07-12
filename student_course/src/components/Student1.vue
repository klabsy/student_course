<template>
  <div id="wrapper">
    <h1>学生信息</h1>
    <router-link to="/course">科目</router-link>
<!--    <el-row>-->
<!--      <el-button type="success" icon="el-icon-plus" circle @click="addinfo" ></el-button>-->
<!--      <el-button type="danger" icon="el-icon-delete" circle @click="delinfo(1123151)" ></el-button>-->
<!--      <el-button type="primary" icon="el-icon-edit" circle @click="upgradeinfo(1121511)"></el-button>-->
<!--      <el-button icon="el-icon-search" circle></el-button>-->
<!--    </el-row>-->

<!--    <table id="keywords" >-->
<!--      <thead>-->
<!--      <tr>-->
<!--        <th><span>学号</span></th>-->
<!--        <th><span>姓名</span></th>-->
<!--        <th><span>性别</span></th>-->
<!--        <th><span>所在系</span></th>-->
<!--        <th><span>年龄</span></th>-->
<!--      </tr>-->

<!--      </thead>-->
<!--      <tbody>-->
<!--      <tr v-for="message in info" :key="message.id">-->
<!--        <td class="lalign">{{ message.sno }}</td>-->
<!--        <td>{{ message.sname }}</td>-->
<!--        <td>{{ message.ssex }}</td>-->
<!--        <td>{{ message.sdept }}</td>-->
<!--        <td>{{ message.sage }}</td>-->
<!--      </tr>-->
<!--      </tbody>-->
<!--    </table>-->

    <el-table
      :data="info.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
      style="width: 120%">
      <el-table-column
        label="学号"
        prop="sno"
        width="120">
      </el-table-column>
      <el-table-column
        label="姓名"
        prop="sname"
        width="120">
      </el-table-column>
      <el-table-column
        label="性别"
        prop="ssex"
        width="120">
      </el-table-column>
      <el-table-column
        label="科目"
        prop="sdept"
        width="120">
      </el-table-column>
      <el-table-column
        label="年龄"
        prop="sage"
        width="120">
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
              @click="dialogaddFormVisible = true"
              >add</el-button>
        </template>
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="get_courseinfo(scope.$index, scope.row)">查看</el-button>
          <el-button
            size="mini"
            @click="get_upgradeinfo(scope.$index, scope.row)">Edit</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="delinfo(scope.$index, scope.row)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>

<!--    添加-->
    <el-dialog title="添加学生" :visible.sync="dialogaddFormVisible" width="30%">
      <el-form :model="a_info">
        <el-form-item label="学号" :label-width="formLabelWidth">
          <el-input v-model="a_info.sno" ></el-input>
        </el-form-item>
        <el-form-item label="姓名" :label-width="formLabelWidth">
          <el-input v-model="a_info.sname" ></el-input>
        </el-form-item>
        <el-form-item label="性别" :label-width="formLabelWidth">
          <el-select v-model="a_info.ssex" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.ssex"
              :label="item.label"
              :value="item.ssex">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="科目" :label-width="formLabelWidth">
          <el-input v-model="a_info.sdept" ></el-input>
        </el-form-item>
        <el-form-item label="年龄" :label-width="formLabelWidth">
          <el-input v-model="a_info.sage" ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogaddFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addinfo">确 定</el-button>
      </div>
    </el-dialog>
    <!--    编辑-->
    <el-dialog title="编辑学生" :visible.sync="dialogupgradeFormVisible" width="30%">
      <el-form :model="g_info">
<!--        <el-form-item label="学号" :label-width="formLabelWidth">-->
<!--          <el-input v-model="g_info.sno" ></el-input>-->
<!--        </el-form-item>-->
        <el-form-item label="姓名" :label-width="formLabelWidth">
          <el-input v-model="g_info.sname" ></el-input>
        </el-form-item>
        <el-form-item label="性别" :label-width="formLabelWidth">
          <el-select v-model="g_info.ssex" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.ssex"
              :label="item.label"
              :value="item.ssex">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="科目" :label-width="formLabelWidth">
          <el-input v-model="g_info.sdept" ></el-input>
        </el-form-item>
        <el-form-item label="年龄" :label-width="formLabelWidth">
          <el-input v-model="g_info.sage" ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogupgradeFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="upgradeinfo(g_info.sno)">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>

export default {
  name: 'HelloWorld',
  data() {
    return {
      dialogTableVisible: false,
      dialogaddFormVisible: false,
      dialogupgradeFormVisible: false,

      formLabelWidth: '80px',
      search: '',
      ssex: '',
      options: [{
        ssex: '男',
        label: '男'
      }, {
        ssex: '女',
        label: '女'
      }],
      info: [
        {
          Sno: 111,
          Sname: "",
          Ssex: "",
          Sdept: "",
          Sage: null
        }
      ],
      a_info:{
        "ssex": "男",
        "sno": 11215121,
        "sname": "王五",
        "sdept": "CS",
        "sage": 19
      },
      g_info:{
        Sno: null,
        Sname: "",
        Ssex: "",
        Sdept: "",
        Sage: null
      }
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
  methods:{
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
    addinfo() {
      console.log(this.a_info);
      this.$http.post('/api/student_course_springMVC_war_exploded/student/add_Student',this.a_info)
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
      console.log(row.sno);
      this.$http.delete('/api/student_course_springMVC_war_exploded/student/del_Student/'+row.sno)
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
    get_upgradeinfo(index, row){
      console.log(row)
      this.$http.post('/api/student_course_springMVC_war_exploded/student/id_UpdateStudent/'+row.sno)
        .then(res => {
          this.g_info = res.data
          // console.log(this.g_info)
          this.dialogupgradeFormVisible = true
          // console.log("test")
        })
        .catch(err => {
          console.log(err + "错误")
        })
    },
    upgradeinfo(sno) {
      this.$http.put('/api/student_course_springMVC_war_exploded/student/updateStudent/'+sno,this.g_info)
        .then(res => {
          // this.info = res.data
          this.get_info()
          this.dialogupgradeFormVisible = false
          // console.log(this.info)
          console.log("test")
        })
        .catch(err => {
          console.log(err + "错误")
        })
    },
    get_courseinfo(index, row){
      console.log(row)
      this.$router.push({
        path:'/stuSc',
        query:{Sno:row.sno}
      });
    }

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
