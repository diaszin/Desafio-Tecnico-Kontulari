# Kontulari GithubSearch -  Desafio Fullstack Jr.

Esse projeto é a execução do desafio técnico que tem como objetivo realizar uma consulta para a api do github. Com o objetivo de consulta dos dados do perfil e repositórios do usuário. A integração consistia em 2 etapas, realizar a conexão com a api do github através do backend para consultar as informações necessárias do usuário e realizar a requisição para o backend através do frontend, mostrando de forma ilustrativa e visual dos dados obtidos do usuário pela api.



## Tecnologias Utilizadas

Para o projeto frontend, foi utilizados as seguintes tecnologias:

* Next.js
* React
* Typescript
* React-query (Gerenciamento das requisições)
* Tailwind CSS
* Axios



Para o projeto  backend foi utilizado:

* Spring Boot
* Gradle
* Rest Template
* Java 21



## Como executar o projeto ?

Para execução do projeto é necessário realizar algumas configurações. Tanto no frontend, quanto no backend é necessário ter uma `.env` como dependência para inicialização do projeto de forma correta.

Na pasta *api/* , coloque um `.env` com as seguintes informações:

``````bash
GITHUB_API=<api-do-github> # A URL da api do github
ACCEPTED_URL_CONNECTION= <url-do-frontend> # A URL do frontend
``````

Já na pasta *app/*, coloque um `.env` com:

``````bash
NEXT_PUBLIC_BACKEND_URL=<url-do-backend> # URL do backend 
``````

Mas em ambos os caso terá um `env.example` com os dados padrões, basta renomear para `.env`



Agora vamos a execução do projeto de fato. Para o frontend, execute os seguintes comandos:

``````bash
cd app/ # Caso esteja na pasta pai !
yarn install # Instala todas as dependências da aplicação frontend
yarn dev # Executa o projeto frontend
``````

No backend:

``````bash
cd api
./gradlew clean
./gradlew build
``````



Após tudo isso, basta colocar a url `http://localhost:3000` no seu navegador para ver a **aplicação rodando**.



## Estrutura do projeto

### Frontend

Na aplicação, seguimos a seguinte estrutura:

*/components* - Responsável pela estruturação dos componentes. Podendo seguir dois padrões que é o componente simples e o composto. 

O componente simples é definido pela chamada de um arquivo simples. Exemplo: `HelloWorld.tsx`, existe somente um elemento dentro desse componente.

Já o componente composto é uma junção de dois ou mais componentes simples para formar um único componente. Exemplo: `Card/`, card é uma pasta que possui os seguintes arquivos, `CardHeader.tsx`, `CardBody.tsx` e `index.tsx`. Nesse caso os arquivos, `CardHeader.tsx` e`CardBody.tsx` são importados no `index.tsx`,  porém, somente o `index.tsx` é importado para os outros componentes. Mantendo uma flexibilidade e legibilidade no código.

*/services* - Responsável pela instância e criação das classes que fazem a requisição para o backend.

*/types* - Responsável pelas interfaces customizadas do projeto. Usado para retornos de metódos e tipagem de variavéis.



**Obs:** A criação dos componentes devem seguir esse padrão. 

``````tsx
// Props dos componentes
interface HelloWorldProps{
    message: string
}

// Funções internas do componente como validação, realizar requisições e etc.
function helloWorldValidation(){
    return true
}

// Componente criado
export default function HelloWorld(props: HelloWorldProps){
    return <h1>{props.message}</h1>
}

``````



### Backend

*/client* -  Responsável pela a instância da biblioteca que realiza as requisições para outras apis.

*/configuration* - Responsável pela as configurações globais da aplicação. No caso atual, pela as configurações de CORS do projeto

*/service* - Responsável pelos os ações das entidades da nossa aplicação. Como consulta ou inserção de algum dado.

*/controller* - Responsável pela as chamadas das requisições, tendo um contato direto com a */service*

*/exceptions* - Responsável pela os tratamentos e criação de erros da aplicação. 

*/entity* - Responsável pela definição das características das entidades.



