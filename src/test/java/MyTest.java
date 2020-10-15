import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyTest {
    @Test
    public void TestSolution (){
        String expression = "(2+(5*6)-12)/5";
        MyParser myParser = new MyParser(expression);
        double check = 4.0;
        double check1 = myParser.foundSolve();
        assertEquals(check1, check, 0.0);
    }
}
