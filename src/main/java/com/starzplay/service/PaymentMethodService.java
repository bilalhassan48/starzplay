package com.starzplay.service;

import com.starzplay.entity.PaymentMethod;
import com.starzplay.repository.PaymentMethodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * @author Bilal Hassan on 17-Sep-22
 * @project starzplay
 */

@Slf4j
@Service
@Transactional
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public List<PaymentMethod> getAll() {
        log.info("In PaymentMethodService getAll method");
        return (List<PaymentMethod>) paymentMethodRepository.findAll();
    }

    public List<PaymentMethod> getAllById(long id) {
        log.info("In PaymentMethodService getAllById method with id {}", id);
        return (List<PaymentMethod>) paymentMethodRepository.findAllById(Collections.singleton(id));
    }

    public List<PaymentMethod> getAllByName(String name) {
        log.info("In PaymentMethodService getAllByName with name {}", name);
        return paymentMethodRepository.findAllByName(name);
    }

    public PaymentMethod save(PaymentMethod paymentMethod) {
        log.info("In PaymentMethodService save method");
        /**
         * @Note: If we want to validate anything from database like duplicate name of anything else
         * than we can write validators and call there methods from here
         */
        return paymentMethodRepository.save(paymentMethod);
    }

    public PaymentMethod update(PaymentMethod paymentMethod) {
        log.info("In PaymentMethodService update method");
        /**
         * @Note: If we want to validate anything from database like duplicate name of anything else
         * than we can write validators and call there methods from here
         */
        return paymentMethodRepository.save(paymentMethod);
    }
}
