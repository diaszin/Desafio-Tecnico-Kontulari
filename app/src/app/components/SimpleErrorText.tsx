interface SimpleErrorTextProps{
  message?: string
}

export default function SimpleErrorText(props: SimpleErrorTextProps) {
  return (
    <div className='flex items-center justify-center'>
      <span className='text-gray-300'>{props.message || "Não foi possível consultar o perfil"}</span>
    </div>
  )
}