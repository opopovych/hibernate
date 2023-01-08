package hbm.xml;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateXMLConfStarter {
	public static void main(String[] args) {

		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();


		// create
		Cart cart = new Cart("total1","name1");
		Item item1 = new Item("total1");
		Item item2 = new Item("total2");
		Item item3 = new Item("total3");
		Item item4 = new Item("total4");
		cart.setItems(new HashSet<>(Arrays.asList(item1,item2,item3,item4)));
		
		session.persist(cart);

		transaction.commit();
	
		session.close();

	}

}
