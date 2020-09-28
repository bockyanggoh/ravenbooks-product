//package com.ravenbooks.product.config.kafka;
//
//import org.axonframework.config.EventProcessingConfigurer;
//import org.axonframework.extensions.kafka.KafkaProperties;
//import org.axonframework.extensions.kafka.eventhandling.DefaultKafkaMessageConverter;
//import org.axonframework.extensions.kafka.eventhandling.KafkaMessageConverter;
//import org.axonframework.extensions.kafka.eventhandling.consumer.ConsumerFactory;
//import org.axonframework.extensions.kafka.eventhandling.producer.*;
//import org.axonframework.serialization.Serializer;
//import org.axonframework.springboot.autoconfig.AxonAutoConfiguration;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@AutoConfigureAfter(AxonAutoConfiguration.class)
//public class KafkaConfig {
//
//    @ConditionalOnMissingBean
//    @Bean
//    public KafkaMessageConverter<String, byte[]> kafkaMessageConverter(
//            @Qualifier("eventSerializer") Serializer eventSerializer) {
//        return DefaultKafkaMessageConverter.builder()
//                .serializer(eventSerializer)
//                .build();
//    }
//}
