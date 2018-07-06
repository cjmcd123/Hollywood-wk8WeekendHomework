package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor {

    private int id;
    private String name;
    private int age;
    private int price;
    private int money;
    private List<Film> films;

    public Actor(){

    }

    public Actor(String name, int age, int price) {
        this.name = name;
        this.age = age;
        this.price = price;
        this.films = new ArrayList<Film>();
        this.money = 0;
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

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    @Column(name = "money")
    public int getMoney(){
        return money;
    }

    @ManyToMany
    @JoinTable(name = "actor_film",
            joinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)})
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

    public void setPrice(int price) {
        this.price = price;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addFilm(Film film) {
        this.films.add(film);
    }
}
