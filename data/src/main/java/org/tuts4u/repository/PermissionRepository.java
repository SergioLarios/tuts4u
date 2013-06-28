package org.tuts4u.repository;

import java.util.List;

import org.tuts4u.model.Permission;
import org.tuts4u.model.id.PermissionId;
import org.springframework.data.repository.CrudRepository;


public interface PermissionRepository extends CrudRepository<Permission, PermissionId>{

	List<Permission> findByActionAndTypeLike(String action, int type);
	
	List<Permission> findByType(int type);
}
