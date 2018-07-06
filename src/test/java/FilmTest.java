import models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FilmTest {

    Film film;
    Director director;
    Studio studio;
    Director director2;
    Studio studio2;
    Actor actor;

    @Before
    public void setUp(){
        studio = new Studio("Marvel Studio");
        studio2 = new Studio("Something");
        director = new Director("Scott Derrickson", 51);
        director2 = new Director("Something else", 51);
        film = new Film("Doctor Strange", 2016, FilmGenre.ACTION, studio, director, 10000);
    }

    @Test
    public void hasTitle(){
        assertEquals("Doctor Strange", film.getTitle());
    }

    @Test
    public void setTitle(){
        film.setTitle("Doctor Strange2");
        assertEquals("Doctor Strange2", film.getTitle());
    }

    @Test
    public void hasYear(){
        assertEquals(2016, film.getYear());
    }

    @Test
    public void setYear(){
        film.setYear(2018);
        assertEquals(2018, film.getYear());
    }

    @Test
    public void hasGenre(){
        assertEquals("Action", film.getGenre().getGenre());
    }

    @Test
    public void setGenre(){
        film.setGenre(FilmGenre.ADVENTURE);
        assertEquals("Adventure", film.getGenre().getGenre());
    }

    @Test
    public void hasStudio(){
        assertEquals(studio, film.getStudio());
    }

    @Test
    public void setStudio(){
        film.setStudio(studio2);
        assertEquals(studio2, film.getStudio());
    }

    @Test
    public void hasDirector(){
        assertEquals(director, film.getDirector());
    }

    @Test
    public void setDirector(){
        film.setDirector(director2);
        assertEquals(director2, film.getDirector());
    }

    @Test
    public void hasBudget(){
        assertEquals(10000, film.getBudget());
    }

    @Test
    public void setbudget(){
        film.setBudget(1200);
        assertEquals(1200, film.getBudget());
    }

    @Test
    public void actorsStartsEmpty(){
        assertEquals(0, film.getActors().size());
    }

//    @Test
//    public void addMovie(){
//        actor.addFilm(movie);
//        assertEquals(1, actor.getFilms().size());
//    }
//    commented out undtil movie class created

}
