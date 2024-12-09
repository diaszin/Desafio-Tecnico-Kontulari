import Image from "next/image"


interface ProfileBannerHeadProps{
  photoUrl: string
  login: string
  followers: number
  createdAt: string
}

export default function ProfileBannerHead(props: ProfileBannerHeadProps) {
  return (
    <div className='w-full flex items-center justify-between'>
        <div className='flex items-center gap-4 w-full max-lg:flex-col'>
          <Image className='rounded-full' src={props.photoUrl} alt={`Foto de perfil do @${props.login}`} width={84} height={84}/>
          <div className='w-full grid grid-flow-row-dense grid-cols-2 grid-rows-2 justify-between gap-x-4 max-lg:grid-cols-1'>
            <span className='text-lg'>{props.login}</span>
            <span className='text-gray-400'>@{props.login}</span>
            <div className='flex items-center gap-3'>
              <span className='text-gray-400'>Qntd Seguidores</span>
              <span>{props.followers}</span>
            </div>
            <div className='flex items-center gap-3'>
              <span className='text-gray-400'>Criado em </span>
              <span>{props.createdAt}</span>
            </div>
          </div>

        </div>
        
      </div>
  )
}
