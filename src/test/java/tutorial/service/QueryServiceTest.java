package tutorial.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static  org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryServiceTest {

    @Autowired
    QueryService queryService;

    @Test
    public void getHelloTest(){
        assertEquals( "Hello Pawel", queryService.getHello( "Pawel" ) );
    }
}
