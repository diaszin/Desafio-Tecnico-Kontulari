import { GithubRepositories } from '@/app/types/GithubRepositories'
import React from 'react'

export default function ProfileRepositoriesCard(props: GithubRepositories) {
  return (
    <a href={props.html_url} target='_blank' className='flex flex-col gap-4 p-6 w-full min-h-[14rem] bg-gray-700 rounded-md bg-clip-padding backdrop-filter backdrop-blur-sm bg-opacity-40 outline-none'>
      <div className='flex w-full justify-between max-md:flex-col'>
        <span className='w-full text-lg'>{props.name}</span>
        <span className='w-[80%] text-ellipsis overflow-hidden text-gray-400'>{props.full_name}</span>
      </div>
      <hr />
      <div className='w-full flex flex-col gap-2 h-full'>
        <div className='flex justify-between items-center w-full'>
          <span className='text-gray-400'>Criado em</span>
          <span>{props.created_at}</span>
        </div>  
        <p className='h-full text-ellipsis overflow-hidden'>{props.description}</p>  
      </div>
    </a>
  )
}
