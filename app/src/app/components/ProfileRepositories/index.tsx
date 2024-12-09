import { useQuery } from '@tanstack/react-query'
import React from 'react'
import Loading from '../Loading'
import ProfileRepositoriesList from './ProfileRepositoriesList'
import SimpleErrorText from '../SimpleErrorText'
import { profileService } from '@/app/services/instances'


interface ProfileRepositoriesProps{
  username: string
}

function getRepositories(username: string){
  return profileService.getGithubRepositoriesByUser(username).catch(e =>{
    throw new Error(e.response.data.message)
  })
}

export default function ProfileRepositories(props: ProfileRepositoriesProps) {
  const fetchProfileQuery  = useQuery({
    queryKey: ["profile", props.username]
  })

  const {data, isLoading, error} = useQuery({
    queryKey: ['repositories', props.username],
    queryFn: ()=>getRepositories(props.username),
    retry: false,
    refetchOnWindowFocus: false,
    enabled: fetchProfileQuery.isSuccess
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
    <div className='w-full flex flex-col'>
      <h2 className='self-center text-[2rem] text-gray-300'>Repositórios</h2>
      <ProfileRepositoriesList repositories={data}/>
    </div>
  )
}
