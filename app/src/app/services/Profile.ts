import axios from "axios"
import GithubProfile from "../types/GithubProfile"

export default class Profile{
    
    private BASE_URL: string = process.env.NEXT_PUBLIC_BACKEND_URL + "/profile"

    async getGithubUser(username: string): Promise<GithubProfile>{
        const endpoint = `${this.BASE_URL}/${username}/user`
        const response = await axios.get(endpoint)
        return response.data
    }

    async getGithubRepositoriesByUser(username: string) {
      const endpoint = `${this.BASE_URL}/${username}/repositories`
      const response = await axios.get(endpoint)
      return response.data
    }
}