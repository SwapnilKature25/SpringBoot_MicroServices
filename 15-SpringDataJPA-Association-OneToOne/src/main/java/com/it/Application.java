package com.it;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.it.entity.Passport;
import com.it.entity.Person;
import com.it.repository.PassportRepository;
import com.it.repository.PersonRepository;

// One to One relation b/w person & passport
@SpringBootApplication
public class Application {

    private final PassportRepository passportRepository;

    Application(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		PersonRepository personRepo = context.getBean(PersonRepository.class);
		PassportRepository passportRepo = context.getBean(PassportRepository.class);
		
//		1
		Person person=new Person();
		person.setPersonName("Swap");
		person.setPersonGender("Male");
		
		Passport passport=new Passport();
		passport.setPassportNum("MK780899");
		passport.setIssuedDate(LocalDate.now());
		passport.setExpiryDate(LocalDate.now().plusYears(10));
		
		person.setPassport(passport);
		passport.setPerson(person);
		
		personRepo.save(person);
		System.out.println("Record inserted...");
		
		
//		2
//		personRepo.findById(1);
//		System.out.println("Record found...");
		
		
//		3 
		personRepo.deleteById(2);  // cascade : whenever you perform operationns on the parent it will reflect on the child also
		System.out.println("Record deleted...");
		
	}

}

/*
// 1
Hibernate: drop table if exists passport
Hibernate: drop table if exists person
Hibernate: create table passport (expiry_date date, issued_date date, passport_id integer not null auto_increment, person_id integer, passport_num varchar(255), primary key (passport_id)) engine=InnoDB
Hibernate: create table person (person_id integer not null auto_increment, person_gender varchar(255), person_name varchar(255), primary key (person_id)) engine=InnoDB
Hibernate: alter table passport add constraint UKa87cemayqfvidyjdviviejms2 unique (person_id)
Hibernate: alter table passport add constraint FK6g8x932c2yca2nmyvmfh6i9g7 foreign key (person_id) references person (person_id)
Hibernate: insert into person (person_gender,person_name) values (?,?)
Hibernate: insert into passport (expiry_date,issued_date,passport_num,person_id) values (?,?,?,?)
Record inserted...

// 2
Hibernate: select p1_0.person_id,p2_0.passport_id,p2_0.expiry_date,p2_0.issued_date,p2_0.passport_num,p1_0.person_gender,p1_0.person_name from person p1_0 left join passport p2_0 on p1_0.person_id=p2_0.person_id where p1_0.person_id=?
Record found...


 */
