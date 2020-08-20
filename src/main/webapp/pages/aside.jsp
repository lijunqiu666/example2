<%--
  Created by IntelliJ IDEA.
  User: 12870
  Date: 2020/8/13
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!-- 导航侧栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="../img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p> ${sessionScope.username}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="#"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <!-- 菜单 -->

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-folder"></i> <span>后台通用页面</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="admin-datalist">
                        <%-- 业务起点 --%>
                        <a href="${pageContext.request.contextPath}/users/findAll02.do">
                            <i class="fa fa-circle-o"></i> 用户管理
                        </a>
                    </li>

                </ul>

                <ul class="treeview-menu">

                    <li id="admin-datalist2">
                        <%-- 业务起点 --%>
                        <a href="${pageContext.request.contextPath}/users/findAllOrder.do">
                            <i class="fa fa-circle-o"></i> 订单管理
                        </a>
                    </li>

                </ul>


            </li>

            <!-- 菜单 /-->
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<!-- 导航侧栏 /-->