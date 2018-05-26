package com.expedia.application.configurer;


import com.expedia.application.converter.date.DateConverter;
import com.expedia.application.converter.date.impl.DefaultDateConverter;
import com.expedia.application.usecase.impl.RequestParamValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationTestConfiguration {

    @Bean
    public DateConverter defaultDateConverter() {
        return new DefaultDateConverter();
    }

    @Bean
    public RequestParamValidator requestParamValidator() {
        return new RequestParamValidator();
    }

}
