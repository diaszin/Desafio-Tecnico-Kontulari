import { profileService } from '../../services/instances'
import { useQuery } from '@tanstack/react-query'
import GithubProfile from '../../types/GithubProfile'
import Loading from '../Loading'
import SimpleErrorText from '../SimpleErrorText'
import ProfileBannerHead from './ProfileBannerHead'
import ProfileBannerBody from './ProfileBannerBody'

interface ProfileBannerProps{
  username: string
}

function searchGithubProfile(username: string): Promise<GithubProfile>{
  return profileService.getGithubUser(username).then(data => data).catch((e) =>{
    console.error(e)
    throw new Error(e.response.data.message)
  })
}

export default  function ProfileBanner(props: ProfileBannerProps) {
  const {data, error, isLoading} = useQuery<GithubProfile>({
    queryKey: ["profile", props.username],
    queryFn: () => searchGithubProfile(props.username),
    retry: false,
    refetchOnWindowFocus: false,
  })

  

  
  if(isLoading){
    return <Loading/>
  }

  if(error){
    return <SimpleErrorText message={error.message}/>
  }

  if(!data){
    return null
  }

  return (
    <a target='_blank' href={data.html_url} className='flex flex-col gap-4 p-6 w-[60%] h-max bg-gray-700 rounded-md bg-clip-padding backdrop-filter backdrop-blur-sm bg-opacity-40 outline-none max-lg:w-[90%]'>
      <ProfileBannerHead createdAt={data.created_at} photoUrl={data.avatar_url} login={data.login} followers={data.followers}  />
      <hr className='opacity-35' />
      <ProfileBannerBody qntRepos={data.public_repos} description={data.description}/>
    </a>
  )
}
