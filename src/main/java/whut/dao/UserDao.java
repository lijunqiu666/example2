package whut.dao;


import org.apache.ibatis.annotations.Param;
import whut.bean.Order;
import whut.bean.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    List<Order> findAllOrder();

    User checkUser(@Param("name") String name, @Param("password") String password);

    int addUser(@Param("name") String name, @Param("password") String password, @Param("age") int age);


    int deleteById(int id);

    User findById(int id);

    Order findOrderById(int id);

    int update(User user);
    int updateOrder(Order order);

    // 分页相关
    int getTotal(String username);

    int getTotalOrder(String username);

    List<User> findAllByPage(@Param("start") int start, @Param("size") int size, @Param("username") String username);

    List<Order> findAllOrderByPage(@Param("start") int start, @Param("size") int size, @Param("username") String username);

    int deleteOrderById(int id);
}
