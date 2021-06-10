package com.example.mhwequipment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // It is configured to work with the actual database
@Rollback(false) //commit the changes
public class UserRepositoryTests {

//    @Autowired
//    private UserRepository repo;
//
//    @Autowired
//    private TestEntityManager entityManager; //It is a wrapper of JPA’s EntityManager so we can use it in test class like a standard EntityManager.

//    @Test
//    public void testCreateUser(){
//        User user = new User();
//        user.setEmail("yohoo@gmail.com");
//        user.setPassword("yamiedie2021");
//        user.setUsername("habibi");
//
//        User savedUser = repo.save(user);
//        User existUser = entityManager.find(User.class, savedUser.getId());
//
//        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
//    }

//    @Test
//    public void testFindUserByEmail(){
//        String email = "gaga@163.com";
//
//        User user = repo.findByEmail(email);
//
//        assertThat(user).isNotNull();
//
//    }
}
