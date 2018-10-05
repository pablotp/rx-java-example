package com.example.restflux.spring5webfluxrest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmarsysContactDetails {
    private String account;
    private String id;
    private Boolean optIn;
}
