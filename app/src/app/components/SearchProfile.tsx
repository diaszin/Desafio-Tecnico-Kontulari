import React, { useState } from 'react'


interface SearchProfileProps{
  onSearch: (text: string) => void
}

export default function SearchProfile(props: SearchProfileProps) {
  const [username, setUsername] = useState<string>()

  return (
   <form autoComplete='off' autoCorrect='off' onSubmit={(ev)=>{
    ev.preventDefault()
    if(username){
      props.onSearch(username)
    }
    
   }}>
    <div className='w-full flex items-center justify-between h-[3rem] gap-4'>
      <input onChange={(ev)=>{
        const typedUsername = ev.currentTarget.value
        if(typedUsername.trim().length > 0){
          setUsername(typedUsername)
        }
      }} placeholder='Digite o nome do usuário' autoFocus
      className='w-[32rem] px-4 outline-none h-full rounded-md font-inter text-[1.25rem] border-2 border-[#D9D9D9] placeholder:font-thin placeholder:text-white bg-transparent' 
      type="text" id="search-profile" />
      <button className='font-inter font-semibold rounded-md bg-[#3C3C3C] text-white h-full w-[9rem] transition-colors hover:bg-kontulari-color hover:opacity-85'>Buscar</button>
    </div>
   </form>
  )
}
