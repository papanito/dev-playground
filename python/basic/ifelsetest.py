import unittest
import io
import sys
class TestStringMethods(unittest.TestCase):

    def setUp(self):
        self.output = io.StringIO()
        self.saved_stdout = sys.stdout
        sys.stdout = self.output

    def tearDown(self):
        self.output.close()
        sys.stdout = self.saved_stdout  
    def testYourScript(self):
        cmd = "ifelse.py"
        cmd.main()
        assert self.output.getvalue() == "My expected ouput"

if __name__ == '__main__':
    unittest.main()