package taudemo;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WithAssertionsTest {

    @Test
    public void firstAssertion(){
        assertEquals(2, 2);

    }

    @Test
    public void secondAssertion(){
        assertEquals(45,45);
    }
}
