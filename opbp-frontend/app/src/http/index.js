import axios from 'axios'
import router from '@/router'

axios.interceptors.response.use(
  response => response,
  error => {
    if (error.response.status === 401 || error.response.status === 403) {
      router.go('/')
    }

    return Promise.reject(error)
  })

export default axios
