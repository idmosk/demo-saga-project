package io.github.idmosk.demo.saga.handler

import io.github.idmosk.demo.saga.performer.SagaPerformer
import io.github.idmosk.saga.api.creator.NewSaga
import io.github.idmosk.saga.api.sagas.notsuspendable.TwoStepsOkNotSuspendSaga
import io.github.idmosk.saga.api.sagas.notsuspendable.TwoStepsOkRolledBackNotSuspendSaga
import io.github.idmosk.saga.api.sagas.suspendable.ThreeStepsOkRolledBackSaga
import io.github.idmosk.saga.api.sagas.suspendable.ThreeStepsOkSaga
import io.github.idmosk.saga.api.sagas.suspendable.TwoStepsNokRolledBackSaga
import io.github.idmosk.saga.api.sagas.suspendable.TwoStepsOkRolledBackSaga
import io.github.idmosk.saga.api.sagas.suspendable.TwoStepsOkRolledBackWithExceptionSaga
import io.github.idmosk.saga.api.sagas.suspendable.TwoStepsOkSaga
import io.github.idmosk.saga.api.sagas.suspendable.TwoStepsWithBackwardExceptionSaga
import io.github.idmosk.saga.api.sagas.suspendable.TwoStepsWithForwardExceptionSaga
import io.github.idmosk.saga.api.sagas.withoutbackward.TwoStepsOkOnlyForwardSaga
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse
import java.time.Period
import java.util.UUID

@Component
class Handler {
    companion object {
        private val ACCEPT_JSON = RequestPredicates.accept(MediaType.APPLICATION_JSON)
    }

    @Bean
    fun twoStepsOkSagaHandler(sagaPerformer: SagaPerformer): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.POST("/twoStepsOkSaga").and(ACCEPT_JSON)) {
            sagaPerformer.perform(
                NewSaga
                    .Builder(UUID.randomUUID().toString(), TwoStepsOkSaga::class)
                    .addStep("forward1", "backward1")
                    .addStep("forward2", "backward2")
                    .build(),
            )
        }
    }

    @Bean
    fun threeStepsOkSagaHandler(sagaPerformer: SagaPerformer): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.POST("/threeStepsOkSaga").and(ACCEPT_JSON)) {
            sagaPerformer.perform(
                NewSaga
                    .Builder(UUID.randomUUID().toString(), ThreeStepsOkSaga::class)
                    .addStep("forward1", "backward1")
                    .addStep("forward2", "backward2")
                    .addStep("forward3", "backward3")
                    .build(),
            )
        }
    }

    @Bean
    fun twoStepsOkNotSuspendSagaHandler(sagaPerformer: SagaPerformer): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.POST("/twoStepsOkNotSuspendSaga").and(ACCEPT_JSON)) {
            sagaPerformer.perform(
                NewSaga
                    .Builder(UUID.randomUUID().toString(), TwoStepsOkNotSuspendSaga::class)
                    .addStep("forward1", "backward1")
                    .addStep("forward2", "backward2")
                    .build(),
            )
        }
    }

    @Bean
    fun twoStepsOkRolledBackNotSuspendSagaHandler(sagaPerformer: SagaPerformer): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.POST("/twoStepsOkRolledBackNotSuspendSaga").and(ACCEPT_JSON)) {
            sagaPerformer.perform(
                NewSaga
                    .Builder(UUID.randomUUID().toString(), TwoStepsOkRolledBackNotSuspendSaga::class)
                    .addStep("forward1", "backward1")
                    .addStep("forward2", "backward2")
                    .build(),
            )
        }
    }

    @Bean
    fun threeStepsOkRolledBackSagaHandler(sagaPerformer: SagaPerformer): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.POST("/threeStepsOkRolledBackSaga").and(ACCEPT_JSON)) {
            sagaPerformer.perform(
                NewSaga
                    .Builder(UUID.randomUUID().toString(), ThreeStepsOkRolledBackSaga::class)
                    .addStep("forward1", "backward1")
                    .addStep("forward2", "backward2")
                    .addStep("forward3", "backward3")
                    .build(),
            )
        }
    }

    @Bean
    fun twoStepsNokRolledBackSagaHandler(sagaPerformer: SagaPerformer): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.POST("/twoStepsNokRolledBackSaga").and(ACCEPT_JSON)) {
            sagaPerformer.perform(
                NewSaga
                    .Builder(UUID.randomUUID().toString(), TwoStepsNokRolledBackSaga::class)
                    .addStep("forward1", "backward1")
                    .addStep("forward2", "backward2")
                    .retries(1)
                    .retriesTimeout(Period.ZERO)
                    .build(),
            )
        }
    }

    @Bean
    fun twoStepsOkRolledBackSagaHandler(sagaPerformer: SagaPerformer): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.POST("/twoStepsOkRolledBackSaga").and(ACCEPT_JSON)) {
            sagaPerformer.perform(
                NewSaga
                    .Builder(UUID.randomUUID().toString(), TwoStepsOkRolledBackSaga::class)
                    .addStep("forward1", "backward1")
                    .addStep("forward2", "backward2")
                    .build(),
            )
        }
    }

    @Bean
    fun twoStepsOkRolledBackWithExceptionSagaHandler(sagaPerformer: SagaPerformer): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.POST("/twoStepsOkRolledBackWithExceptionSaga").and(ACCEPT_JSON)) {
            sagaPerformer.perform(
                NewSaga
                    .Builder(UUID.randomUUID().toString(), TwoStepsOkRolledBackWithExceptionSaga::class)
                    .addStep("forward1", "backward1")
                    .addStep("forward2", "backward2")
                    .retries(1)
                    .retriesTimeout(Period.ZERO)
                    .build(),
            )
        }
    }

    @Bean
    fun twoStepsWithBackwardExceptionSagaHandler(sagaPerformer: SagaPerformer): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.POST("/twoStepsWithBackwardExceptionSaga").and(ACCEPT_JSON)) {
            sagaPerformer.perform(
                NewSaga
                    .Builder(UUID.randomUUID().toString(), TwoStepsWithBackwardExceptionSaga::class)
                    .addStep("forward1", "backward1")
                    .addStep("forward2", "backward2")
                    .retries(1)
                    .retriesTimeout(Period.ZERO)
                    .build(),
            )
        }
    }

    @Bean
    fun twoStepsWithForwardExceptionSagaHandler(sagaPerformer: SagaPerformer): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.POST("/twoStepsWithForwardExceptionSaga").and(ACCEPT_JSON)) {
            sagaPerformer.perform(
                NewSaga
                    .Builder(UUID.randomUUID().toString(), TwoStepsWithForwardExceptionSaga::class)
                    .addStep("forward1", "backward1")
                    .addStep("forward2", "backward2")
                    .retries(1)
                    .retriesTimeout(Period.ZERO)
                    .build(),
            )
        }
    }

    @Bean
    fun twoStepsOkOnlyForwardSagaHandler(sagaPerformer: SagaPerformer): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.POST("/twoStepsOkOnlyForwardSaga").and(ACCEPT_JSON)) {
            sagaPerformer.perform(
                NewSaga
                    .Builder(UUID.randomUUID().toString(), TwoStepsOkOnlyForwardSaga::class)
                    .addStep("forward1", null)
                    .addStep("forward2", null)
                    .build(),
            )
        }
    }
}
