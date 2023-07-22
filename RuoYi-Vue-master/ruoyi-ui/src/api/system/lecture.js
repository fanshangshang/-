import request from '@/utils/request'

// 查询示某一讲列表
export function listLecture(query) {
  return request({
    url: '/system/lecture/list',
    method: 'get',
    params: query
  })
}

// 查询示某一讲详细
export function getLecture(lectureId) {
  return request({
    url: '/system/lecture/' + lectureId,
    method: 'get'
  })
}

// 新增示某一讲
export function addLecture(data) {
  return request({
    url: '/system/lecture',
    method: 'post',
    data: data
  })
}

// 修改示某一讲
export function updateLecture(data) {
  return request({
    url: '/system/lecture',
    method: 'put',
    data: data
  })
}

// 删除示某一讲
export function delLecture(lectureId) {
  return request({
    url: '/system/lecture/' + lectureId,
    method: 'delete'
  })
}
