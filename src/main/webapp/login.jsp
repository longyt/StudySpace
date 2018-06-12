<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/5/24
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>图书管理系统</title>
    <link href="/plugs/bootstarp/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="/plugs/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular-route.min.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular-ui-router.js" type="text/javascript"></script>
    <script src="/plugs/bootstarp/bootstrap.min.js" type="text/javascript"></script>
    <script src="/test/indexcontroller.js" type="text/javascript"></script>
</head>
<body class="bootstrap-admin-without-padding b_image">
<div class="container">
    <div class="row login_center">
        <div class="col-lg-6" style="width: 400px;margin-top: 150px">
            <div class="alert alert-info">
                <a class="close" data-dismiss="alert" href="#">&times;</a>
                欢迎登录图书馆管理系统
            </div>
            <form class="bootstrap-admin-login-form">
                <div class="form-group">
                    <label class="control-label" for="username">账&nbsp;号</label>
                    <input type="text" class="form-control" id="username" placeholder="学号"/>
                    <label class="control-label" for="username" style="display:none;"></label>
                </div>
                <div class="form-group">
                    <label class="control-label" for="password">密&nbsp;码</label>
                    <input type="password" class="form-control" id="password" placeholder="密码"/>
                    <label class="control-label" for="username" style="display:none;"></label>
                </div>
                <input type="button" class="btn btn-lg btn-primary form-control login_button" id="login_submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;录"/>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="modal_info" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="infoModalLabel">提示</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-6" id="div_info"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btn_info_close" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
<style type="text/css">
    .alert{
        margin: 0 auto 20px;
        text-align: center;
    }
    .login_center{
        display: flex;
        justify-content: center;
        align-items: center;
        text-align: center;s
    }
    .b_image{
        background-image: url("Img/michael-d-beckwith-575798-unsplash.jpg");
        background-repeat: no-repeat;
        background-size: 100% 100%;
    }
    .login_button{
        text-align: center;
        display: flex;
        justify-content: center;
    }
</style>
</html>
