package tutorial.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import tutorial.service.QueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapi")
public class Query {

    @Autowired
    QueryService queryService;

    @GetMapping(path = "/hello/{name}")
    public String getHello(@PathVariable("name") String name) {

        return queryService.getHello(name);
    }
}
