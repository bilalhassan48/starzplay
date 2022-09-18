package com.starzplay.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * @author Bilal Hassan on 18-Sep-22
 * @project starzplay
 */

@Builder
@Getter
@Setter
public class ResponseDto {
    List<PaymentMethodDto> paymentMethods;

    public static ResponseDto convertToDto(List<PaymentMethodDto> paymentMethodDtos) {
        return ResponseDto.builder()
                .paymentMethods(paymentMethodDtos)
                .build();
    }

    public static ResponseDto convertToDto(PaymentMethodDto paymentMethodDto) {
        return ResponseDto.builder()
                .paymentMethods(Collections.singletonList(paymentMethodDto))
                .build();
    }
}
