package tutorial.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tutorial.model.Bill;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CommandTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void calculatePriceTest() throws Exception {
        Bill bill = new Bill (5, 2, 0.2);
        String expectedPrice = "12.0";
        ObjectMapper mapper = new ObjectMapper(  );
        String billJson = mapper.writeValueAsString( bill );
        mvc.perform( MockMvcRequestBuilders.post( "/myapi/price" )
        .contentType( MediaType.APPLICATION_JSON )
        .content( billJson )
        .accept( MediaType.APPLICATION_JSON ) )
                .andExpect(status().isOk())
                .andExpect(content().string( expectedPrice ));

    }
}
