package com.devglan.model.publication;

import com.devglan.model.thematic.Thematic;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "publication")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String editor;
    @Column
    @CreatedDate
    private Date date;
    @ElementCollection
    @Column
    private Collection<Thematic> thematics;

}