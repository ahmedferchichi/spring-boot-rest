package com.devglan.model.publication;

import com.devglan.model.thematic.Thematic;
import lombok.*;

import java.util.Collection;
import java.util.Date;

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
    private Collection<Thematic> thematics;
}
