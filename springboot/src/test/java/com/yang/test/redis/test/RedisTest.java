package com.yang.test.redis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yang.test.redis.dao.ValueRedisDao;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
 
    @Autowired
    private ValueRedisDao valueRedisDao;
 
    @Test
    public void test() throws Exception {
    this.valueRedisDao.save("yang");
    System.out.println(this.valueRedisDao.getParam());
    }
}
