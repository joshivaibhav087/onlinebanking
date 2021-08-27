package com.org.security.service;

import java.util.List;

import com.org.security.model.Resource;
import com.org.security.model.ResourcePerm;
//import com.org.security.model.ResourcePermission;
import com.org.security.model.Role;
import com.org.security.model.RolePermission;
import com.org.security.model.User;
import com.org.security.model.User_Role;
import com.org.security.request.PasswordResetRequest;

public interface AccessService {

	
	public Resource addResource(Resource resource);
	
	public Role addRole(Role role);
	
	public RolePermission grantPermissions(RolePermission rolePermission);
	
	public List<RolePermission>  getPermissionsByRoleId(int roleId);
	
	public Role getRoleByRoleID(int roleID);
	
	public Role getByRoleName(String roleName);
	
	public String updatepermissionsByRoleIDAndResourceId( ResourcePerm resourcePerm);
	
	public User getByEmailId(String emailId);
	
	public String deleteResource(int id);
	
	public String deleteRole(int id);
	public String setRole(User_Role userRole);
	public List<Role> getAllRoles();
	public String deleteRoleById(int roleId);

	public List<User> getAllUsers();
	

	String resetPasswordById(String id, PasswordResetRequest passwordResetRequest) throws Exception;
	
	//public forgetPassword(String id)
	
	//public String getPermissionsByRoleName(ResourcePerm resourcePerm);
	
	
	
}
