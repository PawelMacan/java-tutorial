package tutorial.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tutorial.exception.MaximumQuantityExceededException;
import tutorial.model.Bill;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandServiceTest {

    @Autowired
    CommandService commandService;

    @Test
    public void getPriceNormalTest(){
        assertEquals(4.8,commandService.getPrice(new Bill(2, 2, 0.2)), 0);
    }

    @Test(expected = MaximumQuantityExceededException.class)
    public void getPriceTest() throws MaximumQuantityExceededException {
        commandService.getPrice(new Bill(15, 2, 0.2));

    }

}
