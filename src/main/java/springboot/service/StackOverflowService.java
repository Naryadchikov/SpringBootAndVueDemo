package springboot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.model.StackOverflowWebsite;
import springboot.persistence.StackOverflowWebsiteRepository;

@Service
public class StackOverflowService {

    @Autowired
    private StackOverflowWebsiteRepository repository;

//    private static List<StackOverflowWebsite> items = new ArrayList<>();
//
//    static {
//        items.add(new StackOverflowWebsite("http://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico",
//            "stackoverflow", "http://stackoverflow.com", "StackOverflow (StackExchange)", "hehe"));
//        items.add(new StackOverflowWebsite("http://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico",
//            "stackoverflow", "http://stackoverflow.com", "StackOverflow (StackExchange)", "hehe"));
//        items.add(new StackOverflowWebsite("http://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico",
//            "stackoverflow", "http://stackoverflow.com", "StackOverflow (StackExchange)", "hehe"));
//    }
//
//    @PostConstruct
//    public void init() {
//        repository.save(items);
//    }

    public List<StackOverflowWebsite> findAll() {
        //return items;
        return repository.findAll();
    }
}