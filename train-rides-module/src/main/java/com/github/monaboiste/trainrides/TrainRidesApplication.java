package com.github.monaboiste.trainrides;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.annotation.Observed;
import io.micrometer.observation.aop.ObservedAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@Slf4j
@SpringBootApplication
public class TrainRidesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainRidesApplication.class, args);
    }


    @RestController
    class TraceController {

        @GetMapping("/trace")
        @Observed
        Mono<String> testTrace() {
            log.info("Testing trace");
            return Mono.just("OK");
        }
    }

    @Configuration(proxyBeanMethods = false)
    public class ObservedAspectConfig {

        @Bean
        public ObservedAspect observedAspect(final ObservationRegistry observationRegistry) {
            return new ObservedAspect(observationRegistry);
        }
    }
}
