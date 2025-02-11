package com.hostilian.blablacarapi.service.dto;

public record Stop(
    Long id,
    String shortName,
    String longName,
    Double latitude,
    Double longitude,
    List<Long> destinationsIds
) {
    
}
