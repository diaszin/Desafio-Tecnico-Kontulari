import { profileService } from '../services/instances'
import { useQuery } from '@tanstack/react-query'
import GithubProfile from '../types/GithubProfile'
import Image from 'next/image'
import Loading from './Loading'
import SimpleErrorText from './SimpleErrorText'

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
      <div className='w-full flex items-center justify-between'>
        <div className='flex items-center gap-4 w-full max-lg:flex-col'>
          <Image className='rounded-full' src={data.avatar_url} alt={`Foto de perfil do @${data.login}`} width={84} height={84}/>
          <div className='w-full grid grid-flow-row-dense grid-cols-2 grid-rows-2 justify-between gap-x-4 max-lg:grid-cols-1'>
            <span className='text-lg'>{data.login}</span>
            <span className='text-gray-400'>@{data.login}</span>
            <div className='flex items-center gap-3'>
              <span className='text-gray-400'>Qntd Seguidores</span>
              <span>{data.followers}</span>
            </div>
            <div className='flex items-center gap-3'>
              <span className='text-gray-400'>Criado em </span>
              <span>{data.created_at}</span>
            </div>
          </div>

        </div>
        
      </div>
      <hr className='opacity-35' />
      <div>
        <div className='flex flex-col gap-1'>
          <span className='text-gray-400'>Qntd de Repositórios</span>
          <span className='text-lg'>{data.public_repos}</span>
        </div>
      </div>
      <p className='w-full text-justify h-[6rem] text-ellipsis overflow-hidden'>
        {data.description}
      </p>
    </a>
  )
}
