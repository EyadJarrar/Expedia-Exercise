package com.expedia.application.controller;

import com.expedia.application.model.Hotel;
import com.expedia.application.model.RequestParam;
import com.expedia.application.usecase.UseCaseFactory;
import com.expedia.application.usecase.Usecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class OffersController {

    @Autowired
    private UseCaseFactory useCaseFactory;

    @GetMapping(value = {"/","/form"})
    public String greetingForm(Model model) {
        model.addAttribute("requestParam", new RequestParam());
        return "form";
    }

    @PostMapping("/form")
    public String greetingSubmit(@ModelAttribute RequestParam requestParam, Model model) {
        Usecase<RequestParam, Map<String, String>> requestParamValidatorUseCase = useCaseFactory.validate();
        if (validateForm(requestParam, model, requestParamValidatorUseCase)) return "form";

        Usecase<RequestParam, List<Hotel>> requestFilterListUseCase = useCaseFactory.showResult();

        List<Hotel> hotels = requestFilterListUseCase.execute(requestParam);

        model.addAttribute("hotels", hotels);

        return "result";
    }

    private boolean validateForm(@ModelAttribute RequestParam requestParam, Model model, Usecase<RequestParam, Map<String, String>> requestParamValidatorUseCase) {
        Map<String, String> violations = requestParamValidatorUseCase.execute(requestParam);
        if (!violations.isEmpty()) {
            model.addAttribute("errors", violations);
            return true;
        }
        return false;
    }

}