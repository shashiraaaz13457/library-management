package com.library.library_management.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Keep this in mind.
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL) // CascadeType.ALL means if you delete an Author , all their books get deleted too.
    private List<Book> books;
}
