import React from 'react'
import ProfileRepositoriesCard from './ProfileRepositoriesCard'
import { GithubRepositories } from '@/app/types/GithubRepositories'


interface ProfileRepositoriesListProps{
  repositories: GithubRepositories[]
}

export default function ProfileRepositoriesList(props: ProfileRepositoriesListProps) {
  return (
    <div className='p-8 grid grid-cols-3 max-md:grid-cols-1 max-lg:grid-cols-[50%,50%] gap-3 w-full justify-center'>
      {props.repositories.map((repositorie, ind) => (<ProfileRepositoriesCard key={ind} {...repositorie}/>))}
    </div>
  )
}
