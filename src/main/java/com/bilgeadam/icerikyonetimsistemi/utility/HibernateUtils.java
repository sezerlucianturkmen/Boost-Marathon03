package com.bilgeadam.icerikyonetimsistemi.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.icerikyonetimsistemi.repository.entity.Answers;
import com.bilgeadam.icerikyonetimsistemi.repository.entity.Lesson;
import com.bilgeadam.icerikyonetimsistemi.repository.entity.Questions;
import com.bilgeadam.icerikyonetimsistemi.repository.entity.Subject;
import com.bilgeadam.icerikyonetimsistemi.repository.entity.SubjectDetail;
import com.bilgeadam.icerikyonetimsistemi.repository.entity.User;

public class HibernateUtils {

	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {
		try {
			Configuration configuration = new Configuration();

			configuration.addAnnotatedClass(Answers.class);
			configuration.addAnnotatedClass(Lesson.class);
			configuration.addAnnotatedClass(Questions.class);
			configuration.addAnnotatedClass(Subject.class);
			configuration.addAnnotatedClass(SubjectDetail.class);
			configuration.addAnnotatedClass(User.class);

			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

			return factory;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}