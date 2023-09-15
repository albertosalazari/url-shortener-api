# 🌐 **Url Shortener Api**

API feita em kotlin a partir do Framework Quarkus, com objetivo de realizar operações de manipulações com urls e criação de urls curtas.

## 🏗️ **Estrutura**

Esta api conta com a seguinte principal estrutura de pastas:

```
url-shortener-api/
│
├── src/
│   ├── main/
│   │   ├── docker/
│   │   │
│   │   ├── kotlin/url/shortener/
│   │   │   ├── domain/
│   │   │   ├── repository/
│   │   │   ├── services/
│   │   │   ├── utils/
│   │   │   ├── Default.ky
│   │   │   └── Shortener.ky
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── target/
│
├── pom.xml
│
└── README.md
```

### 📒 **Definições da Estrutura**

> 📁 <span style="font-size:15px"> **src/**</span> Esta pasta contém todo o código-fonte do projeto.

> 📁 <span style="font-size:15px"> **main/**</span> Aqui está o código principal da aplicação.

> 📁 <span style="font-size:15px"> **docker/**</span> Esta pasta pode conter arquivos Docker relacionados, como arquivos Dockerfile ou configurações de Docker Compose, se a aplicação estiver sendo contida em um recipiente Docker.

> 📁 <span style="font-size:15px"> **kotlin/url/shortener/**</span> O código da aplicação propriamente dita é organizado em um pacote chamado "url.shortener" escrito em Kotlin.

> 📁 <span style="font-size:15px"> **domain/**</span> Esta pasta geralmente contém as classes que representam o domínio da aplicação, como entidades e objetos de valor. No contexto de um encurtador de URL, pode conter classes que representam URLs encurtadas.

> 📁 <span style="font-size:15px"> **repository/**</span> Pode conter classes ou interfaces que definem a camada de acesso a dados, como repositórios para persistir ou recuperar informações do banco de dados.

> 📁 <span style="font-size:15px"> **services/**</span> Aqui você pode encontrar classes que implementam a lógica de negócios da aplicação. Isso pode incluir a lógica para encurtar URLs, redirecionar URLs encurtadas, etc.

> 📁 <span style="font-size:15px"> **utils/**</span> Esta pasta pode conter utilitários ou classes auxiliares que são usadas em toda a aplicação.

> 📄 <span style="font-size:15px"> **Default.kt**</span> Arquivo de rotas, contém os métodos http para a rota determinada como "default"('/').

> 📄 <span style="font-size:15px"> **Shortener.kt**</span> Arquivo de rotas, contém os métodos http para a rota determinada como "shortener"('/shortener').

> 📁 <span style="font-size:15px"> **resources/**</span> Normalmente, nesta pasta, você encontrará recursos estáticos, como arquivos de configuração, modelos de email, arquivos de propriedades, etc.

> 📄 <span style="font-size:15px"> **application.properties**</span> É um arquivo de configuração usado para definir configurações específicas do aplicativo, como configurações de banco de dados, segurança e ambiente. Ele utiliza uma sintaxe de chave-valor para especificar propriedades e seus valores e é fundamental para personalizar e ajustar o comportamento do aplicativo sem modificar o código-fonte.

> 📁 <span style="font-size:15px"> **test/**</span> Contém os testes unitários e de integração para garantir a qualidade e confiabilidade da aplicação.

> 📁 <span style="font-size:15px"> **target/**</span> Essa pasta provavelmente é gerada automaticamente pelo sistema de construção (como o Maven) e contém os artefatos compilados e empacotados da aplicação, como arquivos JAR ou WAR.

> 📄 <span style="font-size:15px"> **pom.xml**</span> O arquivo pom.xml é usado para gerenciar as dependências e configurações do projeto, principalmente se o projeto estiver sendo construído usando o Apache Maven.

> 📄 <span style="font-size:15px"> **README.md**</span> Este é o arquivo de documentação principal que descreve o projeto, sua estrutura e fornece instruções sobre como configurar, compilar e executar a aplicação. Também pode conter outras informações úteis, como como usar a API de encurtamento de URL, como contribuir para o projeto e como entrar em contato com os mantenedores.

## 💡 **Primeiros Passos**

Esta api deve ser iniciada em modo de desenvolvimento, para isso, algumas pré configurações devem ser realizadas.

Para iniciar esta api, siga as etapas abaixo!

### 🪑🎲 **Banco de Dados**

Para que seja possui armazenar e manipular dados a partir dos métodos http expostos por esta api, primeiro é necessário conectar a api em um banco de dados a sua escolha. A api não faz diferenciação de qual banco de dados será usado, portanto basta configura a conexão com a banco de dados a sua escolha.

Para isto, basta abrir o arquivo **application.properties**, localizada na pasta **resources**, e configurar os atributos do quarkus destinados ao banco de dados da aplicação, conforme exemplo:

```
quarkus.datasource.db-kind=postgresql
quarkus.datasource.username=<your username>
quarkus.datasource.password=<your password>
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/my-data-base
```

<span style="font-size:15px; color: red">**OBS:**</span> Para maiores informações, consultar documentação oficial: 🔗 https://quarkus.io/guides/datasource

### 🖥️ **Modo de Desenvolvimento**

Após configurar o banco de dados, basta executar em modo a api em modo de desenvolvimento com o comando abaixo:

```shell script
./mvnw compile quarkus:dev
```

## 🗺️ **Rotas e Cabeçalhos**

Após executar a api em modo de desenvolvimento, algumas informações devem ser levadas em consideração para que se torne possível acessar a api de um ambiente externo:

### 🌍 **Variáveis de Ambiente**

Esta api conta com as seguintes varíaveis de ambiente:

    http://localhost:8080

- <span style="font-size:15px">**http://:**</span> Isso indica o protocolo de comunicação utilizado, que é o HTTP (Hypertext Transfer Protocol). O HTTP é um protocolo amplamente utilizado para transferir dados pela web.

- <span style="font-size:15px">**localhost:**</span> É um nome especial que se refere à própria máquina em que o código está sendo executado. Quando usado em uma URL, "localhost" aponta para o servidor web em execução na máquina local. Isso significa que o aplicativo ou serviço está sendo executado na mesma máquina em que o navegador está sendo usado.

- <span style="font-size:15px">**8080:**</span> É uma porta. As portas são usadas para direcionar o tráfego de rede para aplicativos específicos em uma máquina. A porta 8080 é frequentemente usada como uma alternativa à porta padrão HTTP (porta 80) quando múltiplos serviços estão em execução na mesma máquina.

### 📮 **Endpoints**

Os endpoints e métodos HTTP disponibilizados por esta api são:

> <span style="font-size:15px; color: white">**/**</span>

    http:localhost:8080/{url curta/customizada}

- <span style="font-size:15px; color: green">**GET:**</span> É possível redirecionar a página para a url longa a qual aquela url curta/customizada é vinculada.

> <span style="font-size:15px; color: white">**/shortener**</span>

    http:localhost:8080/shortener

- <span style="font-size:15px; color: green">**GET:**</span> É possível buscar todas as urls customizadas

- <span style="font-size:15px; color: yellow">**POST:**</span> É possível criar uma nova url curta aleatoria/customizada.

<span style="font-size:15px; color: pink">**Corpo da Requisição:**</span> Para esta requisição ser efetuada, no corpo dela deve ser mandado o objeto json abaixo:

    {
        "originalUrl": "url original",
        "customUrl": ""
    }

<span style="font-size:15px; color: red">**OBS:**</span> O campo **customUrl** não é obrigatório, deve ser usado apenas quando se quer definir uma url personalizada.

<span style="font-size:15px; color: red">**OBS:**</span> Para este método, é necessário ficar atento ao cabeçalho da requisição "Content-Type", que deve ser do tipo "application/json"

- <span style="font-size:15px; color: red">**DELETE:**</span> É possível deletar uma url criada a partir de seu id.

<span style="font-size:15px; color: red">**OBS:**</span> Para esta requisição funcionar, o id da url deve ser mandado logo após o caminho da url, como exemplificado abaixo:

    http:localhost:8080/shortener/{id}
    http:localhost:8080/shortener/1 -> deleta a url de id 1
