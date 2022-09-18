package com.starzplay.repository;

import com.starzplay.entity.PaymentMethod;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bilal Hassan on 17-Sep-22
 * @project starzplay
 */

@Repository
public interface PaymentMethodRepository extends PagingAndSortingRepository<PaymentMethod, Long> {
    List<PaymentMethod> findAllByName(String name);
}
