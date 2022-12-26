package com.example.demo.mapper;

import com.example.demo.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LoginMapper {
    @Update("insert into account values(#{id},#{account},#{password})")
    public int register(Account account);
}
