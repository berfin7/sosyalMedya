package com.spring.proje.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "likes")
public class Like{
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY) //lazy: user nesnesinin sadece id degerini getir
    @JoinColumn(name = "user_id", nullable = false) //nullable: boş bırakılamaz
    @OnDelete(action = OnDeleteAction.CASCADE) //user silindiğinde likeı da sil
    @JsonIgnore
    User user;

    @ManyToOne(fetch = FetchType.LAZY) //lazy: user nesnesinin sadece id degerini getir
    @JoinColumn(name = "post_id", nullable = false) //nullable: boş bırakılamaz
    @OnDelete(action = OnDeleteAction.CASCADE) //post silindiğinde likeı da sil
    @JsonIgnore
    Post post;


}
