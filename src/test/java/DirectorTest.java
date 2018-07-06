import models.Director;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectorTest {

    Director director;

    @Before
    public void setUp(){
        director = new Director("Scott Derrickson", 51);
    }

    @Test
    public void hasName(){
        assertEquals("Scott Derrickson", director.getName());
    }

    @Test
    public void setName(){
        director.setName("Scott Derrickson2");
        assertEquals("Scott Derrickson2", director.getName());
    }

    @Test
    public void hasAge(){
        assertEquals(51, director.getAge());
    }

    @Test
    public void setAge(){
        director.setAge(21);
        assertEquals(21, director.getAge());
    }

    @Test
    public void moviesStartsEmpty(){
        assertEquals(0, director.getFilms().size());
    }

//    @Test
//    public void addMovie(){
//        actor.addFilm(movie);
//        assertEquals(1, actor.getFilms().size());
//    }
//    commented out undtil movie class created

}
