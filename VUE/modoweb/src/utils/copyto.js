import { Base64 } from 'js-base64'
import crypto from 'crypto-js'

function base64Encoed (str) {
  return Base64.encode(str)
}
function base64Decode (encodestr) {
  return Base64.decode(encodestr)
}
function encopt (message, key) {
  return crypto.AES.encrypt(message, key).toString()
}
function decopt (message, key) {
  return crypto.AES.decrypt(message, key).toString()
}
export default {
  base64Encoed,
  base64Decode,
  encopt,
  decopt
}
