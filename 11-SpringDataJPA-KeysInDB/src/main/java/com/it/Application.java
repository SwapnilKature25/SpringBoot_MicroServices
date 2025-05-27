package com.it;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.it.entity.Product;
import com.it.repository.ProductRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	 	ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
	 	
	 	ProductRepository productRepo = context.getBean(ProductRepository.class);
//	 	here if we don't set any values for primary key (i.e productId) it will take default values.
	 	Product p=new Product();  // creating object for entity class
	 	// we should not set the value for primary key, because user may enter duplicate values, so for that we need to generate the value for primary key columns, that's where Generator comes into picture
//	 	p.setProductId(102);  // not recommended  
	 	p.setProductName("Mouse");
	 	p.setProductPrice(500.0);   // if not set it will give error : Caused by: java.sql.SQLIntegrityConstraintViolationException: Column 'product_price' cannot be null

	 	productRepo.save(p);
	 	System.out.println("Product inserted...");
		
	}
}


/*
Hibernate: create table product (product_id integer not null, product_name varchar(255), product_price float(53) not null, primary key (product_id)) engine=InnoDB
Hibernate: insert into product (product_name,product_price,product_id) values (?,?,?)
Product inserted...


Hibernate: select p1_0.product_id,p1_0.product_name,p1_0.product_price from product p1_0 where p1_0.product_id=?
Hibernate: insert into product (product_name,product_price,product_id) values (?,?,?)
Product inserted...

Hibernate: insert into product (product_name,product_price) values (?,?)
Product inserted...


 // for AUTO type
 Hibernate: drop table if exists product
Hibernate: drop table if exists product_seq
Hibernate: create table product (product_id integer not null, product_price float(53), product_name varchar(255), primary key (product_id)) engine=InnoDB
Hibernate: create table product_seq (next_val bigint) engine=InnoDB
Hibernate: insert into product_seq values ( 1 )
Hibernate: select next_val as id_val from product_seq for update
Hibernate: update product_seq set next_val= ? where next_val=?
Hibernate: insert into product (product_name,product_price,product_id) values (?,?,?)
Product inserted...
 
 
 // for TABLE type
Hibernate: select tbl.next_val from pid_seq_tbl tbl where tbl.sequence_name=? for update
Hibernate: update pid_seq_tbl set next_val=?  where next_val=? and sequence_name=?
Hibernate: insert into product (product_name,product_price,product_id) values (?,?,?)

 
 
 
*/