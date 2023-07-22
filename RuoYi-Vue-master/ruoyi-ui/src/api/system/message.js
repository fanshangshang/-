import request from '@/utils/request'

// 查询消息，可以用来示学生和教师之间的交互。列表
export function listMessage(query) {
  return request({
    url: '/system/message/list',
    method: 'get',
    params: query
  })
}

// 查询消息，可以用来示学生和教师之间的交互。详细
export function getMessage(messageId) {
  return request({
    url: '/system/message/' + messageId,
    method: 'get'
  })
}

// 新增消息，可以用来示学生和教师之间的交互。
export function addMessage(data) {
  return request({
    url: '/system/message',
    method: 'post',
    data: data
  })
}

// 修改消息，可以用来示学生和教师之间的交互。
export function updateMessage(data) {
  return request({
    url: '/system/message',
    method: 'put',
    data: data
  })
}

// 删除消息，可以用来示学生和教师之间的交互。
export function delMessage(messageId) {
  return request({
    url: '/system/message/' + messageId,
    method: 'delete'
  })
}
