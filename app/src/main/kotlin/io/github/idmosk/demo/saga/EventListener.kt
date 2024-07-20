package io.github.idmosk.demo.saga

import io.github.idmosk.saga.api.repeater.Repeater
import io.github.idmosk.saga.api.router.Router
import io.github.idmosk.saga.api.runner.Runner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.reactor.mono
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class EventListener(
    private val applicationScope: CoroutineScope,
    private val router: Router,
    private val runner: Runner,
    private val repeater: Repeater,
) {
    @EventListener(classes = [ContextRefreshedEvent::class])
    fun start() {
        router.start(applicationScope)
        runner.start(applicationScope)
        repeater.start(applicationScope)
    }

    @EventListener(classes = [ContextClosedEvent::class])
    fun stop() =
        mono {
            router.stop()
            runner.stop()
            repeater.stop()
        }.block()
}
