package com.lugew.winsim.example.controller;

import com.lugew.winsim.controller.AbstractController;
import com.lugew.winsim.example.entity.User;
import com.lugew.winsim.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LuGew
 * @since 2020/7/29
 */
@RestController
@RequestMapping("user")
public class UserController extends AbstractController<User, UserService> {
    @PostMapping("test")
    public ResponseEntity<?> test(@RequestBody User entity) {
        service.updateNotNull(entity);
        return ok();
    }
}
