package springboot.web;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import springboot.model.StackOverflowWebsite;
import springboot.service.StackOverflowService;

@RunWith(MockitoJUnitRunner.class)
public class StackOverflowControllerTest {

    @Mock
    private StackOverflowService stackOverflowService;
    @InjectMocks
    private StackOverflowController systemUnderTesting;

    @Test
    public void testGetListOfProviders() throws Exception {
        // prepare
        when(stackOverflowService.findAll()).thenReturn(ImmutableList.of());
        // testing
        List<StackOverflowWebsite> listOfProviders = systemUnderTesting.getListOfProviders();
        // validate
        verify(stackOverflowService).findAll(); // checking was method called
    }
}