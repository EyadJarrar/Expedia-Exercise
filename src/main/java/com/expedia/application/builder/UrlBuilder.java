package com.expedia.application.builder;

import com.expedia.application.model.RequestParam;

@FunctionalInterface
public interface UrlBuilder {

    String build(String jsonUrl, RequestParam requestParam);
}
