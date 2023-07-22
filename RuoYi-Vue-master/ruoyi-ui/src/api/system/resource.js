import request from '@/utils/request'

// 查询课程资源，比如教学大纲，教案，电子教材以及实验要求等列表
export function listResource(query) {
  return request({
    url: '/system/resource/list',
    method: 'get',
    params: query
  })
}

// 查询课程资源，比如教学大纲，教案，电子教材以及实验要求等详细
export function getResource(resourceId) {
  return request({
    url: '/system/resource/' + resourceId,
    method: 'get'
  })
}

// 新增课程资源，比如教学大纲，教案，电子教材以及实验要求等
export function addResource(data) {
  return request({
    url: '/system/resource',
    method: 'post',
    data: data
  })
}

// 修改课程资源，比如教学大纲，教案，电子教材以及实验要求等
export function updateResource(data) {
  return request({
    url: '/system/resource',
    method: 'put',
    data: data
  })
}

// 删除课程资源，比如教学大纲，教案，电子教材以及实验要求等
export function delResource(resourceId) {
  return request({
    url: '/system/resource/' + resourceId,
    method: 'delete'
  })
}
