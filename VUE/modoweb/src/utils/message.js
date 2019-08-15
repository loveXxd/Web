function info (root, message = '') {
  root.$Modal.info({
    title: '信息',
    content: message
  })
}
function success (root, message = '操作成功') {
  root.$Modal.success({
    title: '成功',
    content: message
  })
}
function warning (root, message = '操作有警告') {
  root.$Modal.warning({
    title: '警告',
    content: message
  })
}
function error (root, message = '操作失败') {
  root.$Modal.error({
    title: '错误',
    content: message
  })
}
export default {
  info,
  success,
  warning,
  error
}
