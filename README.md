## SUPERCHAT BACKEND

## Getting Started

1. Execute "docker-compose up" in order to launch postgres
2. Execute ./gradlew clean build
3. Execute ./gradlew bootRun to launch the server

## Create docker image

1. Execute "docker build ."

## Tasks

- Create contacts given their personal information (Name, E-Mail, etc)
    - Check [ContactController.kt] for more information
    - Use POST /api/v1/contacts in order to create a new contact
- List all contacts
    - Check [ContactController.kt] for more information
    - Use GET /api/v1/contacts in order to retrieve a list of contacts
- Send a message to a contact
    - Check [ConversationWSController.kt] for more information
    - The documentation didn't specify if it must be by REST Api or WS
    - My assumption is that should be by WS and also send the message information to a respective provider
    - In order to retrieve and send information must be connected to the ws://localhost:8080 with the topic
      /topic/conversations/{conversationUUID}
- List all previous conversations
    - Check [ConversationController.kt] form more information
    - Use GET /api/v1/conversations in order to retrieve a list of conversations
- Receive messages from an external service via a webhook
    - Check [WhatsappWebsocket.kt] to see an example
- When they send out a message that contains placeholders, our backend substitutes them with the required value.
    - Check [PlaceholderFormatter.kt], this is a flexible placeholder formatter
    - The prefixed used are {{ and suffix }}
    - Example {{bitcoinPrice}}
    - It can be configured with extra placeholders or provide then as parameters

## Database

- create table contacts (id bigint not null, created_at timestamp, updated_at timestamp, email varchar(255), name
  varchar(255), uuid binary(255), primary key (id))
- create table contacts_conversations (contacts_id bigint not null, conversations_id bigint not null)
- create table conversations (id bigint not null, created_at timestamp, updated_at timestamp, external_id varchar(255),
  platform integer, uuid binary(255), primary key (id))
- create table messages (id bigint not null, created_at timestamp, updated_at timestamp, data varchar(255), uuid binary(
  255), primary key (id))
- create table messages_conversations (messages_id bigint not null, conversations_id bigint not null)

## Notes

- The project is a monolithic created with a CRUD architecture in order to provide a simple project. I would recommend a
  different architecture (as CQRS/Event Source) for a microservice architecture
- This project doesn't have any JWT implementation, some codes are assigned to FIXME when the current customer may be
  needed
- The project is designed to handle different providers in a flexible way but just an example for
  whatsapp [WhatsappDelegate.kt], but it can be created another custom [ProviderConversation.kt] (SMS, email,
  Telegram,...)
- There is integration test and unit tests, but it doesn't cover the entire code. You can play around without the need
  to run the project
- The project's configuration has create-drop database, it means that will create the tables thanks to spring-data
  automatically everytime the server starts and also will destroy the tables and rows when it stops
