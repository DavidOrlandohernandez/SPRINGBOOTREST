package com.Jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Toda tabla debe tener una PK
    private Long id;
    private String name;

    @OneToOne(targetEntity = Coach.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name =  "id_coach")
    private Coach coach;

    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club")
    private List<Player> players;

    @ManyToOne(targetEntity = FootBallAssociation.class)
    private FootBallAssociation association;

    @ManyToMany(targetEntity = FootBallCompetition.class,fetch = FetchType.LAZY)
    @JoinTable(name = "club_competitions", joinColumns = @JoinColumn(name="club"), inverseJoinColumns = @JoinColumn(name = "competition"))
    private List<FootBallCompetition> footBallCompetitions;
}
