package com.bilgeadam.icerikyonetimsistemi.service;

import com.bilgeadam.icerikyonetimsistemi.repository.AnswersRepository;
import com.bilgeadam.icerikyonetimsistemi.repository.entity.Answers;
import com.bilgeadam.icerikyonetimsistemi.utility.MyFactoryService;

public class AnswersService extends MyFactoryService<AnswersRepository, Answers, Long> {

	public AnswersService() {
		super(new AnswersRepository());

	}

}
