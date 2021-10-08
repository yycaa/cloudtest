package yyc.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import yyc.springcloud.entities.CommonResult;
import yyc.springcloud.entities.Payment;

import javax.annotation.Resource;

@RestController
public class ConsumerCtrl {
    @Resource
    RestTemplate template;
    //@Value("paymentServerUrl")
    String paymentServerUrl="http://localhost:8001";

    @GetMapping("/consumer/payment/creat")
    public CommonResult<Payment> creat(Payment payment){
        return template.postForObject(paymentServerUrl+"/payment/creat",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable Long id)
    {
        return template.getForObject(paymentServerUrl + "/payment/get/"+id, CommonResult.class, id);
    }

}
