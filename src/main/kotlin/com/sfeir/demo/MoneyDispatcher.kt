package com.sfeir.demo

class MoneyDispatcher {

    fun dispatch(amount: Int, numberOfGuests: Int): Int {
        val quotient = amount / 8
        val remainder = amount % 8
        val leftoverGuests = numberOfGuests - quotient
        return when {
            numberOfGuests == 1 && amount == 8 -> 1
            (numberOfGuests > 1) -> {
                when {
                    (quotient > numberOfGuests) -> numberOfGuests - 1
                    (remainder == 4) || (remainder == 0 && quotient < numberOfGuests) -> numberOfGuests - 2
                    (remainder == 0) || ((remainder >= leftoverGuests) && leftoverGuests > 0) -> quotient
                    else -> maxOf(0, quotient - 1)
                }
            }
            else -> 0
        }
    }
}
