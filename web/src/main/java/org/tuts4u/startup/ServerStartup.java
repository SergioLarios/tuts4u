package org.tuts4u.startup;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.tuts4u.data.PermissionTypes;
import org.tuts4u.local.service.PermissionLocalService;
import org.tuts4u.model.Permission;
import org.tuts4u.model.id.PermissionId;
import org.springframework.beans.factory.annotation.Autowired;

public class ServerStartup {

	private static Logger log = Logger.getLogger(ServerStartup.class);
	
	@Autowired
	PermissionLocalService permissionLocalService;
	
	/**
	 * This code gets executed when context is loaded
	 * @return 
	 */
	@PostConstruct
	public void start() {
		
		PermissionId permissionId = new PermissionId("/control-panel/", PermissionTypes.PAGE);
		
		Permission controlPanelPermission = permissionLocalService.findById(permissionId);

		if (controlPanelPermission == null) {
			
			controlPanelPermission = new Permission();
			controlPanelPermission.setAction(permissionId.getAction());
			controlPanelPermission.setType(permissionId.getType());
			controlPanelPermission.setPublic(false);
			
			permissionLocalService.updatePermission(controlPanelPermission);
			
			log.info("Control Panel permission has been added");
		}
		else {
			log.info("Control Panel permission was correctly created");
		}
		
	}

}
