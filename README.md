# [Double Password](https://open.kattis.com/problems/doublepassword)

A computer at ICPC headquarters is protected by a four-digit password—in order to log in, you normally need to guess the four digits exactly. However, the programmer who implemented the password check left a backdoor in the computer—there is a second four-digit password. If the programmer enters a four-digit sequence, and for each digit position the digit entered matches at least one of the two passwords in that same position, then that four-digit sequence will log the programmer into the computer.

Given the two passwords, count the number of distinct four-digit sequences that can be entered to log into the computer.

## Input

The input consists of exactly two lines. Each of the two lines contains a string s(|s| = 4, 0 < s < 9). These are the two passwords.

## Output

Output a single integer, which is the number of distinct four-digit sequences that will log the programmer into the system.
