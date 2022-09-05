package com.bilgeadam.icerikyonetimsistemi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;

import com.bilgeadam.icerikyonetimsistemi.IMPL.DataIMPL;
import com.bilgeadam.icerikyonetimsistemi.repository.entity.User;
import com.bilgeadam.icerikyonetimsistemi.service.UserService;
import com.bilgeadam.icerikyonetimsistemi.utility.HibernateUtils;

public class Runner {

	private static Session session;
	private static org.hibernate.Transaction transaction;
	private static EntityManager entityManager;
	private static CriteriaBuilder builder;

	public static void main(String[] args) {
		DataIMPL dataIMPL = new DataIMPL();
		try {
			dataIMPL.startDataIMPL();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// query01KimEnCokUretmis();
		// query02EnCokSoru();
		// query03BirdenCokİcerikUretenEditor();
		// query04CevaplamaHizi();
		// query05MakaleBaslikIcermeyenler();

	}

	public static void query05MakaleBaslikIcermeyenler() {

		String hql = "Select sd.title, sd.article  from SubjectDetail as sd  ";
		session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> resultList = query.getResultList();

		int counter = 0;
		for (int i = 0; i < resultList.size(); i++) {

			Object[] tempArray = resultList.get(i);
			String tempTitle = (String) tempArray[0];
			String tempArticle = (String) tempArray[1];
			if (!tempArticle.contains(tempTitle)) {
				counter++;
			}
		}
		System.out.println("Makalelerde başlık geçmeyen " + counter + " tane içerik vardır..");

	}

	public static void query04CevaplamaHizi() {

		UserService userService = new UserService();

		String hql = "SELECT user.id  FROM Answers a  ORDER BY (a.createAt- questions.createAt) desc ";
		session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<Long> query = session.createQuery(hql, Long.class);
		List<Long> resultList = query.getResultList();

		Long tempId = resultList.get(0);
		User user = userService.findById(resultList.get(0)).get();
		System.out.println(user.getName() + " " + user.getSurname() + " en hizli sorulari yanitlayan kullanicidir");

	}

	public static void query03BirdenCokİcerikUretenEditor() {

		String hql = "SELECT count(sd) FROM SubjectDetail  AS sd  GROUP BY user.id ";
		session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<Object> query = session.createQuery(hql, Object.class);
		List<Object> resultList = query.getResultList();

		System.out.println(resultList.get(0));

		int counter = 0;
		for (int i = 0; i < resultList.size(); i++) {
			if (resultList.get(i).hashCode() > 1) {
				counter++;
			}
		}
		System.out.println("Birden fazla ders icerigi olusturan " + counter + "editor vardır");
	}

	public static void query02EnCokSoru() {
		String hql = "SELECT subjectDetail.id FROM Questions AS q group by subjectDetail.id order by count(subjectDetail.id) desc ";
		session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<Long> query = session.createQuery(hql, Long.class);
		List<Long> resultList = query.getResultList();
		Long tempId1 = resultList.get(0); // 147 geliyor 2 kez sorulmuş subjectdetail id..

		session.close();
		String hql2 = "SELECT subject.lesson.name FROM SubjectDetail AS sd WHERE sd.id=:key ";
		session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<String> query2 = session.createQuery(hql2, String.class);
		query2.setParameter("key", tempId1);
		List<String> resultList2 = query2.getResultList();
		String lesson = resultList2.get(0);

		System.out.println(lesson + " en çok soru sorulan derstir.");

	}

	public static void query01KimEnCokUretmis() {

		UserService userService = new UserService();

		String hql = "Select user.id from SubjectDetail as sd group by user.id order by count(user.id) desc";
		session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<Long> query = session.createQuery(hql, Long.class);

		List<Long> resultList = query.getResultList();

		User user = userService.findById(resultList.get(0)).get();
		System.out.println("En cok icerik ureten kullanici...: " + user.getName() + " " + user.getSurname());
	}

}
