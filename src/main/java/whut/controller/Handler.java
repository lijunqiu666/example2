package whut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import whut.bean.Order;
import whut.bean.PageInfo;
import whut.bean.Role;
import whut.bean.User;
import whut.service.RoleService;
import whut.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

// Controller注解 表示当前这个类是一个控制器类  控制器类能够处理请求
@Controller
@RequestMapping("/users")

public class Handler {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    // 表示  当访问到 /users/findAll 就映射到 findAll方法上
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        // ModelAndView  数据视图
        ModelAndView mv = new ModelAndView();
        // 指定视图
        mv.setViewName("index");
        mv.addObject("list", userService.findAll());
        return mv;
    }

    @PostMapping("/login.do")
    public String login(String username, String password, HttpSession session) {
        System.out.println(username + "     " + password);
        // 对用户名以及密码进行校验
        User user = userService.login(username, password);
        if (user == null) {
            System.out.println("登录失败");
            return "pages/failer";
        } else {
            System.out.println("登录成功");
            // 需求   将用户名回显到登录成功的页面上    Session
            // 将用户信息存储到session中
            session.setAttribute("username", username);
            List<Integer> list = roleService.findRoleIdByUsername(username);
            System.out.println(list);
            session.setAttribute("roleIds", list);

            //相当于servlet里面的跳转页面，req.getdispatcher
            return "pages/success";
        }
    }

    @GetMapping("/findAll01.do")
    public ModelAndView index() {
        // 需求分析  将所有用户查询出来 返回至前台页面
        ModelAndView mv = new ModelAndView();
        // 指定视图
        mv.setViewName("pages/datalist");
        // 指定数据
        mv.addObject("list", userService.findAll());
        return mv;
    }


    @GetMapping("/register")
    public String register(String name, String password, int age) {
        System.out.println(name + " " + password);
        //首先判断该用户是否存在
        User user = userService.login(name, password);
        //如果用户不存在,直接插入
        if (user == null) {
            userService.register(name, password, age);

        } else {
            System.out.println("该用户已存在");
        }
        return "pages/login";


    }


    // 预更新操作  跳转到新页面  将当前用户数据进行展示
    @GetMapping("/toUpdate.do")
    public ModelAndView toUpdate(int id) {
        User user = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/user-update");
        mv.addObject("user", user);
        return mv;
    }


    // 更新操作
    @PostMapping("/update.do")
    public String update(User user) {
        int flag = userService.update(user);
        System.out.println(flag);
        //重定向到其他请求，所以要用redirect
        return "redirect:findAll01.do";
    }


    // 带查询条件的分页查询
    /*此时的映射相当于传统jsp里面的web.xml配置路径映射*/
    @RequestMapping("/findAll02.do")
    //这些参数相当于req.getParameter获取，spring会自动去寻找
    public ModelAndView index02(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "0") int flag, String username, HttpSession session) {
        // 判断此次请求是否是条件查询
        if (flag == 1) {
            System.out.println("条件查询");
            session.setAttribute("keywords", username);
        } else {
            System.out.println("不是条件查询");
            session.setAttribute("keywords", null);
        }

        int size = 5;
        PageInfo<User> pageInfo = userService.findAllByPage(currentPage, size, username);
        System.out.println(pageInfo);
        ModelAndView mv = new ModelAndView();
        //指定要跳转到视图
        mv.setViewName("pages/datalist");
        mv.addObject("pageInfo", pageInfo);
        return mv;
    }


    @GetMapping("/delete.do")
    public String delete(int id) {
        userService.deleteById(id);
        // 删除数据之后  需要重新查询全部数据
        // redirect 重定向     转发和重定向之间的区别
        return "redirect:findAll01.do";
    }


    /*8.14添加项：订单管理*/

    @GetMapping("/deleteOrder.do")
    public String deleteOrder(int id) {
        userService.deleteOrderById(id);
        // 删除数据之后  需要重新查询全部数据
        // redirect 重定向     转发和重定向之间的区别
        return "redirect:findAllOrder01.do";
    }

    @RequestMapping("/findAllOrder.do")
    public ModelAndView findOrder(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "0") int flag, String username, HttpSession session) {
        // 判断此次请求是否是条件查询
        if (flag == 1) {
            System.out.println("条件查询");
            session.setAttribute("keywordsGood", username);
        } else {
            System.out.println("不是条件查询");
            session.setAttribute("keywordsGood", null);
        }
        int size = 5;
        PageInfo<Order> pageInfoOrder = userService.findAllOrderByPage(currentPage, size, username);
        System.out.println(pageInfoOrder);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/goodlist");
        mv.addObject("pageInfoOrder", pageInfoOrder);
        return mv;
    }

    @PostMapping("/updateOrder.do")
    public String updateOrder(Order order) {
        int flag = userService.updateOrder(order);
        System.out.println(flag);
        return "redirect:findAllOrder01.do";
    }

    // 预更新操作  跳转到新页面  将当前用户数据进行展示
    @GetMapping("/toUpdateOrder.do")
    public ModelAndView toUpdateOrder(int id) {
//        User user = userService.findById(id);
        Order order = userService.findOrderById(id);
        ModelAndView mv = new ModelAndView();

        mv.setViewName("pages/good-update");
        mv.addObject("order", order);
        return mv;
    }

    @GetMapping("/findAllOrder01.do")
    public ModelAndView indexOrder() {
        // 需求分析  将所有用户查询出来 返回至前台页面
        ModelAndView mv = new ModelAndView();
        // 指定视图
        mv.setViewName("pages/goodlist");
        // 指定数据
        mv.addObject("list", userService.findAllOrder());
        return mv;
    }


    /*8.16 角色权限管理*/
    // 添加角色前置操作
    @GetMapping("/toAddRole.do")
    public ModelAndView toAddRole(String username) {
        // List<Integer> roleIds = roleService.findRoleIdByUsername(username);
        // findRoleByUsername方法 返回了当前用户未拥有的角色信息
//        System.out.println(username);

        List<Role> roles = roleService.findRoleByUsername(username);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/user-role-add");
        mv.addObject("username", username);
        mv.addObject("roles", roles);
        return mv;
    }

    @PostMapping("/addRole.do")
    @ResponseBody
    public String add(String roleList, String userName) {
        System.out.println("执行");
        System.out.println(roleList + " " + userName);
        // "1,2".split(",) ==> "1" "2"
        String[] s = roleList.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s1 : s) {
            list.add(Integer.parseInt(s1));
        }
        roleService.add(list, userName);
        return "";
    }
    //测试


}
