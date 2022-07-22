package me.jmvsta.service

import me.jmvsta.data.ChatObject

interface SocketIOService {

    @Throws(Exception::class) fun start()

    fun stop()

    fun pushMessageToUser(pushMessage: ChatObject)

    companion object {
        const val PUSH_EVENT = "chatevent"
    }
}