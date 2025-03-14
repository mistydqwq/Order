package com.mistyd.order.adapters.outbound;

import com.mistyd.order.domain.valueobj.OrderVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author mistyd
* @description 针对表【orders(订单表)】的数据库操作Mapper
* @createDate 2024-12-28 21:36:22
* @Entity generator.domain.Orders
*/
@Mapper
public interface OrderMapper extends BaseMapper<OrderVO> {

}




