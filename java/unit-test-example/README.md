## Unit test example

1. Install java and Junit
2. Register `CLASSPATH` which includes to [junit.jar](https://junit.org) and [hamcrest-core.jar](http://hamcrest.org/JavaHamcrest/)

    ```bash
    CLASSPATH=.:/usr/share/java/junit.jar:/usr/share/java/hamcrest-core.jar
    ```

3. Compile class and test class

    ```bash
    javac UnitTestExample.java UnitTestExampleTest.java
    ```

    The test class uses [Parametrized tests](https://github.com/junit-team/junit4/wiki/Parameterized-tests)

4. Now you can run the tests

    ```bash
    java org.junit.runner.JUnitCore UnitTestExampleTest
    JUnit version 4.13.2
    ............
    Time: 0.01

    OK (12 tests)
    ```