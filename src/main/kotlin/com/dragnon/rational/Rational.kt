package com.dragnon.rational

class Rational(num: Int, den: Int) {

    val num: Int
    val den: Int

    init {
        var num = num
        var den = den

        require(den != 0, { "Division by 0 error" })

        if (num == 0) {
            this.num = 0
            this.den = 1
        } else {
            val lcm = lcm(positive(num), positive(den))
            if (isPositive(num).xor(isPositive(den))) {
                num = positive(num)
                den = -positive(den)
            }
            this.num = lcm / den
            this.den = lcm / num
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rational

        if (num != other.num) return false
        if (den != other.den) return false

        return true
    }

    override fun hashCode(): Int {
        var result = num
        result = 31 * result + den
        return result
    }

    override fun toString() = if (den == 1) "$num" else "$num/$den"
}


fun add(left: Rational, right: Rational): Rational {
    val gcd = gcd(positive(left.den), positive(right.den))
    val commonDen = left.den * right.den / gcd
    return Rational(left.num * (commonDen / left.den) + right.num * (commonDen / right.den), commonDen)
}

infix fun Rational.plus(right: Rational) = add(this, right)

fun subtract(left: Rational, right: Rational): Rational {
    val gcd = gcd(positive(left.den), positive(right.den))
    val commonDen = left.den * right.den / gcd
    return Rational(left.num * (commonDen / left.den) - right.num * (commonDen / right.den), commonDen)
}

infix fun Rational.minus(right: Rational) = subtract(this, right)

fun multiply(left: Rational, right: Rational): Rational {
    return Rational(left.num * right.num, left.den * right.den)
}

infix fun Rational.times(right: Rational) = multiply(this, right)

fun divide(left: Rational, right: Rational): Rational {
    return multiply(left, Rational(right.den, right.num))
}

infix fun Rational.dividedBy(right: Rational) = divide(this, right)


private fun isPositive(i: Int) = i > 0

private fun positive(i: Int) = if (isPositive(i)) i else -i

private fun lcm(a: Int, b: Int) = if (a == 0 || b == 0) 0 else a * b / gcd(a, b)

//private fun gcd(a: Int, b: Int): Int {
//    var a = a
//    var b = b
//    require(!(a < 1 || b < 1)) { "a or b is less than 1" }
//    var remainder = 0
//    do {
//        remainder = a % b
//        a = b
//        b = remainder
//    } while (b != 0)
//    return a
//}

private tailrec fun gcd(a: Int, b: Int): Int {
    require(a >= 0 && b >= 0) { "a and b must both be non-negative" }
    return if (a == 0)
        b
    else gcd(b % a, a)
}
