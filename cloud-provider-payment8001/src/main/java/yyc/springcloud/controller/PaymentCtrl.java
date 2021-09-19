package yyc.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yyc.springcloud.entities.CommonResult;
import yyc.springcloud.entities.Payment;
import yyc.springcloud.service.PaymentService;

import javax.annotation.Resource;

@RestController
public class PaymentCtrl {
    @Resource
    PaymentService paymentService;
    @PostMapping("/payment/creat")
    public CommonResult<Payment> creat(@RequestBody Payment payment){
        int result = paymentService.creat(payment);
        if(result >0 ){
            return new CommonResult(200,"success",null);
        }else{
            return new CommonResult<>(555,"payment ID :"+payment.getId()+"creat failed!",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        Payment p = paymentService.getPaymentById(id);
        if(null != p){
            return new CommonResult<Payment>(200,"success",p);
        }else{
            return new CommonResult<Payment>(444,"ID :"+id+"get failed",null);
        }
    }

}
