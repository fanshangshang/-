import request from '@/utils/request'

// 查询学习任务，比如一次作业，一次随堂测试等。列表
export function listTask(query) {
  return request({
    url: '/system/task/list',
    method: 'get',
    params: query
  })
}

// 查询学习任务，比如一次作业，一次随堂测试等。详细
export function getTask(taskId) {
  return request({
    url: '/system/task/' + taskId,
    method: 'get'
  })
}

// 新增学习任务，比如一次作业，一次随堂测试等。
export function addTask(data) {
  return request({
    url: '/system/task',
    method: 'post',
    data: data
  })
}

// 修改学习任务，比如一次作业，一次随堂测试等。
export function updateTask(data) {
  return request({
    url: '/system/task',
    method: 'put',
    data: data
  })
}

// 删除学习任务，比如一次作业，一次随堂测试等。
export function delTask(taskId) {
  return request({
    url: '/system/task/' + taskId,
    method: 'delete'
  })
}
