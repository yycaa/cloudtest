package yyc.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yyc.springcloud.entities.Payment;

@Mapper
public interface PaymentDao {
    public int creat(Payment payment);
    //使用@Param在接口参数中，以后接口的实现类中就不用标注了，方便！
    public Payment getPaymentById(@Param("id") Long id);
}
