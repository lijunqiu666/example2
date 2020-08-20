package whut.service.impl;


import whut.bean.Order;
import whut.bean.PageInfo;
import whut.bean.User;
import whut.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whut.service.UserService;

import java.util.List;

// 将当前该类交给Spring管理
@Service
public class UserServiceImpl implements UserService {
    // 从IOC中取出mybatis 实现好的实现类
    // Autowired 自动注入  将类从IOC容器中取出
    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<Order> findAllOrder() {
        return userDao.findAllOrder();
    }

    @Override
    public User login(String username, String password) {
        return userDao.checkUser(username, password);
    }

    @Override
    public void register(String name, String password, int age) {
        userDao.addUser(name, password, age);
    }


    @Override
    public int deleteById(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public int deleteOrderById(int id){
        return userDao.deleteOrderById(id);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public Order findOrderById(int id) {
        return userDao.findOrderById(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }
    @Override
    public int updateOrder(Order order) {
        return userDao.updateOrder(order);
    }

    @Override
    public PageInfo<User> findAllByPage(int page, int size, String username) {
        PageInfo<User> pageInfo = new PageInfo<>();
        // 完善pageinfo 的属性值

        // 指定每页的数据量
        pageInfo.setSize(size);

        // 指定总数据量
        int totalCount = userDao.getTotal(username);
        pageInfo.setTotalCount(totalCount);

        // 指定总页数  Math java中的内置对象    ceil 向上取整   floor 向下取整  round 四舍五入
        int totalPage = (int) Math.ceil((totalCount / (double)size));   // 10 / 3.0 = 3.33
        pageInfo.setTotalPage(totalPage);

        // 判断当前页是否合理
        if (page < 1) {
            pageInfo.setCurrentPage(1);
        } else if (page > totalPage) {
            pageInfo.setCurrentPage(totalPage);
        } else {
            pageInfo.setCurrentPage(page);
        }

        // 指定当前页的数据    实质就是指定sql语句中的两个参数
        int start = (pageInfo.getCurrentPage() - 1) * pageInfo.getSize();
        List<User> list = userDao.findAllByPage(start, pageInfo.getSize(), username);
        pageInfo.setList(list);

        return pageInfo;
    }
    @Override
    public PageInfo<Order> findAllOrderByPage(int page, int size, String username) {
        PageInfo<Order> pageInfo = new PageInfo<>();
        // 完善pageinfo 的属性值

        // 指定每页的数据量
        pageInfo.setSize(size);

        // 指定总数据量
        int totalCount = userDao.getTotalOrder(username);
        pageInfo.setTotalCount(totalCount);

        // 指定总页数  Math java中的内置对象    ceil 向上取整   floor 向下取整  round 四舍五入
        int totalPage = (int) Math.ceil((totalCount / (double)size));   // 10 / 3.0 = 3.33
        pageInfo.setTotalPage(totalPage);

        // 判断当前页是否合理
        if (page < 1) {
            pageInfo.setCurrentPage(1);
        } else if (page > totalPage) {
            pageInfo.setCurrentPage(totalPage);
        } else {
            pageInfo.setCurrentPage(page);
        }

        // 指定当前页的数据    实质就是指定sql语句中的两个参数
        int start = (pageInfo.getCurrentPage() - 1) * pageInfo.getSize();
        List<Order> list = userDao.findAllOrderByPage(start, pageInfo.getSize(), username);
        pageInfo.setList(list);

        return pageInfo;
    }

}
