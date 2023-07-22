import request from '@/utils/request'

// 查询题目，用于生成试卷或者平时测试用列表
export function listExercise(query) {
  return request({
    url: '/system/exercise/list',
    method: 'get',
    params: query
  })
}

// 查询题目，用于生成试卷或者平时测试用详细
export function getExercise(exerciseId) {
  return request({
    url: '/system/exercise/' + exerciseId,
    method: 'get'
  })
}

// 新增题目，用于生成试卷或者平时测试用
export function addExercise(data) {
  return request({
    url: '/system/exercise',
    method: 'post',
    data: data
  })
}

// 修改题目，用于生成试卷或者平时测试用
export function updateExercise(data) {
  return request({
    url: '/system/exercise',
    method: 'put',
    data: data
  })
}

// 删除题目，用于生成试卷或者平时测试用
export function delExercise(exerciseId) {
  return request({
    url: '/system/exercise/' + exerciseId,
    method: 'delete'
  })
}
