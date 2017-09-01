package springboot.web;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springboot.model.StackOverflowWebsite;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment= WebEnvironment.DEFINED_PORT)
public class StackOverflowControllerIT {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void before() {
        mongoTemplate.dropCollection(StackOverflowWebsite.class);
        mongoTemplate.save(new StackOverflowWebsite("website1", "icon", "website", "title", "description"));
        mongoTemplate.save(new StackOverflowWebsite("website2", "icon", "website", "title", "description"));
    }

    @Test
    public void testGetListOfProviders() throws Exception {
        // test
        ResponseEntity<List<StackOverflowWebsite>> responseEntity =
            restTemplate.exchange("http://localhost:8090/api/stackOverflow", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<StackOverflowWebsite>>() {
                });
        List<StackOverflowWebsite> actualList = responseEntity.getBody();

        // validate
        assertThat(actualList.size(), is(2));

        List<String> actualIds = actualList.stream()
            .map(stackOverflowWebsite -> stackOverflowWebsite.getId())
            .collect(collectingAndThen(toList(), ImmutableList::copyOf));

        assertThat(actualIds, containsInAnyOrder("website1", "website2"));
    }
}