package service;

import java.util.List;

import model.Ticket;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import util.HibernateUtil;

public class TicketManager {
	
    public Ticket getTicketByEventId(int id)
    {
    	Ticket ticket = null;

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
        	ticket = (Ticket) session.createQuery(
                    "from Ticket" + " where eventid = ?").setInteger(0,
                    id).uniqueResult();
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }

        return ticket;
    }
    
    
    public void saveTicket(Ticket ticket)
    {
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
            session.saveOrUpdate(ticket);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }
    }

	public Ticket getTicketById(int id) {
		Ticket ticket = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			ticket = (Ticket) session
					.createQuery("from Ticket" + " where id = ?")
					.setInteger(0, id).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}

		return ticket;
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> getTicketsByEventId(int id) {
		List<Ticket> tickets = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			tickets = session.createQuery("from Ticket" + " where eventId = ?")
					.setInteger(0, id).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}

		return tickets;
	}

}
