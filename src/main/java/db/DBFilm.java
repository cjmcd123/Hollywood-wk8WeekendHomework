package db;

import models.Actor;
import models.Director;
import models.Film;
import models.Studio;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFilm {

    private static Session session;

    public static Director filmDirector(Film film) {

        session = HibernateUtil.getSessionFactory().openSession();
        Director director = null;

        try {
            Criteria cr = session.createCriteria(Director.class);
            cr.add(Restrictions.eq("id", film.getDirector().getId()));
            director = (Director) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return director;

    }

    public static Studio filmStudio(Film film) {

        session = HibernateUtil.getSessionFactory().openSession();
        Studio studio = null;

        try {
            Criteria cr = session.createCriteria(Studio.class);
            cr.add(Restrictions.eq("id", film.getStudio().getId()));
            studio = (Studio) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return studio;

    }

    public static List<Actor> filmActors(Film film) {

        session = HibernateUtil.getSessionFactory().openSession();
        List<Actor> results = null;
        try {
            Criteria cr = session.createCriteria(Actor.class);
            cr.createAlias("films", "film");
            cr.add(Restrictions.eq("film.id", film.getId()));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }

    public static void addActor(Film film, Actor actor) {

        film.addActor(actor);
        actor.addFilm(film);
        DBHelper.update(film);

    }
}
