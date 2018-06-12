<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html lang="en">
<head>
    <title>权限管理页面</title>
    <link href="/plugs/bootstarp/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="/plugs/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular-route.min.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular-ui-router.js" type="text/javascript"></script>
    <script src="/plugs/bootstarp/bootstrap.min.js" type="text/javascript"></script>
    <script src="/test/indexcontroller.js" type="text/javascript"></script>
</head>
<body>
<div id="content" ng-app="myApp">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <div class="widget-content" style="padding-top:0px">
                        <form id="permForm" method="post"
                              action="">
                            <div class="row-fluid">
                                <div class="n3_span3">
                                    <div class="n3_span3">ID：</div>
                                    <div class="n3_span3">
                                        <input type="text" name="id" value=""/>
                                    </div>
                                </div>
                                <div class="n3_span3">
                                    <div class="n3_span3">Name：{{aaa}}</div>
                                    <div class="n3_span3">
                                        <input type="text" name="userId" value=""/>
                                    </div>
                                </div>
                                <div class="n3_span3">
                                    <div class="n3_span3">PID：</div>
                                    <div class="n3_span3">
                                        <input type="text" name="accountId" value=""/>
                                    </div>
                                </div>
                                <div class="span2">
                                    <button class="btn btn-primary " type="button"
                                            onclick="" data-toggle="modal">搜索
                                    </button>
                                    <button class="btn btn-primary " type="button"
                                            data-toggle="modal" data-target="#myModal">增加
                                    </button>
                                </div>

                            </div>
                        </form>
                    </div>

                    <table class="table " ng-controller="myCtrl" >

                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>optionsID</th>
                            <th>optionsName</th>
                            <th>optionsPid</th>
                            <th>optionsSrc</th>
                            <th>optionCreatePer</th>
                            <th>optionUpdatePer</th>
                            <th>optionCreateDate</th>
                            <th>optionUpdateDate</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <c:forEach items="${result}" var="item" varStatus="powerindex">
                        <tbody>
                        <tr >
                            <td>${powerindex.index+1}</td>
                            <td>${item.optionsID}</td>
                            <td>${item.optionsName}</td>
                            <td>${item.optionsPid}</td>
                            <td>${item.optionsSrc}</td>
                            <td>${item.optionCreatePer}</td>
                            <td>${item.optionUpdatePer}</td>
                            <td>${item.optionCreateDate}</td>
                            <td>${item.optionUpdateDate}</td>
                            <td>无</td>
                        </tr>
                        </tbody>
                        </c:forEach>
                    </table>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>