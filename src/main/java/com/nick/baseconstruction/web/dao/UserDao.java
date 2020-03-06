package com.nick.baseconstruction.web.dao;

import com.nick.baseconstruction.web.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    void insert(User user);
}
