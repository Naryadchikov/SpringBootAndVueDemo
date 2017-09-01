package springboot.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.model.StackOverflowWebsite;
import springboot.service.StackOverflowService;

@RestController
@RequestMapping("/api/stackOverflow")
public class StackOverflowController {

    @Autowired
    private StackOverflowService stackOverflowService;

    @RequestMapping
    public List<StackOverflowWebsite> getListOfProviders() {
        return stackOverflowService.findAll();
    }
}