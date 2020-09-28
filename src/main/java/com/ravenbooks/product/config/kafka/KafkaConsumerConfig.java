//package com.ravenbooks.product.config.kafka;
//
//
//import ch.qos.logback.classic.pattern.MessageConverter;
//import com.ravenbooks.product.cqrs.event.ProductCreatedEvent;
//import org.axonframework.config.Configurer;
//import org.axonframework.config.EventProcessingConfigurer;
//import org.axonframework.eventhandling.EventMessage;
//import org.axonframework.extensions.kafka.KafkaProperties;
//import org.axonframework.extensions.kafka.configuration.KafkaMessageSourceConfigurer;
//import org.axonframework.extensions.kafka.eventhandling.KafkaMessageConverter;
//import org.axonframework.extensions.kafka.eventhandling.consumer.AsyncFetcher;
//import org.axonframework.extensions.kafka.eventhandling.consumer.ConsumerFactory;
//import org.axonframework.extensions.kafka.eventhandling.consumer.Fetcher;
//import org.axonframework.extensions.kafka.eventhandling.consumer.streamable.StreamableKafkaMessageSource;
//import org.axonframework.extensions.kafka.eventhandling.consumer.subscribable.SubscribableKafkaMessageSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.TaskExecutor;
//
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//
//@Configuration
//public class KafkaConsumerConfig {
//    @Bean
//    public Fetcher<?, ?, ?> fetcher(TaskExecutor executorService) {
//        return AsyncFetcher
//                .builder()
//                .pollTimeout(5000)
//                .executorService(executorService)
//                .build();
//    }
//
//}
//
//@Configuration
//@ConditionalOnProperty(value = "axon.kafka.consumer.event-processor-mode", havingValue = "TRACKING")
//class TrackingConfiguration {
//    @Autowired
//    public void configureStreamableKafkaSource(
//            EventProcessingConfigurer configurer,
//            StreamableKafkaMessageSource<String, byte[]> messageSource) {
//        configurer.registerEventHandler(config -> messageSource);
//    }
//}
//
//
//@Configuration
//@ConditionalOnProperty(value = "axon.kafka.consumer.event-processor-mode", havingValue = "SUBSCRIBING")
//class SubscribingConfiguration {
//
//    @Bean
//    public KafkaMessageSourceConfigurer kafkaMessageSourceConfigurer() {
//        return new KafkaMessageSourceConfigurer();
//    }
//
//    @Autowired
//    public void registerKafkaMessageSourceConfigurer(
//            Configurer configurer,
//            KafkaMessageSourceConfigurer messageSourceConfigurer
//    ) {
//        configurer.registerModule(messageSourceConfigurer);
//    }
//
//    @Bean
//    public SubscribableKafkaMessageSource<String, byte[]> subscribableKafkaMessageSource(
//            KafkaProperties kafkaProperties,
//            ConsumerFactory<String, byte[]> consumerFactory,
//            Fetcher<String, byte[], EventMessage<?>> fetcher,
//            KafkaMessageConverter<String, byte[]> messageConverter,
//            KafkaMessageSourceConfigurer configurer
//    ) {
//        var subscribableKafkaMessageSource = SubscribableKafkaMessageSource
//                .<String, byte[]>builder()
//                .topics(List.of(kafkaProperties.getDefaultTopic()))
//                .groupId("test-group")
//                .consumerFactory(consumerFactory)
//                .fetcher(fetcher)
//                .messageConverter(messageConverter)
//                .build();
//        configurer.registerSubscribableSource(conf -> subscribableKafkaMessageSource);
//        return subscribableKafkaMessageSource;
//    }
//
//    @Autowired
//    public void configureSubscribableKafkaSource(
//            EventProcessingConfigurer eventProcessingConfigurer,
//            SubscribableKafkaMessageSource<String, byte[]> subscribableKafkaMessageSource
//    ) {
//        eventProcessingConfigurer.registerSubscribingEventProcessor("kafka-group", conf -> subscribableKafkaMessageSource);
//    }
//}