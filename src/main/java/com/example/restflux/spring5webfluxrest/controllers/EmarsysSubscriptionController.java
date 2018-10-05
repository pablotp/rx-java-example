package com.example.restflux.spring5webfluxrest.controllers;

import com.example.restflux.spring5webfluxrest.domain.EmarsysContactDetails;
import com.example.restflux.spring5webfluxrest.domain.EmarsysSubscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmarsysSubscriptionController {

    @GetMapping("/api/v1/subscriptions")
    Flux<EmarsysSubscription> listSubscriptions() {
        List<EmarsysContactDetails> contactDetailsList = new ArrayList();
        contactDetailsList.add(EmarsysContactDetails.builder().account("rb_uk").id("emarsys_id1").optIn(false).build());
        contactDetailsList.add(EmarsysContactDetails.builder().account("rb_de").id("emarsys_id2").optIn(true).build());
        contactDetailsList.add(EmarsysContactDetails.builder().account("rb_at").id("emarsys_id3").optIn(false).build());

        List<EmarsysSubscription> subscriptionList = new ArrayList();
        subscriptionList.add(EmarsysSubscription.builder().email("something@redbull.com").contactDetails(contactDetailsList).build());
        subscriptionList.add(EmarsysSubscription.builder().email("2222@redbull.com").contactDetails(contactDetailsList).build());
        subscriptionList.add(EmarsysSubscription.builder().email("33333@redbull.com").contactDetails(contactDetailsList).build());
        subscriptionList.add(EmarsysSubscription.builder().email("44444@redbull.com").contactDetails(contactDetailsList).build());

        return Flux.fromIterable(subscriptionList)
                .delayElements(Duration.ofSeconds(2));
    }
}
