package service;

import java.util.ArrayList;
import java.util.List;

import model.Event;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Zu
 *
 */
public class EventManager {
	
	
	
	public Event getEventById(int id){
		Event event = new Event();
		
		Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
       // long myid = Integer.parseInt(id);
        try
        {
        	event = (Event) session
					.createQuery("from Event" 
							+ " where id = ?").setLong(0, id).uniqueResult();

			session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }
		
		return event;
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> getAllEventsInDataBase(){
		List<Event> allEvents = new ArrayList<Event>();
		
		Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
        	allEvents = (List<Event>) session
					.createQuery("from Event").list();
			session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }
		
		return allEvents;
	}
	
    @SuppressWarnings("unchecked")
	public List<Event> getAllEventsByOrganizer(String organizer)
    {
    	List<Event> events = new ArrayList<Event>();

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
        	events = (List<Event>) session
					.createQuery(
							"from Event "
									+ " where organizer = ?")
					.setString(0, organizer).list();
			session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }

        return events;
    }
    
    public int getMaxEventId()
    {
    	int maxId;

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
        	maxId = (int) session
					.createQuery(
							"select max(id) from Event ").uniqueResult();
			session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }

        return maxId;
    }

    public void saveEvent(Event event)
    {
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
            session.saveOrUpdate(event);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }
    }

	public boolean isUserTheOrganizer(String username,String id) {
		Event event = getEventById(Integer.parseInt(id));
		if(event.getOrganizer().equals(username))
			return true;
		return false;
	}
    
   
}
