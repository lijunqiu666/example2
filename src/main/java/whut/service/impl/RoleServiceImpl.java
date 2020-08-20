package whut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whut.bean.Role;
import whut.bean.UserRole;
import whut.dao.RoleDao;
import whut.service.RoleService;

import java.util.List;

/**
 * example2
 * 2020/8/16 22:22
 *
 * @author 李俊秋
 **/

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;



    @Override
    public List<Integer> findRoleIdByUsername(String username) {
        return roleDao.findRoleIdByUsername(username);
    }

    @Override
    public List<Role> findRoleByUsername(String username) {
        return roleDao.findRoleByUsername(username);
    }

    @Override
    public void add(List<Integer> list, String username) {
        for (int roleId : list) {
            UserRole userRole = new UserRole();
            userRole.setRoleid(roleId);
            userRole.setUserid(roleDao.getUserId(username));
            roleDao.addRole(userRole);
        }
    }
}
