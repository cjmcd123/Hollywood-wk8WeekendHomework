package db;

import models.Actor;
import models.Film;
import models.FilmGenre;
import models.Studio;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBActor {

    private static Session session;


    public static List<Film> actorFilms(Actor actor) {

        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> results = null;

        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            cr.createAlias("actors", "actor");
            cr.add(Restrictions.eq("actor.id", actor.getId()));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;

    }

    public static List<Film> filmGenre(Actor actor, FilmGenre genre) {

        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> results = null;

        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            cr.add(Restrictions.eq("genre", genre));
            cr.createAlias("actors", "actor");
            cr.add(Restrictions.eq("actor.id", actor.getId()));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;

    }

    public static int genreCount(Actor actor, FilmGenre genre) {

        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> results = null;

        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            cr.add(Restrictions.eq("genre", genre));
            cr.createAlias("actors", "actor");
            cr.add(Restrictions.eq("actor.id", actor.getId()));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results.size();

    }
}
