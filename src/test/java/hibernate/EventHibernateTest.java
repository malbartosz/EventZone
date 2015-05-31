package hibernate;

import org.springframework.util.Assert;

import junit.framework.TestCase;
import model.Event;
import service.EventManager;

/**
 * @author Zu
 *
 */
public class EventHibernateTest extends TestCase {

	public void testAddingEvent() {
		
		Event event = new Event();
		event.setName("newEventName");
		event.setOrganizer("zuzanna");
		event.setPlace("Turew");
		EventManager manager = new EventManager();
			manager.saveEvent(event);
		Assert.notNull(event);
	}
	
}
