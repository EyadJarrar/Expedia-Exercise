package com.expedia.application.usecase;

import com.expedia.application.model.Hotel;
import com.expedia.application.model.RequestParam;

import java.util.List;
import java.util.Map;


public interface UseCaseFactory {

    Usecase<RequestParam, Map<String, String>> validate();

    Usecase<RequestParam, List<Hotel>> showResult();

}
