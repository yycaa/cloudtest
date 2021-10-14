package yyc.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import yyc.springcloud.entities.CommonResult;
import yyc.springcloud.entities.Payment;
import yyc.springcloud.service.PaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentCtrl {
    @Resource
    PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @PostMapping("/payment/creat")
    public CommonResult<Payment> creat(@RequestBody  Payment payment){
        log.info("payment:{}",payment.getId());
        log.info("payment:{}",payment.getSerial());
        int result = paymentService.creat(payment);
        if(result >0 ){
            return new CommonResult(200,"success8002"+port,null);
        }else{
            return new CommonResult<>(555,"payment ID :"+payment.getId()+"creat failed!",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        log.info("--------------------{}",id);
        Payment p = paymentService.getPaymentById(id);
        log.info("+++++++++++++++"+p.toString());
        if(null != p){

            return new CommonResult<Payment>(200,"success"+port,p);
        }else{
            return new CommonResult<Payment>(444,"ID :"+id+"get failed",null);
        }
    }

}
