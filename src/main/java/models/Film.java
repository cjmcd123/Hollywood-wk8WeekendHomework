package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")
public class Film {

    private int id;
    private String title;
    private int year;
    private FilmGenre genre;
    private Studio studio;
    private Director director;
    private int budget;
    private List<Actor> actors;

    public Film(){

    }

    public Film(String title, int year, FilmGenre genre, Studio studio, Director director, int budget) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.studio = studio;
        this.director = director;
        this.budget = budget;
        this.actors = new ArrayList<Actor>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }

    @Enumerated(value = EnumType.STRING)
    public FilmGenre getGenre() {
        return genre;
    }

    @ManyToOne
    @JoinColumn(name="studio_id", nullable=false)
    public Studio getStudio() {
        return studio;
    }

    @ManyToOne
    @JoinColumn(name="director_id", nullable=false)
    public Director getDirector() {
        return director;
    }

    @Column(name = "budget")
    public int getBudget() {
        return budget;
    }

    @ManyToMany
    @JoinTable(name = "actor_film",
            joinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public List<Actor> getActors() {
        return actors;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(FilmGenre genre) {
        this.genre = genre;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    public void payActors() {
        for (Actor actor : actors){
            int price = actor.getPrice();
            int budget = this.getBudget();
            int money = actor.getMoney();
            setBudget(budget - price);
            actor.setMoney(money + price);
        }
    }

    public void payAllActors(List<Actor> actors) {
        for (Actor actor : actors){
            int price = actor.getPrice();
            int budget = this.getBudget();
            int money = actor.getMoney();
            setBudget(budget - price);
            actor.setMoney(money + price);
        }
    }
}
