package db;

import models.Film;
import models.Studio;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBStudio {

    private static Session session;

    public static List<Film> studioFilms(Studio studio) {

        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> results = null;

        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            cr.add(Restrictions.eq("studio", studio));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;

    }
}
