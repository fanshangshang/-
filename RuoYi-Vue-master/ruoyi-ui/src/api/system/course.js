import request from '@/utils/request'

// 查询课程，对应某学期某个教师所授课程列表
export function listCourse(query) {
  return request({
    url: '/system/course/list',
    method: 'get',
    params: query
  })
}

// 查询课程，对应某学期某个教师所授课程详细
export function getCourse(courseId) {
  return request({
    url: '/system/course/' + courseId,
    method: 'get'
  })
}

// 新增课程，对应某学期某个教师所授课程
export function addCourse(data) {
  return request({
    url: '/system/course',
    method: 'post',
    data: data
  })
}

// 修改课程，对应某学期某个教师所授课程
export function updateCourse(data) {
  return request({
    url: '/system/course',
    method: 'put',
    data: data
  })
}

// 删除课程，对应某学期某个教师所授课程
export function delCourse(courseId) {
  return request({
    url: '/system/course/' + courseId,
    method: 'delete'
  })
}
