package whut.bean;

/**
 * example2
 * 2020/8/15 21:40
 * 订单实体类
 *
 * @author 李俊秋
 **/

public class Order {
    private int id;
    private String username;
    private String good;
    private int cost;
    private int num;

    public Order(){};
    public Order(int id, String username, String good, int cost, int num) {
        this.id = id;
        this.username = username;
        this.good = good;
        this.cost = cost;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", good='" + good + '\'' +
                ", cost=" + cost +
                ", num=" + num +
                '}';
    }
}
