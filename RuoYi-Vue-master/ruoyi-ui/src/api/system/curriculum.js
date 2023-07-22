import request from '@/utils/request'

// 查询大纲课程信息列表
export function listCurriculum(query) {
  return request({
    url: '/system/curriculum/list',
    method: 'get',
    params: query
  })
}

// 查询大纲课程信息详细
export function getCurriculum(curriculumId) {
  return request({
    url: '/system/curriculum/' + curriculumId,
    method: 'get'
  })
}

// 新增大纲课程信息
export function addCurriculum(data) {
  return request({
    url: '/system/curriculum',
    method: 'post',
    data: data
  })
}

// 修改大纲课程信息
export function updateCurriculum(data) {
  return request({
    url: '/system/curriculum',
    method: 'put',
    data: data
  })
}

// 删除大纲课程信息
export function delCurriculum(curriculumId) {
  return request({
    url: '/system/curriculum/' + curriculumId,
    method: 'delete'
  })
}
