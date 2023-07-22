import request from '@/utils/request'

// 查询成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。列表
export function listStrategy(query) {
  return request({
    url: '/system/strategy/list',
    method: 'get',
    params: query
  })
}

// 查询成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。详细
export function getStrategy(strategyId) {
  return request({
    url: '/system/strategy/' + strategyId,
    method: 'get'
  })
}

// 新增成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
export function addStrategy(data) {
  return request({
    url: '/system/strategy',
    method: 'post',
    data: data
  })
}

// 修改成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
export function updateStrategy(data) {
  return request({
    url: '/system/strategy',
    method: 'put',
    data: data
  })
}

// 删除成绩策略，可以让教师自定义各种成绩比例。并能够根据实际情况每学期进行调整。
export function delStrategy(strategyId) {
  return request({
    url: '/system/strategy/' + strategyId,
    method: 'delete'
  })
}
