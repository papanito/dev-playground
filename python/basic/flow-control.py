#!/usr/bin/python

# simple for-loop
start = 0
end   = 10
print("Simple for-loop from {} to {}".format(start, end))
for i in range(start,end):
    print(i)

# Simple while-loop
print("Simple while-loop from {} to {}".format(start, end))
i = start
while(i<=end):
    print(i)
    i+=1

# if-then-else
number = int(input("Enter a number:"))
if (number < 50):
    print("{} is lower than 50".format(number))
elif (number < 100):
    print("{} is between 49 and 100".format(number))
else:
    print("{} is bigger or equal than 100".format(number))