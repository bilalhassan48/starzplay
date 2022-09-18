package com.starzplay.entity;

import com.starzplay.dto.PaymentPlanDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bilal Hassan on 17-Sep-22
 * @project starzplay
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "payment_plan")
@Getter
@Setter
public class PaymentPlan {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "net_amount")
    private double netAmount;

    @Column(name = "tax_amount")
    private double taxAmount;

    @Column(name = "gross_amount")
    private double grossAmount;

    private String currency;
    private String duration;

    public static PaymentPlanDto convertToDto(PaymentPlan paymentPlan) {
        return PaymentPlanDto.builder()
                .id(paymentPlan.getId())
                .netAmount(paymentPlan.getNetAmount())
                .taxAmount(paymentPlan.getTaxAmount())
                .grossAmount(paymentPlan.getGrossAmount())
                .currency(paymentPlan.getCurrency())
                .duration(paymentPlan.getDuration())
                .build();
    }

    public static List<PaymentPlanDto> convertToDto(List<PaymentPlan> paymentPlans) {
        return paymentPlans.stream()
                .map(PaymentPlan::convertToDto)
                .collect(Collectors.toList());
    }
}
