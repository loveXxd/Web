import axios from 'axios'
import qs from 'qs'

function loadingshow (root) {
  root.$Spin.show({
    render: (h) => {
      return h('div', [
        h('Icon', {
          'class': 'demo-spin-icon-load',
          props: {
            type: 'ios-loading',
            size: 18
          }
        }),
        h('div', 'Loading')
      ])
    }
  })
}
function loadinghide (root) {
  root.$Spin.hide()
}
function post (url, parm, handler) {
  axios.post(url, qs.stringify(parm)).then((data) => {
    handler(data)
  })
}
function get (url, parm, handler) {
  axios.get(url, qs.stringify(parm)).then((data) => {
    handler(data)
  })
}
export default {
  post,
  get,
  loadingshow,
  loadinghide
}
