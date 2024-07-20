package io.github.idmosk.demo.saga.sagas

import io.github.idmosk.saga.api.ISaga
import io.github.idmosk.saga.api.sagas.notsuspendable.TwoStepsOkNotSuspendSagaImpl
import io.github.idmosk.saga.api.sagas.notsuspendable.TwoStepsOkRolledBackNotSuspendSagaImpl
import io.github.idmosk.saga.api.sagas.suspendable.ThreeStepsOkRolledBackSagaImpl
import io.github.idmosk.saga.api.sagas.suspendable.ThreeStepsOkSagaImpl
import io.github.idmosk.saga.api.sagas.suspendable.TwoStepsNokRolledBackSagaImpl
import io.github.idmosk.saga.api.sagas.suspendable.TwoStepsOkRolledBackSagaImpl
import io.github.idmosk.saga.api.sagas.suspendable.TwoStepsOkRolledBackWithExceptionSagaImpl
import io.github.idmosk.saga.api.sagas.suspendable.TwoStepsOkSagaImpl
import io.github.idmosk.saga.api.sagas.suspendable.TwoStepsWithBackwardExceptionSagaImpl
import io.github.idmosk.saga.api.sagas.suspendable.TwoStepsWithForwardExceptionSagaImpl
import io.github.idmosk.saga.api.sagas.withoutbackward.TwoStepsOkOnlyForwardSagaImpl
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class Sagas {
    @Bean
    fun twoStepsOkSaga(): ISaga {
        return TwoStepsOkSagaImpl()
    }

    @Bean
    fun threeStepsOkSaga(): ISaga {
        return ThreeStepsOkSagaImpl()
    }

    @Bean
    fun twoStepsOkNotSuspendSaga(): ISaga {
        return TwoStepsOkNotSuspendSagaImpl()
    }

    @Bean
    fun twoStepsOkRolledBackNotSuspendSaga(): ISaga {
        return TwoStepsOkRolledBackNotSuspendSagaImpl()
    }

    @Bean
    fun threeStepsOkRolledBackSaga(): ISaga {
        return ThreeStepsOkRolledBackSagaImpl()
    }

    @Bean
    fun twoStepsNokRolledBackSaga(): ISaga {
        return TwoStepsNokRolledBackSagaImpl()
    }

    @Bean
    fun twoStepsOkRolledBackSaga(): ISaga {
        return TwoStepsOkRolledBackSagaImpl()
    }

    @Bean
    fun twoStepsOkRolledBackWithExceptionSaga(): ISaga {
        return TwoStepsOkRolledBackWithExceptionSagaImpl()
    }

    @Bean
    fun twoStepsWithBackwardExceptionSaga(): ISaga {
        return TwoStepsWithBackwardExceptionSagaImpl()
    }

    @Bean
    fun twoStepsWithForwardExceptionSaga(): ISaga {
        return TwoStepsWithForwardExceptionSagaImpl()
    }

    @Bean
    fun twoStepsOkOnlyForwardSaga(): ISaga {
        return TwoStepsOkOnlyForwardSagaImpl()
    }
}
