package com.example.wcdealershop.web;

import com.example.wcdealershop.models.Offer;
import com.example.wcdealershop.models.dtos.OfferAddDto;
import com.example.wcdealershop.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/add")
    public String getPage() {
        return "offer-add";
    }

    @PostMapping("/add")
    public String uploadOffer(OfferAddDto offerAddDto) {
        this.offerService.createOffer(offerAddDto);
         return "redirect:/";
    }

    @GetMapping("/all")
    public String getAll(Model offers) {
        offers.addAttribute("offers", this.offerService.getAllOffers());
        return "all";
    }

    @GetMapping("/details/{id}")
    public String getOfferDetails(@PathVariable String id, Model offer) {
        Offer byOfferId = this.offerService.getByOfferId(id);
        offer.addAttribute("offer", byOfferId);
        offer.addAttribute("model", byOfferId.getModel());
        return "details";
    }
}
