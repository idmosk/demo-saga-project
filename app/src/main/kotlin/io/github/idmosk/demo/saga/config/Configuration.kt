package io.github.idmosk.demo.saga.config

import io.github.idmosk.demo.saga.queue.Queue
import io.github.idmosk.demo.saga.storage.Storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import io.github.idmosk.saga.queue.provider.Provider as QueueProvider
import io.github.idmosk.saga.storage.provider.Provider as StorageProvider

@Configuration(proxyBeanMethods = false)
class Configuration {
    private val applicationCoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    @Bean
    fun applicationScope(): CoroutineScope = applicationCoroutineScope

    @Bean
    fun storageProvider(): StorageProvider {
        return Storage()
    }

    @Bean
    fun queueProvider(): QueueProvider {
        return Queue()
    }
}
