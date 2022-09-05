package com.bilgeadam.icerikyonetimsistemi.service;

import com.bilgeadam.icerikyonetimsistemi.repository.QuestionsRepository;
import com.bilgeadam.icerikyonetimsistemi.repository.entity.Questions;
import com.bilgeadam.icerikyonetimsistemi.utility.MyFactoryService;

public class QuestionsService extends MyFactoryService<QuestionsRepository, Questions, Long> {

	public QuestionsService() {
		super(new QuestionsRepository());

	}

}
