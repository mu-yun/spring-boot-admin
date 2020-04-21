package com.muyun.springboot.controller;

import com.muyun.springboot.entity.User;
import com.muyun.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muyun
 * @date 2020/4/14
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public User get(@PathVariable("id") User user) {
        return user;
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}