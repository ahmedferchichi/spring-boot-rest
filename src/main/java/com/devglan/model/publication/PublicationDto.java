package com.devglan.model.publication;

import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PublicationDto {

    private int id;
    private String title;
    private String content;
    private String editor;
    private Date date;
    private List<String> thematics;
}
