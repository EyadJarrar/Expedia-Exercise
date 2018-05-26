package com.expedia.application.repository.impl;

import com.expedia.application.builder.UrlBuilder;
import com.expedia.application.model.OfferModel;
import com.expedia.application.model.RequestParam;
import com.expedia.application.repository.JSONReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class DefaultJSONReader implements JSONReader {

    private static final Logger logger = LoggerFactory.getLogger(DefaultJSONReader.class);

    @Value("${default.json.data.url}")
    private String jsonUrl;

    @Autowired
    private UrlBuilder urlBuilder;

    @Override
    public OfferModel Read(RequestParam requestParam) {
        ObjectMapper mapper = new ObjectMapper();
        OfferModel offerModel = null;
        try {
            offerModel = mapper.readValue(new URL(urlBuilder.build(jsonUrl, requestParam)), OfferModel.class);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return offerModel;
    }
}
