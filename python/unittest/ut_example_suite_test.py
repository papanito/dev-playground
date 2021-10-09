import unittest
from test_ut_example import *

def suite():
    suite = unittest.TestSuite()
    suite.addTest(SimpleFunctionTest('test_dothistest'))
    suite.addTest(SimpleFunctionTest('test_dothattest'))
    return suite

if __name__ == '__main__':
    runner = unittest.TextTestRunner()
    runner.run(suite())