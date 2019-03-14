package tutorial.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tutorial.model.Bill;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandService {

    @Autowired
    CommandService commandService;

    @Test
    public void getPriceTest(){
        assertEquals(12.0, commandService.getPriceTest(new Bill(5,2,0.2)),0);
    }


}
