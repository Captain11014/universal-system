import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/getInfo',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/logout',
    method: 'post'
  })
}

/**获取验证码 */
export function getCaptchaImg() {
  return request({
    url: '/captchaImage',
    method: 'get'
  })
}

/**获取注册验证码 */
export function getRegisterCaptcha(param) {
  return request({
    url: '/getRegisterCaptcha/'+param,
    method: 'get'
  })
}


// 注册方法
export function register(data) {
  return request({
    url: '/register',
    headers: {
      isToken: false
    },
    method: 'post',
    data: data
  })
}