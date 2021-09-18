package yyc.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import yyc.springcloud.dao.PaymentDao;
import yyc.springcloud.entities.Payment;

public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    @Override
    public int creat(Payment payment) {
        return paymentDao.creat(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
