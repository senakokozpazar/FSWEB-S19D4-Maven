package com.workintech.s19d1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="actor", schema="fsweb")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @Column(name="last_name")
    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    @NotNull(message = "Gender is mandatory")
    private Gender gender;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "movie_actor", schema="fsweb",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies;

    public void addMovie(Movie movie){
        if(movies == null){
            movies = new ArrayList<>();
        }
        movies.add(movie);
    }

}
