package com.smart.service;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@ContextConfiguration("classpath*:/smart-context.xml")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests{
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }
    @Test
    public void testHasMatchUser() throws Exception {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "123");
        assertTrue(b1);
        assertTrue(!b2);
    }

    @Test
    public void testFindUserByUserName() throws Exception {
        User admin = userService.findUserByUserName("admin");
        assertTrue("123456".equalsIgnoreCase(admin.getCredits()+""));
    }

    @Test
    public void testLoginSuccess() throws Exception {
        User admin1 = userService.findUserByUserName("admin");
        userService.loginSuccess(admin1);
        User admin2 = userService.findUserByUserName("admin");
        int tmp = admin2.getCredits() - admin1.getCredits();
        assertTrue(tmp == 5);
    }

}