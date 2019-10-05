package com.neldale.SpringBoot;

import com.neldale.SpringBoot.dao.UserDao;
import com.neldale.SpringBoot.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		/*ApplicationContext ctx= */
				SpringApplication.run(Application.class, args);
/*			UserDao userDao= ctx.getBean(UserDao.class);
			userDao.save(new User("yalya","$2a$10$b5s//FHbPDmUs6ZN5Z5JOuiAbRhkOPeVaHcjfc6giTWjBXOCli7WG","EL Hadji Yaya","LY","772652363","Kaolack","","","ADMIN"));*/
	}

}
