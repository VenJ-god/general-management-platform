import axios from "axios";
import Router from "vue-router";

let config = {
  // baseURL: process.env.baseURL || process.env.apiUrl || "",
  baseURL: 'http://localhost:8081/cm',
  // timeout: 5*1000,
  withCredentials: true,
  headers: {'Content-Type': 'application/json;charset=utf-8'},
}

const axios_ = axios.create(config);

// 请求拦截器
axios_.interceptors.request.use(
  function (config) {
    return config;
  },
  function (error) {
    return Promise.reject(error);
  }
)
// 响应拦截器
axios_.interceptors.response.use(
  function (response) {
    if (response.data.code == 401) {
      this.$router.push("/login")
    }
    return response;
  },
  function (error) {
    return Promise.reject(error);
  }
)
export default axios_
