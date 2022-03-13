## SUPERCHAT BACKEND

## Getting Started

1. Execute "docker-compose up" in order to launch postgres
2. Execute ./gradlew clean build
3. Execute ./gradlew bootRun to launch the server

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

## Notes

- This project doesn't have any JWT implementation, some codes are assigned to FIXME when the current customer may be
  needed
- The project is designed to handle different providers in a flexible way but just an example for whatsapp is created
- There is integration test and unit tests, but it doesn't cover the entire code. You can play around without the need
  to run the project
- The project's configuration has create-drop database, it means that will create the tables thanks to spring-data
  automatically everytime the server starts and also will destroy the tables and rows when it stops
