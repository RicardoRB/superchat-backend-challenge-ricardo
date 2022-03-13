package com.superchat.superchat.conversation.controller.ws

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.messaging.converter.StringMessageConverter
import org.springframework.messaging.simp.stomp.StompFrameHandler
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter
import org.springframework.web.socket.client.standard.StandardWebSocketClient
import org.springframework.web.socket.messaging.WebSocketStompClient
import org.springframework.web.socket.sockjs.client.SockJsClient
import org.springframework.web.socket.sockjs.client.WebSocketTransport
import java.lang.reflect.Type
import java.util.*
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue
import java.util.concurrent.TimeUnit


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConversationWSControllerTest {


    @LocalServerPort
    private var port: Int = 0

    private lateinit var webSocketStompClient: WebSocketStompClient

    @BeforeEach
    fun setup() {
        this.webSocketStompClient = WebSocketStompClient(
            SockJsClient(
                listOf(WebSocketTransport(StandardWebSocketClient()))
            )
        )
    }

    @Test
    fun `GIVEN a message WHEN sending to a conversation THEN receive the message`() {
        val url = String.format("ws://localhost:%d/ws", port)
        val blockingQueue: BlockingQueue<Any> = ArrayBlockingQueue(3)
        val conversationUUID = UUID.randomUUID()

        webSocketStompClient.messageConverter = StringMessageConverter()

        val session = webSocketStompClient
            .connect(url, object : StompSessionHandlerAdapter() {})
            .get(1, TimeUnit.SECONDS)

        session.subscribe("/topic/conversations/$conversationUUID", object : StompFrameHandler {
            override fun getPayloadType(headers: StompHeaders): Type {
                return String::class.java
            }

            override fun handleFrame(headers: StompHeaders, payload: Any?) {
                if (payload != null) {
                    println(payload)
                    blockingQueue.add(payload)
                }
            }
        })

        session.send("/app/conversations/$conversationUUID/messages", "Hi, how are you doing?")
        Thread.sleep(200)
        session.send("/app/conversations/$conversationUUID/messages", "Good, and you?")
        Thread.sleep(200)
        session.send("/app/conversations/$conversationUUID/messages", "I'm doing good")
        Thread.sleep(200)
        Assertions.assertEquals("Hi, how are you doing?", blockingQueue.poll(1, TimeUnit.SECONDS))
        Assertions.assertEquals("Good, and you?", blockingQueue.poll(1, TimeUnit.SECONDS))
        Assertions.assertEquals("I'm doing good", blockingQueue.poll(1, TimeUnit.SECONDS))
    }

}