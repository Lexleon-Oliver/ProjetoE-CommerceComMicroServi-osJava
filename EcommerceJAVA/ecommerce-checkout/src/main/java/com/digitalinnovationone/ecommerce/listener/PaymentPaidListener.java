package com.digitalinnovationone.ecommerce.listener;

import com.digitalinnovationone.ecommerce.entity.CheckoutEntity;
import com.digitalinnovationone.ecommerce.payment.event.PaymentCreatedEvent;
import com.digitalinnovationone.ecommerce.repository.CheckoutRepository;
import com.digitalinnovationone.ecommerce.streaming.PaymentPaidSink;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.annotation.StreamRetryTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private CheckoutRepository checkoutRepository;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handle(PaymentCreatedEvent event){
        final CheckoutEntity checkoutEntity= checkoutRepository.findByCode(event.getCheckoutCode().toString()).orElseThrow();
        checkoutEntity.setStatus(CheckoutEntity.Status.APPROVED);
        checkoutRepository.save(checkoutEntity);

    }
}
