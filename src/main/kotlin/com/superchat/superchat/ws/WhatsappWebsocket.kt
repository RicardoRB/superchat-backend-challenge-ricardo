package com.superchat.superchat.ws

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.client.WebSocketConnectionManager
import org.springframework.web.socket.client.standard.StandardWebSocketClient
import org.springframework.web.socket.handler.TextWebSocketHandler


/**
 * Custom component whatsapp websocket
 *
 * In order to listen whatsapp websocket this component will be created and subscribed to certain topic
 *
 * Recommended observer design pattern or pub/sub design patter after when triggered a new message
 */
@Component
class WhatsappWebsocket {

    private val url = "wss://socketsbay.com/wss/v2/2/demo/"

    init {
        val connectionManager = WebSocketConnectionManager(StandardWebSocketClient(), WhatsappWebSocketHandler(), url)
        connectionManager.start()
    }

    private class WhatsappWebSocketHandler : TextWebSocketHandler() {

        var logger: Logger = LoggerFactory.getLogger(WhatsappWebSocketHandler::class.java)

        public override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
            logger.info("Message Received [" + message.payload + "]")
        }

        @Throws(Exception::class)
        override fun afterConnectionEstablished(session: WebSocketSession) {
            logger.info("Connected")
        }

        override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
            logger.error("Transport Error", exception)
        }

        override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
            logger.info("Connection Closed [" + status.reason + "]")
        }
    }

}