package com.dailycoder.webflux.router;

import com.dailycoder.webflux.dto.Customer;
import com.dailycoder.webflux.handler.CustomerHandler;
import com.dailycoder.webflux.handler.CustomerSteramHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandler customerHandler;

    @Autowired
    private CustomerSteramHandler steramHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/router/customers",customerHandler::loadCustomer)
                .GET("/router/customers/stream",steramHandler::streamCustomer)
                .GET("/router/customers/{id}",customerHandler::findCustiomerById)
                .POST("/router/customers/save",customerHandler::saveCustomer)
                .build();
    }
}
