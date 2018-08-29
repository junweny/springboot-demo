package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.yang.test.server.MsgServer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@WebAppConfiguration
@SpringBootTest
public class AsyncTest {
 
    @Autowired
    private MsgServer msgServer;
 
    @Test
    public void test() throws Exception {
        msgServer.sendA();
        msgServer.sendB();
    }
}