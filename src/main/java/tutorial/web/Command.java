package tutorial.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tutorial.exception.MaximumQuantityExceededException;
import tutorial.model.Bill;
import tutorial.service.CommandService;

@Api
@RestController
@RequestMapping("/myapi")
@Slf4j
public class Command {

    @Autowired
    CommandService commandService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Double.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiOperation(value = "Calculate price", notes = "Send your bill, get the price")
    @PostMapping(path = "/price", consumes = "application/json")
    public double calculatePrice(@RequestBody Bill request) throws MaximumQuantityExceededException {
        log.info( "[Command] Received new calculatePrice request. Request body: {}", request );
        return commandService.getPrice(request);
    }
}
