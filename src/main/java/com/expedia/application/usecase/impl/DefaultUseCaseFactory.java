package com.expedia.application.usecase.impl;

import com.expedia.application.model.Hotel;
import com.expedia.application.model.RequestParam;
import com.expedia.application.usecase.UseCaseFactory;
import com.expedia.application.usecase.Usecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DefaultUseCaseFactory implements UseCaseFactory {

    @Autowired
    private RequestParamValidator requestParamValidator;

    @Autowired
    private ShowResultUseCase showResultUseCase;


    @Override
    public Usecase<RequestParam, Map<String, String>> validate() {
        return requestParamValidator;
    }

    @Override
    public Usecase<RequestParam, List<Hotel>> showResult() {
        return showResultUseCase;
    }
}
