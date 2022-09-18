package com.starzplay.dto;

import com.starzplay.entity.PaymentPlan;
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
public class PaymentPlanDto {
    private long id;
    private double netAmount;
    private double taxAmount;
    private double grossAmount;
    private String currency;
    private String duration;

    public static PaymentPlan convertToEntity(PaymentPlanDto paymentPlanDto) {
        return PaymentPlan.builder()
                .id(paymentPlanDto.getId())
                .netAmount(paymentPlanDto.getNetAmount())
                .taxAmount(paymentPlanDto.getTaxAmount())
                .grossAmount(paymentPlanDto.getGrossAmount())
                .currency(paymentPlanDto.getCurrency())
                .duration(paymentPlanDto.getDuration())
                .build();
    }

    public static List<PaymentPlan> convertToEntity(List<PaymentPlanDto> paymentPlanDtos) {
        return paymentPlanDtos.stream()
                .map(PaymentPlanDto::convertToEntity)
                .collect(Collectors.toList());
    }
}
