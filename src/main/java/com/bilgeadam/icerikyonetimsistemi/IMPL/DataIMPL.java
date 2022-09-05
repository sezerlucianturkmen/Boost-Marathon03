package com.bilgeadam.icerikyonetimsistemi.IMPL;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;

import com.bilgeadam.icerikyonetimsistemi.repository.entity.Answers;
import com.bilgeadam.icerikyonetimsistemi.repository.entity.ERole;
import com.bilgeadam.icerikyonetimsistemi.repository.entity.Lesson;
import com.bilgeadam.icerikyonetimsistemi.repository.entity.Questions;
import com.bilgeadam.icerikyonetimsistemi.repository.entity.Subject;
import com.bilgeadam.icerikyonetimsistemi.repository.entity.SubjectDetail;
import com.bilgeadam.icerikyonetimsistemi.repository.entity.User;
import com.bilgeadam.icerikyonetimsistemi.service.AnswersService;
import com.bilgeadam.icerikyonetimsistemi.service.LessonService;
import com.bilgeadam.icerikyonetimsistemi.service.QuestionsService;
import com.bilgeadam.icerikyonetimsistemi.service.SubjectDetailService;
import com.bilgeadam.icerikyonetimsistemi.service.SubjectService;
import com.bilgeadam.icerikyonetimsistemi.service.UserService;
import com.bilgeadam.icerikyonetimsistemi.utility.HibernateUtils;

public class DataIMPL {

	private static Session session;
	private static org.hibernate.Transaction transaction;
	private static EntityManager entityManager;
	private static CriteriaBuilder builder;

	private static AnswersService answersService;
	private static LessonService lessonService;
	private static QuestionsService questionsService;
	private static SubjectService subjectService;
	private static SubjectDetailService subjectDetailService;
	private static UserService userService;

	public DataIMPL() {
		super();

		entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		builder = entityManager.getCriteriaBuilder();
		answersService = new AnswersService();
		lessonService = new LessonService();
		questionsService = new QuestionsService();
		subjectService = new SubjectService();
		subjectDetailService = new SubjectDetailService();
		userService = new UserService();

	}

	public static void startDataIMPL() throws InterruptedException {

		// user creation
		User user01 = new User("Sezer", "Turkmen", ERole.EDITOR, new Date(), new Date());
		User user02 = new User("Lucian", "Turkmen", ERole.EDITOR, new Date(), new Date());
		User user03 = new User("Harry", "Potter", ERole.USER, new Date(), new Date());
		User user04 = new User("Ali", "Yılmaz", ERole.USER, new Date(), new Date());
		User user05 = new User("John", "Black", ERole.USER, new Date(), new Date());

		// lesson creation
		Lesson lesson01 = new Lesson("Java", "Elementry level", new Date(), new Date());
		Lesson lesson02 = new Lesson("React", "Advanced level", new Date(), new Date());

		// subject creation
		Subject subject01 = new Subject("FrontEnd nedir?", lesson02, new Date(), new Date());
		Subject subject02 = new Subject("Object Oriented Programming", lesson01, new Date(), new Date());
		Subject subject03 = new Subject("Java Excepiton", lesson01, new Date(), new Date());

		// subjectdetail creation
		SubjectDetail subjectDetail01 = new SubjectDetail(subject03, user01, "try & catch", "Lorem ipsum lorem ipsum",
				"Java", new Date(), new Date());
		SubjectDetail subjectDetail02 = new SubjectDetail(subject02, user01, "finally keyword",
				"Lorem ipsum lorem ipsum", "Java", new Date(), new Date());
		SubjectDetail subjectDetail03 = new SubjectDetail(subject01, user01, "thread", "Lorem ipsum lorem ipsum",
				"Java", new Date(), new Date());
		SubjectDetail subjectDetail04 = new SubjectDetail(subject03, user02, "example 01", "Lorem ipsum lorem ipsum",
				"Java", new Date(), new Date());
		SubjectDetail subjectDetail05 = new SubjectDetail(subject02, user02, "example 02", "Lorem ipsum lorem ipsum",
				"Java", new Date(), new Date());

		// questions creation
		Questions question01 = new Questions(subjectDetail01, user04, "question 01", "how can I do this?", new Date(),
				new Date());
		Questions question02 = new Questions(subjectDetail02, user05, "question 02", "Bu nasıl olacak", new Date(),
				new Date());
		Questions question03 = new Questions(subjectDetail03, user04, "question 03", "Bunu daha iyi nasıl öğenebilirim",
				new Date(), new Date());
		Questions question04 = new Questions(subjectDetail04, user04, "question 04", "how can I do this?", new Date(),
				new Date());
		Questions question05 = new Questions(subjectDetail01, user05, "question 05", "Bu konu nerelerde kullanılır",
				new Date(), new Date());

		// answers creation
		Answers answer01 = new Answers(question01, user01, "You should read check this..", new Date(), new Date());
		Answers answer02 = new Answers(question02, user01, "You should study more..", new Date(), new Date());
		Answers answer03 = new Answers(question03, user02, "You should write codes..", new Date(), new Date());
		Answers answer04 = new Answers(question04, user01, "You should keep practicing", new Date(), new Date());
		Answers answer05 = new Answers(question05, user02, "You should read check this..", new Date(), new Date());

		userService.save(user01);
		userService.save(user02);
		userService.save(user03);
		userService.save(user04);
		userService.save(user05);

		subjectDetailService.save(subjectDetail01);
		subjectDetailService.save(subjectDetail02);
		subjectDetailService.save(subjectDetail03);
		subjectDetailService.save(subjectDetail04);
		subjectDetailService.save(subjectDetail05);

		questionsService.save(question01);
		questionsService.save(question02);
		questionsService.save(question03);
		questionsService.save(question04);
		questionsService.save(question05);

		answersService.save(answer01);
		answersService.save(answer02);
		answersService.save(answer03);
		answersService.save(answer04);
		answersService.save(answer05);

	}

}
