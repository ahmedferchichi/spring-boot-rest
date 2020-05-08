package com.devglan.model.thematic;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "thematic")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString
public class Thematic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;

}
