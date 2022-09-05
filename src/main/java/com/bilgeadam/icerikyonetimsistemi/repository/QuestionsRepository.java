package com.bilgeadam.icerikyonetimsistemi.repository;

import com.bilgeadam.icerikyonetimsistemi.repository.entity.Questions;
import com.bilgeadam.icerikyonetimsistemi.utility.MyFactoryRepository;

public class QuestionsRepository extends MyFactoryRepository<Questions, Long> {

	public QuestionsRepository() {
		super(new Questions());

	}

}
