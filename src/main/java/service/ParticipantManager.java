package service;

import java.util.ArrayList;
import java.util.List;

import model.Participant;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import output.EventInfoForParticipant;
import output.ParticipantForOrganizer;
import util.HibernateUtil;

public class ParticipantManager {


	@SuppressWarnings("unchecked")

	public List<ParticipantForOrganizer> getAllParticipantsByEventId(int eventId) {
		List<ParticipantForOrganizer> participants = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			participants = session
					.createQuery("select new output.ParticipantForOrganizer(e.login, e.name, e.surname, e.email, t.cost)"
							+ " from Participant p join p.ticket t join p.person e" + " where p.eventId = ?")
					.setInteger(0, eventId).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}

		return participants;
	}

	public boolean saveParticipant(Participant participant) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(participant);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			return false;
		}
		
		return true;
	}

	public boolean checkIfPaidForTicket(String personId) {
		int ifPaidInt;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			ifPaidInt = (Integer) session
					.createQuery("from Participant" + " where personId = ?")
					.setString(0, personId).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}
		if (ifPaidInt == 1)
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<EventInfoForParticipant> getEventsForParticipant(String personId) {
		List<EventInfoForParticipant> events = new ArrayList<EventInfoForParticipant>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			events = (List<EventInfoForParticipant>) session
					.createQuery(
							"select new output.EventInfoForParticipant(t.cost, e.name, e.dateOfEvent, e.subtitle, e.organizer, e.place, e.description, e.picture, e.backgroundFile, e.timeOfEvent)" 
					+ " from Participant p join p.ticket t join p.event e"
									+ " where personId = ?")
					.setString(0, personId).list();
			session.getTransaction().commit();

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return events;

	}

	public boolean checkIfSubscribed(String username, String id) {
		//boolean userSubscribed = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.createQuery("from Participant where personId = "+ username + " and eventid = " + id)
				.uniqueResult();
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			return false;
		}		
		
		
	}
}
