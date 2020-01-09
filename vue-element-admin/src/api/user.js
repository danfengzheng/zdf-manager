import request from '@/utils/request'

export function login(data) {
  console.log('-------------------- function login')
  return request({
    url: '/index/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  console.log('获取token-------------')
  return request({
    url: '/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/user/logout',
    method: 'post'
  })
}
