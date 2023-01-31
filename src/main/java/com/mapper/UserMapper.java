package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    int insert(User user);
    int update(@Param("username")String username,@Param("id")int id);
}
