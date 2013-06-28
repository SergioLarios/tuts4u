package org.tuts4u.repository;

import org.tuts4u.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByMail(String mail);
	
}
