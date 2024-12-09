interface SimpleErrorTextProps{
  message?: string
}

export default function SimpleErrorText(props: SimpleErrorTextProps) {
  return (
    <div className='flex items-center justify-center'>
      <span className='text-gray-300'>{props.message || "Não encontramos nenhum repositório"}</span>
    </div>
  )
}