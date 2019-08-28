import axios from 'axios'
import qs from 'qs'

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
  get
}
