package io.github.idmosk.demo.saga.queue

import io.github.idmosk.saga.queue.SpiTest
import io.github.idmosk.saga.queue.provider.Provider

class QueueTest : SpiTest() {
    private val provider = Queue()

    override fun getProvider(): Provider {
        return provider
    }
}
