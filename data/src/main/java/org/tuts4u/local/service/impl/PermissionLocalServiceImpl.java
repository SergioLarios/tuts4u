package org.tuts4u.local.service.impl;

import java.util.List;

import org.tuts4u.local.service.PermissionLocalService;
import org.tuts4u.model.Permission;
import org.tuts4u.model.id.PermissionId;
import org.tuts4u.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionLocalServiceImpl implements PermissionLocalService{
	

	/* *******************************
	 ******* Implementation **********
	 ****************************** */
	
	@Override
	public Permission updatePermission(Permission entry) {
		return prePermissionRepository.save(entry);
	}

	@Override
	public Permission findById(PermissionId id) {
		return prePermissionRepository.findOne(id);
	}
	
	@Override
	public List<Permission> findByActionAndType(String action, int type) {
		return prePermissionRepository.findByActionAndTypeLike(action, type);
	}
	
	@Override
	public List<Permission> findByType(int type) {
		return prePermissionRepository.findByType(type);
	}

	
	/* *******************************
	 ******** Repositories ***********
	 ****************************** */
	
	private PermissionRepository prePermissionRepository;
	
	/* *******************************
	 ********* Constructor ***********
	 ****************************** */
	
	@Autowired
	public PermissionLocalServiceImpl(PermissionRepository prePermissionRepository) {
		this.prePermissionRepository = prePermissionRepository;
	}

	
}
