//package com.ravenbooks.product.config.kafka;
//
//
//import org.axonframework.config.EventProcessingConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class KafkaEventPublicationConfig {
//
//    @Bean(name = "defaultPublisher")
//    public KafkaPublisher<String, byte[]> kafkaPublisher(
//            KafkaProperties properties,
//            ProducerFactory<String, byte[]> producerFactory,
//            KafkaMessageConverter<String, byte[]> kafkaMessageConverter
//    ) {
//        return KafkaPublisher.<String, byte[]>builder()
//                .topic(properties.getDefaultTopic())
//                .producerFactory(producerFactory)
//                .messageConverter(kafkaMessageConverter)
//                .publisherAckTimeout(10000)
//                .build();
//    }
//
//    @Bean
//    public KafkaEventPublisher<String, byte[]> kafkaEventPublisher(KafkaPublisher<String, byte[]> kafkaPublisher) {
//        return KafkaEventPublisher.<String, byte[]>builder()
//                .kafkaPublisher(kafkaPublisher)
//                .build();
//    }
//
//    @Bean
//    public void registerPublisherToEventProcessor(
//            EventProcessingConfigurer configurer,
//            KafkaEventPublisher<String, byte[]> kafkaEventPublisher
//    ) {
//        String processingGroup = KafkaEventPublisher.DEFAULT_PROCESSING_GROUP;
//        configurer.registerEventHandler(configuration -> kafkaEventPublisher)
//                .assignHandlerTypesMatching(processingGroup,
//                        clazz -> clazz.isAssignableFrom(KafkaEventPublisher.class)
//                )
//                .registerSubscribingEventProcessor(processingGroup);
//    }
//
//}
