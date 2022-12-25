package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import com.example.demo.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 查询所有用户信息
    @Select("select * from user")
    public List<Users> selectAllUsers();

    // 根据id查询用户信息
    @Select("select * from user where id = #{id}")
    public Users selectUserById(int id);

    // 增加用户
    @Insert("insert into user values(#{id},#{name},#{age},#{birthday})")
    public int insertUser(Users users);

    // 修改用户
    @Update("update user set name = #{name}, age = #{age}, birthday = #{birthday} where id = #{id}")
    public int updateUser(Users users);

    // 删除用户
    @Delete("delete from user where id = #{id}")
    public int deleteUser(int id);
}
