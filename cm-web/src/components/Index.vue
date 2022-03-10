<template>
  <el-container>
    <el-header style="background-color: #324057; height: 70px;">Header</el-header>
    <el-container :style="{height: containerHeight}">
      <el-aside width="200px;" style="padding: 5px;">
        <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
          <el-radio-button :label="false">展开</el-radio-button>
          <el-radio-button :label="true">收起</el-radio-button>
        </el-radio-group>
        <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span slot="title">导航一rrrrrrttttt</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group>
              <el-menu-item index="1-3">选项3</el-menu-item>
              <el-menu-item index="1-4">选项3</el-menu-item>
              <el-menu-item index="1-5">选项3</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group>
              <el-menu-item index="1-6">选项4</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span slot="title">导航二</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group>
              <el-menu-item index="2-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="2-4">
              <el-menu-item index="2-4-1">选项1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-menu-item index="3">
            <i class="el-icon-menu"></i>
            <span slot="title">导航san</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-main>Main测试</el-main>
    </el-container>
  </el-container>
</template>

<script>
  export default {
    name: 'Index',
    data() {
      return {
        containerStyle: {
          height: '',
        },
        isCollapse: true
      }
    },
    computed: {
      containerHeight: function () {
        return (window.innerHeight - 70) + 'px';
      }
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    },
    created() {

    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
  }
  >>> .el-submenu__title {
    text-align: left;
  }
  >>> .el-menu-item {
    text-align: left;
  }
</style>
