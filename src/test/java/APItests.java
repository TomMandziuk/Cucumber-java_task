import groovy.transform.ASTTest;
import org.junit.Assert;
import org.junit.Test;



public class APItests {

    String URL = "http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

    @Test
    public void firstTest(){
        FirstAPIClass.getResponseBody();
    }

    @Test
    public void secondTest(){
        Assert.assertEquals(FirstAPIClass.getResponseStatus(), 200);
    }
}
