package com.tmicroservice.department_service.config;

import com.tmicroservice.department_service.client.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    // Define the WebClient Bean
    @Bean
    public WebClient employeeWebClient() {
        return WebClient.builder()
                .baseUrl("http://employee-service")
                .filter(filterFunction)
                .build();
    }

    // Define the EmployeeClient Bean
    @Bean
    public EmployeeClient employeeClient() {
        // Create a WebClientAdapter
        WebClientAdapter webClientAdapter = WebClientAdapter.forClient(employeeWebClient);

        // Create the HttpServiceProxyFactory with the WebClientAdapter
        HttpServiceProxyFactory httpServiceProxyFactory
                = HttpServiceProxyFactory
                .builder()
                .build();
        // Use the factory to create the EmployeeClient
        return httpServiceProxyFactory.createClient(EmployeeClient.class);
    }
}
