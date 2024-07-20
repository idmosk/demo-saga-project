package io.github.idmosk.demo.saga.performer

import io.github.idmosk.saga.api.creator.Creator
import io.github.idmosk.saga.api.creator.NewSaga
import kotlinx.coroutines.reactor.mono
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class SagaPerformer(
    private val creator: Creator,
) {
    fun perform(newSaga: NewSaga): Mono<ServerResponse> {
        return mono {
            creator
                .create(newSaga)
                .listen(this, newSaga.businessId)
                .start()
                .await()
        }.toFuture().get()?.let {
            ServerResponse.ok().bodyValue(it)
        } ?: run {
            ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }
}
