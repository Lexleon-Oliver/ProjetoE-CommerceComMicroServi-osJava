package com.digitalinnovationone.ecommerce.service;

import com.digitalinnovationone.ecommerce.entity.CheckoutEntity;
import com.digitalinnovationone.ecommerce.resource.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

}
