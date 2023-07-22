import request from '@/utils/request'

// 查询一次评价列表
export function listAssessment(query) {
  return request({
    url: '/system/assessment/list',
    method: 'get',
    params: query
  })
}

// 查询一次评价详细
export function getAssessment(assessmentId) {
  return request({
    url: '/system/assessment/' + assessmentId,
    method: 'get'
  })
}

// 新增一次评价
export function addAssessment(data) {
  return request({
    url: '/system/assessment',
    method: 'post',
    data: data
  })
}

// 修改一次评价
export function updateAssessment(data) {
  return request({
    url: '/system/assessment',
    method: 'put',
    data: data
  })
}

// 删除一次评价
export function delAssessment(assessmentId) {
  return request({
    url: '/system/assessment/' + assessmentId,
    method: 'delete'
  })
}
