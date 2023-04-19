package com.sfeir.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MoneyDispatcherTest {

    @ParameterizedTest
    @MethodSource("moneyDispatchValues")
    fun `money dispatch should return values`(amount: Int, numberOfGuests: Int, expected8s: Int) {
        // Given / When
        val actual = MoneyDispatcher().dispatch(amount, numberOfGuests)

        // Then
        assertThat(actual).isEqualTo(expected8s)
    }


    private fun moneyDispatchValues(): Stream<Arguments> {
        return Stream.of(
            Arguments.of( 0, 0, 0),
            Arguments.of(10, 0, 0),
            Arguments.of(6, 4, 0),
            Arguments.of(-2, 4, 0),
            Arguments.of(8, 1, 1),
            Arguments.of(3, 1, 0),
            Arguments.of(12, 1, 0),
            Arguments.of(12, 2, 0),
            Arguments.of(16, 2, 2),
            Arguments.of(20, 3, 1),
            Arguments.of(25, 3, 2),
            Arguments.of(40, 3, 2),
            Arguments.of(64, 8, 8),
            Arguments.of(24, 4, 2),
            Arguments.of(7, 2, 0),
            Arguments.of(65, 10, 7),
            Arguments.of(66, 10, 8),
        )
    }
}