import request from './request'

export function login(data: { username: string; password: string }) {
  return request.post('/auth/login', data)
}

export function getUserInfo(username: string) {
  return request.get('/auth/info', { params: { username } })
}
