package springboot.persistence;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springboot.model.StackOverflowWebsite;

@Repository
public interface StackOverflowWebsiteRepository extends MongoRepository<StackOverflowWebsite, String> {

    List<StackOverflowWebsite> findByWebsite(String website);

// BEFORE INTERFACE IT WAS CLASS
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    public List<StackOverflowWebsite> getAll() {
//        return mongoTemplate.findAll(StackOverflowWebsite.class);
//    }
}