package tutorial.web;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tutorial.service.LeapYearService;

@RestController
@RequestMapping("/myapi")
@Slf4j
public class LeapYear {

    @Autowired
    LeapYearService leapYearService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Double.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ApiOperation( value = "Get year", notes = "Check if year is leaping")
    @GetMapping(path = "/leapyear/{year}")
    public boolean getLeapYear(@PathVariable("year") Integer year){
        log.info( "[LeapYear] Received new calculateLeapYear request. Given year: {}", year);
        return (boolean) leapYearService.calculateLeapYear(year);
    }


}
