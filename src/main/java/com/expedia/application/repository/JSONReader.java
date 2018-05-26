package com.expedia.application.repository;

import com.expedia.application.model.OfferModel;
import com.expedia.application.model.RequestParam;

@FunctionalInterface
public interface JSONReader {

    OfferModel Read(RequestParam requestParam);

}
