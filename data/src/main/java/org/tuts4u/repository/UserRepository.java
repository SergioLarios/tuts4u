package org.tuts4u.repository;

import org.tuts4u.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findByMail(String mail);
	
	public User findByUserNameSimple(String userNameSimple);
	
}
