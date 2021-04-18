package com.digitalinnovationone.ecommerce.config;

import com.digitalinnovationone.ecommerce.streaming.CheckoutCreatedSource;
import com.digitalinnovationone.ecommerce.streaming.PaymentPaidSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {
        CheckoutCreatedSource.class,
        PaymentPaidSink.class
})
public class StreamingConfig {
}
