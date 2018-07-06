import models.Actor;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Table;

import static org.junit.Assert.assertEquals;

public class ActorTest {

    Actor actor;

    @Before
    public void setUp(){
        actor = new Actor("Benedict Cumberbatch", 41, 1000);
    }

    @Test
    public void hasName(){
        assertEquals("Benedict Cumberbatch", actor.getName());
    }

    @Test
    public void setName(){
        actor.setName("Benedict Cumberbatch2");
        assertEquals("Benedict Cumberbatch2", actor.getName());
    }

    @Test
    public void hasAge(){
        assertEquals(41, actor.getAge());
    }

    @Test
    public void setAge(){
        actor.setAge(21);
        assertEquals(21, actor.getAge());
    }

    @Test
    public void hasPrice(){
        assertEquals(1000, actor.getPrice());
    }

    @Test
    public void setPrice(){
        actor.setPrice(1200);
        assertEquals(1200, actor.getPrice());
    }

    @Test
    public void moneyStartsEmpty(){
        assertEquals(0, actor.getMoney());
    }

    @Test
    public void setMoney(){
        actor.setMoney(10);
        assertEquals(10, actor.getMoney());
    }

    @Test
    public void moviesStartsEmpty(){
        assertEquals(0, actor.getFilms().size());
    }

//    @Test
//    public void addMovie(){
//        actor.addFilm(movie);
//        assertEquals(1, actor.getFilms().size());
//    }
//    commented out undtil movie class created

}
