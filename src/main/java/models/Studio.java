package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Studio {

    private int id;
    private String name;
    private List<Film> films;

    public Studio(){

    }

    public Studio(String name) {
        this.name = name;
        this.films = new ArrayList<Film>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @ManyToMany
    @JoinTable(name = "studio_film",
            joinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "studio_id", nullable = false, updatable = false)})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public List<Film> getFilms() {
        return films;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
