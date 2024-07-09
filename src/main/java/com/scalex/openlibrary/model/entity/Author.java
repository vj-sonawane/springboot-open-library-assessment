package com.scalex.openlibrary.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "author")
public class Author {

    @Id
    @Column(nullable = false, name="id")
    public String id;

    @Column(nullable = false, name="authors")
    public String name;
}
