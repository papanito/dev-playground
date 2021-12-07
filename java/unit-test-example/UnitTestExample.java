public class UnitTestExample {
    public String doThis(int x, int y) {
        return "do this";
    }

    public String doThat(int x, int y) {
        return "do that";
    }

    public String simpleFunction(int x, int y) {
        if  (5 <= x || y < 10) {
            return doThis(x,y);
        } else {
            return doThat(x,y);
        }
    }
}

