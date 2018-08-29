package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.yang.test.ApplicationDemo;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@WebAppConfiguration
@SpringBootTest
public class JdbcTest {
 
    @Resource(name="oneJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;
    @Resource(name="twoJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;
 
    @Test
    public void test() throws Exception {
        jdbcTemplate1.update("insert into t_author(id, real_name, nick_name) values(?, ?, ?)", 2, "梁桂钊", "LiangGzone");
        jdbcTemplate2.update("insert into t_author(id, real_name, nick_name) values(?, ?, ?)", 2, "梁桂钊", "LiangGzone");
    }
}
