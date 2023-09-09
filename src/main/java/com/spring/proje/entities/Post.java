package com.spring.proje.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Data
@Table(name = "post")
public class Post {
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY) //lazy: user nesnesinin sadece id degerini getir
    @JoinColumn(name = "user_id", nullable = false) //nullable: boş bırakılamaz
    @OnDelete(action = OnDeleteAction.CASCADE) //user silindiğinde postu da sil
    @JsonIgnore
    User user;

    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;

}
