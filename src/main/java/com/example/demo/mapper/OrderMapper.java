package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    // 根据用户ID查询当前用户所有订单
    @Select("select * from orders where uid = #{uid}")
    public List<Order> selectOrdersById(int uid);

    // 获取所有订单信息（分页）
    @Select("select * from orders limit #{pageCount},#{pageSize}")
    public List<Order> selectOrdersPaging(int pageCount, int pageSize);
}
