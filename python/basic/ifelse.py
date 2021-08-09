#!/usr/bin/python

import math
import os
import random
import re
import sys

if __name__ == '__main__':
    n = int(input().strip())

    isWeird = False

    # we assume number is "Not Wired"
    # the following cases change that assumption
    if (n % 2 != 0): # is odd
        isWeird = True
    elif (6 <= n <=20):
        isWeird = True

    print("Weird" if isWeird else "Not Weird")