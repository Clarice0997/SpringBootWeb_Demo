package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LoginMapper extends BaseMapper<Account> {
    // 注册Mapper
    @Update("insert into account values(#{id},#{account},#{password})")
    public int register(Account account);

    // 查询对应账号密码Mapper
    @Select("select password from account where account = #{account}")
    public String getPassword(String account);

    // 查询账户ID
    @Select("select id from account where account = #{account}")
    public int getAccountId(String account);
}
