package com.starzplay.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.starzplay.entity.PaymentMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Bilal Hassan on 17-Sep-22
 * @project starzplay
 */

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PaymentMethodDto {
    @JsonIgnore
    private long id;
    private String name;
    private String displayName;
    private String paymentType;
    private List<PaymentPlanDto> paymentPlans;

    public static PaymentMethod convertToEntity(PaymentMethodDto paymentMethodDto) {
        return PaymentMethod.builder()
                .id(paymentMethodDto.getId())
                .name(paymentMethodDto.getName())
                .displayName(paymentMethodDto.getDisplayName())
                .paymentType(paymentMethodDto.getPaymentType())
                .paymentPlans(paymentMethodDto.getPaymentPlans() != null ? PaymentPlanDto.convertToEntity(paymentMethodDto.getPaymentPlans()) : null)
                .build();
    }

    public static List<PaymentMethod> convertToEntity(List<PaymentMethodDto> paymentMethodDtos) {
        return paymentMethodDtos.stream()
                .map(PaymentMethodDto::convertToEntity)
                .collect(Collectors.toList());
    }
}
