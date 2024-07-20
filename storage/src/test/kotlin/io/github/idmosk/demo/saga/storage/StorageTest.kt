package io.github.idmosk.demo.saga.storage

import io.github.idmosk.saga.storage.SpiTest
import io.github.idmosk.saga.storage.provider.Provider

class StorageTest : SpiTest() {
    private val provider = Storage()

    override fun getProvider(): Provider {
        return provider
    }
}
