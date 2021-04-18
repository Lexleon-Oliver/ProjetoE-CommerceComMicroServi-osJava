package com.digitalinnovationone.ecommerce.payment.listener;

import com.digitalinnovationone.ecommerce.event.CheckoutCreatedEvent;
import com.digitalinnovationone.ecommerce.payment.event.PaymentCreatedEvent;
import com.digitalinnovationone.ecommerce.payment.streaming.CheckoutProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckoutCreatedListener {

    private final CheckoutProcessor checkoutProcessor;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler (CheckoutCreatedEvent event){
    //Processa pagamento gateway;
    //salvar dados de pagamento
    //enviar o evento do pagamento processado
        final PaymentCreatedEvent paymentCreatedEvent= PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(event.getCheckoutCode())
                .setCheckoutStatus(event.getStatus())
                .setPaymentCode(UUID.randomUUID().toString())
                .build();
        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());
    }
}
