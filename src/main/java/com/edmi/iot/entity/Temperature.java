package com.edmi.iot.entity;

import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "TEMPERATURE")
public class Temperature {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "label", length = 50)
    private String label;

    @Column(name = "value", length = 5)
    private Double value;

    @Column(name = "date", length = 30)
    private String date;
}
