package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Automobile;

public class HibernateExample implements ListItem {

	public void run() {
		
		//Create the Session factory in which Hibernate actions will be executed.
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Automobile.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		//Once connected to MySQL, say so!
		Start.view.print("connected\n");
		
		
		try {
			session.beginTransaction();
			//Create a new Automobile
			Automobile tempAuto = new Automobile("vinExample", 2020, "Ford", "Model T", "Horseless Carriage", "Black");
			//Add it to the database
			session.save(tempAuto);
			
			
			//Grab the automobile we just created from the database
			@SuppressWarnings("unchecked")	
			List<Automobile> matches = 
					session
						.createQuery("from Automobile a where a.model='Model T'")
						.getResultList();
			
			//Change its color to Black - from Black
			//Delete it from the database
			for(Automobile a : matches) {
				Start.view.print(a.toString() + "\n");
				a.setColor("Black");
				session.delete(a);
			}
			
			
			//Commit the changes
			session.getTransaction().commit();
			
			
		} finally {
			//Close the session
			factory.close();
		}
	}
}