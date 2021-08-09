# if-else

Source: [Hackerranks](https://www.hackerrank.com/challenges/py-if-else/problem)
Code: [if-else.py](./if-else.py)

## Task

Given an integer, $n$, perform the following conditional actions:

- If $n$ is odd, print `Weird`
- If $n$ is even and in the inclusive range of $2$ to $5$, print `Not Weird`
- If $n$ is even and in the inclusive range of $6$ to $20$, print `Weird`
- If $n$ is even and greater than $20$, print `Not Weird`

## Input Format

A single line containing a positive integer, $n$.

## Constraints

## Output Format

Print `Weird` if the number is weird. Otherwise, print Not Weird.

## Explanation

**Explanation 0**

$n$ is odd and odd numbers are weird, so print `Weird`.

**Sample Input 1**

```python
24
```

**Sample Output 1**

```python
Not Weird
```

**Explanation 1**

$n = 24$ 
$n >= 20$ and is $n$ even, so it is not weird.
