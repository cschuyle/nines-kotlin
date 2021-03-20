# The Nine Nines problem, a solution in Kotlin

Here is one reference to the problem: <https://arstechnica.com/civis/viewtopic.php?f=20&t=871719>

I decided to use this is a Kotlin kata. I thought it'd exercise a few things in particular:
- tail recursion
- function references
- experiment with performance testing of Rational implementation

The first implementation I'm assuming will be a brute-force, generate all the solutions, use dynamic programming to combine partials, then find the answer.

