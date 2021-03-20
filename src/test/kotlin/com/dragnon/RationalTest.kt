package com.dragnon

import com.dragnon.rational.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class RationalTest {
    @Test
    fun simplification() {
        assertEquals("2/3", Rational(4, 6).toString())
        assertEquals(Rational(2, 3), Rational(4, 6))

        assertEquals("1/3", Rational(1, 3).toString())
        assertEquals(Rational(1, 3), Rational(5, 15))

        assertEquals("2", Rational(6, 3).toString())
        assertEquals("0", Rational(0, 55).toString())
    }

    @Test
    fun negatives() {
        assertEquals("-1/2", Rational(1, -2).toString())
        assertEquals(Rational(-1, 2), Rational(1, -2))
    }

    @Test
    fun `addition that doesn't require simplification`() {
        assertEquals(
            Rational(2, 3),
            plus(Rational(1, 3), Rational(1, 3))
        )
    }

    @Test
    fun `addition that requires simplification`() {
        assertEquals(
            Rational(1, 2),
            plus(Rational(1, 3), Rational(1, 6))
        )
    }

    @Test
    fun `addition of negatives`() {
        assertEquals(
            Rational(1, 6),
            plus(Rational(-1, 3), Rational(1, 2)),
        )
    }

    @Test
    fun subtraction() {
        assertEquals(
            Rational(-1, 6),
            minus(Rational(1, 3), Rational(1, 2))
        )
    }

    @Test
    fun multiplication() {
        assertEquals(
            Rational(1, 3),
            times(Rational(2, 3), Rational(1, 2))
        )
    }

    @Test
    fun division() {
        assertEquals(
            Rational(4, 3),
            dividedBy(Rational(2, 3), Rational(1, 2))
        )
    }

    @Test
    fun divisionByZero() {
        assertThrows<IllegalArgumentException>( "Division by 0 error") {
            dividedBy(Rational(1, 1), Rational(0, 2))
        }
        assertEquals(
            Rational(0, 1),
            dividedBy(Rational(0, 1), Rational(1, 2))
        )
    }
}
