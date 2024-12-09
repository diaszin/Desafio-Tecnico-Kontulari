
interface ProfileBannerBodyProps{
  qntRepos: number
  description: string
}

export default function ProfileBannerBody(props: ProfileBannerBodyProps) {
  return <>
    <div>
        <div className='flex flex-col gap-1'>
          <span className='text-gray-400'>Qntd de Repositórios</span>
          <span className='text-lg'>{props.qntRepos}</span>
        </div>
      </div>
      <p className='w-full text-justify h-[6rem] text-ellipsis overflow-hidden'>
        {props.description}
      </p>
  </>
      
  
}
