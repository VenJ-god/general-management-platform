import request from "../request/request";

export function login(data) {
  return request({
    url: '/login',
    method: 'post',
    params: data
  })
}
