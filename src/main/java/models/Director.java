package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Director {

    private int id;
    private String name;
    private int age;
    private List<Film> films;

    public Director(){

    }

    public Director(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    @ManyToMany
    @JoinTable(name = "director_film",
            joinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "director_id", nullable = false, updatable = false)})
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
