package whut.bean;

/**
 * example2
 * 2020/8/16 21:34
 *
 * @author 李俊秋
 **/

public class UserRole {
   private int id;
    private int userid;
    private int roleid;

    public UserRole() {
    }

    public UserRole(int id, int userid, int roleid) {
        this.id = id;
        this.userid = userid;
        this.roleid = roleid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userid=" + userid +
                ", roleid=" + roleid +
                '}';
    }
}
