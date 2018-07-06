import models.Director;
import models.Film;
import models.FilmGenre;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudioTest {

    Studio studio;

    @Before
    public void setUp(){
        studio = new Studio("Marvel Studio");
    }

    @Test
    public void hasName(){
        assertEquals("Marvel Studio", studio.getName());
    }

    @Test
    public void setName(){
        studio.setName("Marvel Studio2");
        assertEquals("Marvel Studio2", studio.getName());
    }


    @Test
    public void moviesStartsEmpty(){
        assertEquals(0, studio.getFilms().size());
    }

    @Test
    public void addMovie(){
        Director director = new Director("Scott Derrickson", 51);
        Film film = new Film("Doctor Strange", 2016, FilmGenre.ACTION, studio, director, 10000);
        studio.addFilm(film);
        assertEquals(1, studio.getFilms().size());
    }
//    commented out until movie class created

}
