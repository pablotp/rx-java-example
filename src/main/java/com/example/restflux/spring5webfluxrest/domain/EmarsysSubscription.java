package com.example.restflux.spring5webfluxrest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmarsysSubscription {
    private String email;
    private List<EmarsysContactDetails> contactDetails;
}
