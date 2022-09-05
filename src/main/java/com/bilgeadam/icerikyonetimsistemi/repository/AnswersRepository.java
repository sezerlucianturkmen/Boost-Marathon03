package com.bilgeadam.icerikyonetimsistemi.repository;

import com.bilgeadam.icerikyonetimsistemi.repository.entity.Answers;
import com.bilgeadam.icerikyonetimsistemi.utility.MyFactoryRepository;

public class AnswersRepository extends MyFactoryRepository<Answers, Long> {

	public AnswersRepository() {
		super(new Answers());

	}

}
