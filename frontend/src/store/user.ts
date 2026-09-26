import { defineStore } from 'pinia'
import { login as loginApi } from '@/api/auth'

export const useUserStore = defineStore('user', {
  state: () => ({
    token: localStorage.getItem('mes_token') || '',
    userInfo: JSON.parse(localStorage.getItem('mes_user') || 'null')
  }),
  actions: {
    async login(username: string, password: string) {
      const res: any = await loginApi({ username, password })
      this.token = res.data.token
      this.userInfo = res.data.user
      localStorage.setItem('mes_token', this.token)
      localStorage.setItem('mes_user', JSON.stringify(this.userInfo))
      return res
    },
    logout() {
      this.token = ''
      this.userInfo = null
      localStorage.removeItem('mes_token')
      localStorage.removeItem('mes_user')
    }
  }
})
