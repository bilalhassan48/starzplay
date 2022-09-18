package com.starzplay.entity;

import com.starzplay.dto.PaymentMethodDto;
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
@Getter
@Setter
@Entity
@Table(name = "payment")
public class PaymentMethod {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "payment_type")
    private String paymentType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_plan_id")
    private List<PaymentPlan> paymentPlans;

    public static PaymentMethodDto convertToDto(PaymentMethod paymentMethod) {
        return PaymentMethodDto.builder()
                .id(paymentMethod.getId())
                .name(paymentMethod.getName())
                .displayName(paymentMethod.getDisplayName())
                .paymentType(paymentMethod.getPaymentType())
                .paymentPlans(paymentMethod.getPaymentPlans() != null ? PaymentPlan.convertToDto(paymentMethod.getPaymentPlans()) : null)
                .build();
    }

    public static List<PaymentMethodDto> convertToDto(List<PaymentMethod> paymentMethods) {
        return paymentMethods.stream()
                .map(PaymentMethod::convertToDto)
                .collect(Collectors.toList());
    }
}
