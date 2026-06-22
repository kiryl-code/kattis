# [Cookie Monster Concussion](https://open.kattis.com/problems/cookiemonsterconcussion)

Oh no! Cookie Monster got a concussion after hitting his head on his desk (he couldn’t wrap his head around a bug while coding). He is currently in bed recovering, but he is starting to feel hungry and wants some cookies. However, he gets indigestion when he eats an amount of cookies that is not a multiple of 9. Due to his concussion, he temporarily forgot how to divide by 9. Luckily, he remembers a cool algorithm to determine if a number is a multiple of 9.

The algorithm is to sum the digits of the number in question, and checking if the sum is 9. If the number is greater than or equal to 19, then repeat the process on the sum. If and only if the sum of the digits is 9, then the number is a multiple of 9. Here are a few examples of the algorithm with multiples of 9.

81 -> 8 + 1 = 9
117 -> 1 + 1 + 7 = 9
1251 -> 1 + 2 + 5 + 1 = 9
99 -> 9 + 9 = 18 -> 1 + 8 = 9

The following are not multiples of 9.

51 -> 5 +1 = 6
219 -> 2 + 1 + 9 = 12 -> 1 + 2 = 3
2714 -> 2 + 3 + 1 + 4 = 14 -> 1 + 4 = 5

Given the number of cookies Cookie Monster wants to eat, your task is to determine if Cookie Monster should eat that many cookies.

## Input

The first and only line of input will contain a single integer 1 <= C <= 10^18 representing the number of cookies that Cookie Monster wants to eat.

## Output

Print the single-digit integer that Cookie Monster’s algorithm outputs for the given number.