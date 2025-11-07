package com.nnk.springboot;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void userCrudTest() {
        User user = new User();
        user.setUsername("john");
        user.setPassword("Password123!");
        user.setFullname("John Doe");
        user.setRole("USER");

        // Save
        user = userRepository.save(user);
        Assert.assertNotNull(user.getId());
        Assert.assertEquals("john", user.getUsername());

        // Update
        user.setFullname("John Updated");
        user = userRepository.save(user);
        Assert.assertEquals("John Updated", user.getFullname());

        // Delete
        Integer id = user.getId();
        userRepository.delete(user);
        Optional<User> deleted = userRepository.findById(id);
        Assert.assertFalse(deleted.isPresent());
    }
}
