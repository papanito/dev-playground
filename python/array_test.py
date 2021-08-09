# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")
def solution(A):
    # write your code in Python 3.6
    maxcount = 0

    for i in range(0,len(A)-1):
        currentArrayPos = i
        count = 0
        while currentArrayPos >= 0:
            count = count+1
            currentArrayPos = findNextPair(A, A[i]+A[i+1], currentArrayPos+2)
        if count > maxcount:
            maxcount = count
    return maxcount

## find the next pair with equal sum
def findNextPair(A, sum, start):
    for j in range(start,len(A)-1):
        if sum == A[j]+A[j+1]:
            return j
    return -1


print(solution([5,3,1,3,2,3]))
print(solution([10,1,3,1,2,2,1,0,4]))
print(solution([9,9,9,9,9]))
print(solution([1,5,2,4,3,3]))
print(solution([1,4,4,1,3,2,2,3,1,4,2,3]))