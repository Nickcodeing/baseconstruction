package com.nick.baseconstruction.web.service.user;

import com.nick.baseconstruction.web.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 添加
     */
    void insert(User user);
}
