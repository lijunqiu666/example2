package whut.bean;

/**
 * example2
 * 2020/8/16 21:33
 * 角色
 *
 * @author 李俊秋
 **/

public class Role {
    private int id;

    private String rolename;
    private String roleDesc;

    public Role() {
    }

    public Role(int id, String rolename, String roleDesc) {
        this.id = id;
        this.rolename = rolename;
        this.roleDesc = roleDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
