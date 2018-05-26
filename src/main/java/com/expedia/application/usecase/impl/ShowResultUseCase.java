package com.expedia.application.usecase.impl;

import com.expedia.application.model.Hotel;
import com.expedia.application.model.OfferModel;
import com.expedia.application.model.RequestParam;
import com.expedia.application.repository.JSONReader;
import com.expedia.application.usecase.Usecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowResultUseCase implements Usecase<RequestParam, List<Hotel>> {

    @Autowired
    private JSONReader jsonReader;

    @Override
    public List<Hotel> execute(RequestParam requestParam) {
        OfferModel offerModel = jsonReader.Read(requestParam);
        return offerModel.getOffers().getHotel();
    }
}