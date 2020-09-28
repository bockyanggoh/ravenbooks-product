//package com.ravenbooks.product.config.kafka;
//
//import org.axonframework.config.Configurer;
//import org.axonframework.config.EventProcessingConfigurer;
//import org.axonframework.extensions.kafka.KafkaProperties;
//import org.axonframework.extensions.kafka.configuration.KafkaMessageSourceConfigurer;
//import org.axonframework.extensions.kafka.eventhandling.DefaultKafkaMessageConverter;
//import org.axonframework.extensions.kafka.eventhandling.KafkaMessageConverter;
//import org.axonframework.extensions.kafka.eventhandling.consumer.streamable.StreamableKafkaMessageSource;
//import org.axonframework.extensions.kafka.eventhandling.producer.ConfirmationMode;
//import org.axonframework.extensions.kafka.eventhandling.producer.DefaultProducerFactory;
//import org.axonframework.extensions.kafka.eventhandling.producer.ProducerFactory;
//import org.axonframework.serialization.Serializer;
//import org.axonframework.springboot.autoconfig.AxonAutoConfiguration;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@AutoConfigureAfter(AxonAutoConfiguration.class)
//@ConditionalOnProperty( value = "axon.kafka.consumer.event-processor-mode", havingValue = "TRACKING")
//public class KafkaProducerConfig {
//    @ConditionalOnMissingBean
//    @Bean
//    public KafkaMessageConverter<String, byte[]> kafkaMessageConverter(@Qualifier("eventSerializer") Serializer eventSerializer) {
//        return DefaultKafkaMessageConverter
//                .builder()
//                .serializer(eventSerializer)
//                .build();
//    }
//
//    @Bean
//    public ProducerFactory<String, byte[]> producerFactory(KafkaProperties kafkaProperties) {
//        return DefaultProducerFactory
//                .<String, byte[]>builder()
//                .configuration(kafkaProperties.buildProducerProperties())
//                .producerCacheSize(10_000)
//                .confirmationMode(ConfirmationMode.WAIT_FOR_ACK)
//                .build();
//    }
//}
