import db.DBHelper;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Studio studio = new Studio("Marvel Studio");
        DBHelper.save(studio);

        Studio studio2 = new Studio("New Line Cinema");
        DBHelper.save(studio2);

        Studio studio3 = new Studio("Morgan Creek");
        DBHelper.save(studio2);

        Director director = new Director("Scott Derrickson", 51);
        DBHelper.save(director);

        Director director2 = new Director("Zach Braff", 43);
        DBHelper.save(director2);

        Director director3 = new Director("Kevin Reynolds", 66);
        DBHelper.save(director3);

        Film film = new Film("Doctor Strange", 2016, FilmGenre.ACTION, studio, director, 10000);
        DBHelper.save(film);

        Film film2 = new Film("Going in Style", 2017, FilmGenre.COMEDY, studio2, director2, 12000);
        DBHelper.save(film2);

        Film film3 = new Film("Robin Hood: Prince of Theives", 1991, FilmGenre.ACTION, studio3, director3, 4000);

        Actor actor = new Actor("Benedict Cumberbatch", 41, 1000);
        DBHelper.save(actor);

        Actor actor1 = new Actor("Morgan Freeman", 81, 2000);
        DBHelper.save(actor1);


        List<Actor> allActors = DBHelper.getAll(Actor.class);
        List<Studio> allStudios = DBHelper.getAll(Studio.class);
        List<Director> allDirectors = DBHelper.getAll(Director.class);
        List<Film> allFilms = DBHelper.getAll(Film.class);
    }

}
