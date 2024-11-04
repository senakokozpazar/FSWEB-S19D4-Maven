package com.workintech.s19d1.dto;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Gender;
import com.workintech.s19d1.entity.Movie;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ActorRequest{
    private List<Movie> movies;
    private Actor actor;
}
