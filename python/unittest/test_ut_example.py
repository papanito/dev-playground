from ut_example import *
import unittest

class SimpleFunctionTest(unittest.TestCase):
    def test_dothistest(self):
        self.assertAlmostEqual(simpleFunction(5,10), 'do this')
        self.assertAlmostEqual(simpleFunction(5,9), 'do this')
    def test_dothattest(self):
        self.assertAlmostEqual(simpleFunction(1,10), 'do that')
        self.assertAlmostEqual(simpleFunction(4,10), 'do that')

if __name__ == '__main__':
    unittest.main()