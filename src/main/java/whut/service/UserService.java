package whut.service;

import whut.bean.Order;
import whut.bean.PageInfo;
import whut.bean.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<Order> findAllOrder();

    User login(String name, String password);

    void register(String name,String password,int age);
    int deleteById(int id);
    int deleteOrderById(int id);

    User findById(int id);

    Order findOrderById(int id);

    int update(User user);
    int updateOrder(Order order);

    // 分页的全查
//    PageInfo<User> findAllByPage(int page, int size);

    // 条件查询 分页全查
    PageInfo<User> findAllByPage(int page, int size, String username);

    PageInfo<Order> findAllOrderByPage(int page, int size, String username);
}
