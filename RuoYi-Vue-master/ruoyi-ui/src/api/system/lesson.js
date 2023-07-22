import request from '@/utils/request'

// 查询某个周某个时段的某次课列表
export function listLesson(query) {
  return request({
    url: '/system/lesson/list',
    method: 'get',
    params: query
  })
}

// 查询某个周某个时段的某次课详细
export function getLesson(lessonId) {
  return request({
    url: '/system/lesson/' + lessonId,
    method: 'get'
  })
}

// 新增某个周某个时段的某次课
export function addLesson(data) {
  return request({
    url: '/system/lesson',
    method: 'post',
    data: data
  })
}

// 修改某个周某个时段的某次课
export function updateLesson(data) {
  return request({
    url: '/system/lesson',
    method: 'put',
    data: data
  })
}

// 删除某个周某个时段的某次课
export function delLesson(lessonId) {
  return request({
    url: '/system/lesson/' + lessonId,
    method: 'delete'
  })
}
