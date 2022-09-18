package com.starzplay.controller;

import com.starzplay.dto.PaymentMethodDto;
import com.starzplay.dto.ResponseDto;
import com.starzplay.entity.PaymentMethod;
import com.starzplay.service.PaymentMethodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bilal Hassan on 17-Sep-22
 * @project starzplay
 */

@Slf4j
@RestController
@RequestMapping("/configuration/payment-method")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    /**
     * @param name - name in case we want to fetch by name
     * @param id - id in case if we want to fetch by id
     * @return - ResponseDto with list of payment methods
     */
    @GetMapping
    public ResponseDto get(@RequestParam(required = false) String name,
                                      @RequestParam(required = false, defaultValue = "0") long id) {
        /**
         * Currently it is assumed that user can either fetch all or he can fetch by id or fetch by name
         * in case he wants to fetch on both than we can handle it but currently if he provides
         * both parameters it will onlu look for the name since name has high priority
         * another thing to note here is that we are returning list in every case but in my opinion if he
         * wants to fetch by id than he will get only 1 object since id is the primary key and cannot be duplicated!!
         */
        if(StringUtils.hasLength(name)) {
            log.info("In PaymentMethodController get method with name {}", name);
            return ResponseDto.convertToDto(PaymentMethod.convertToDto(paymentMethodService.getAllByName(name)));
        } else if(id != 0) {
            log.info("In PaymentMethodController get method with id {}", id);
            return ResponseDto.convertToDto(PaymentMethod.convertToDto(paymentMethodService.getAllById(id)));
        } else {
            log.info("In PaymentMethodController get method for getAll");
            return ResponseDto.convertToDto(PaymentMethod.convertToDto(paymentMethodService.getAll()));
        }
    }

    /**
     * @param paymentMethodDto - object to save
     * @return saved payment method object wrapped in responseDto
     */
    @PostMapping
    public ResponseDto save(@RequestBody PaymentMethodDto paymentMethodDto) {
        log.info("In PaymentMethodController save method");
        PaymentMethod paymentMethod = PaymentMethodDto.convertToEntity(paymentMethodDto);
        return ResponseDto.convertToDto(PaymentMethod.convertToDto(paymentMethodService.save(paymentMethod)));
    }

    /**
     * @param paymentMethodId - id which we want to update
     * @param paymentMethodDto - complete dto of values which we want to update against the given id
     * @return saved payment method object
     */
    @PutMapping
    public ResponseDto update(@RequestParam(name = "payment-methods") long paymentMethodId, @RequestBody PaymentMethodDto paymentMethodDto) {
        log.info("In PaymentMethodController update method with paymentMethodId {} to update", paymentMethodId);
        paymentMethodDto.setId(paymentMethodId);
        PaymentMethod paymentMethod = PaymentMethodDto.convertToEntity(paymentMethodDto);
        return ResponseDto.convertToDto(PaymentMethod.convertToDto(paymentMethodService.update(paymentMethod)));
    }
}
