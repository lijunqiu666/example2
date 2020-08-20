package whut.service;

import whut.bean.Role;

import java.util.List;

public interface RoleService {
    List<Integer> findRoleIdByUsername(String username);
    List<Role> findRoleByUsername(String username);

    void add(List<Integer> list, String username);
}
