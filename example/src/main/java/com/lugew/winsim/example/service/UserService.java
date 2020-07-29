package com.lugew.winsim.example.service;

import com.lugew.winsim.example.entity.User;
import com.lugew.winsim.example.mapper.UserMapper;
import com.lugew.winsim.service.AbstractMySqlService;
import org.springframework.stereotype.Service;

/**
 * @author LuGew
 * @since 2020/7/29
 */
@Service
public class UserService extends AbstractMySqlService<User, UserMapper> {
    @Override
    public Long getCurrentUserId() {
        return null;
    }
}
