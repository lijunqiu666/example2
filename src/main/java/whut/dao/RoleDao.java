package whut.dao;

import whut.bean.Role;
import whut.bean.UserRole;

import java.util.List;

public interface RoleDao {
    List<Integer> findRoleIdByUsername(String username);

    List<Role> findRoleByUsername(String username);

    int getUserId(String username);

    void addRole(UserRole role);
}
