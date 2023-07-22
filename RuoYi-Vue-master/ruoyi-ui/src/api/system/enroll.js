import request from '@/utils/request'

// 查询选课信息，包含某学生选择某课程之后的各种成绩组成列表
export function listEnroll(query) {
  return request({
    url: '/system/enroll/list',
    method: 'get',
    params: query
  })
}

// 查询选课信息，包含某学生选择某课程之后的各种成绩组成详细
export function getEnroll(enrollId) {
  return request({
    url: '/system/enroll/' + enrollId,
    method: 'get'
  })
}

// 新增选课信息，包含某学生选择某课程之后的各种成绩组成
export function addEnroll(data) {
  return request({
    url: '/system/enroll',
    method: 'post',
    data: data
  })
}

// 修改选课信息，包含某学生选择某课程之后的各种成绩组成
export function updateEnroll(data) {
  return request({
    url: '/system/enroll',
    method: 'put',
    data: data
  })
}

// 删除选课信息，包含某学生选择某课程之后的各种成绩组成
export function delEnroll(enrollId) {
  return request({
    url: '/system/enroll/' + enrollId,
    method: 'delete'
  })
}
