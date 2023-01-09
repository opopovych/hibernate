package ua.lviv.lgs.one_to_many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class Application {
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("/META-INF/hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		Session session = config.buildSessionFactory(serviceRegistry).openSession();

		Post post = new Post();
		post.setTytle("First Post");
		Comment comment1 = new Comment();
		comment1.setAuthorName("Andrii");
		comment1.setPost(post);

		Comment comment2 = new Comment();
		comment2.setAuthorName("Pavel");
		comment2.setPost(post);

		Set<Comment> comments = new HashSet<>();
		comments.add(comment1);
		comments.add(comment2);
		post.setComments(comments);

		Transaction transaction = session.beginTransaction();
		session.save(post);
		transaction.commit();



	}
}
