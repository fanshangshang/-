import request from '@/utils/request'

// 查询题目任务关系列表
export function listCheck(query) {
  return request({
    url: '/system/check/list',
    method: 'get',
    params: query
  })
}

// 查询题目任务关系详细
export function getCheck(checkId) {
  return request({
    url: '/system/check/' + checkId,
    method: 'get'
  })
}

// 新增题目任务关系
export function addCheck(data) {
  return request({
    url: '/system/check',
    method: 'post',
    data: data
  })
}

// 修改题目任务关系
export function updateCheck(data) {
  return request({
    url: '/system/check',
    method: 'put',
    data: data
  })
}

// 删除题目任务关系
export function delCheck(checkId) {
  return request({
    url: '/system/check/' + checkId,
    method: 'delete'
  })
}
