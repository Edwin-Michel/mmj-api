package com.edmi.iot.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TemperatureDTO {
    private String label;
    private Double value;
    private String date;
}
