<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html lang="en">
<head>
    <title>权限管理页面</title>
    <link href="/plugs/angular/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="/plugs/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular-route.min.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular-ui-router.js" type="text/javascript"></script>
    <script src="/test/indexcontroller.js" type="text/javascript"></script>
    <script src="/plugs/angular/ui-bootstrap-tpls-1.3.2.js"></script>

</head>
<body>
<div id="content" ng-app="myApp" ng-controller="myPage">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <div class="widget-content" style="padding-top:0px">
                        <form id="permForm" method="post"
                              action="">
                            <div class="row-fluid">


                            </div>
                        </form>
                    </div>

                    <table class="table table-striped">

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
                        <c:forEach items="${powerList}" var="item" varStatus="powerindex">
                            <tbody>
                            <tr>
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
                    <form action="/power/powerlist.action" id="paginationForm">
                    <nav>
                        <input  name="currentSelPage" id="currentSelPage" value="${currentSelPage}">
                        <input  name="PageNum" id="PageNum" value="${PageNum}">
                        <ul class="pagination">
                            <li>
                                <a ng-click="previousPage()">
                                    <span>上一页</span>
                                </a>
                            </li>
                            <li ng-repeat="page in PowerList" ng-class="{active: isSelectPage(page)}">
                                <a ng-click="selectpage(page)">{{ page }}</a>
                            </li>
                            <li>
                                <a ng-click="nextPage()">
                                    <span>下一页</span>
                                </a>
                            </li>
                            <li>
                                <a>每页显示</a>
                                <a>
                                    <select ng-model="PageNum" ng-change="SelectOnChenge()">
                                    <option value="{{item}}" ng-repeat="item in SelectPageList">{{ item }}</option>
                                    </select>
                                </a>
                            </li>
                        </ul>
                    </nav>
                    </form>
                    <!-- 分页显示 -->
                </div>
            </div>
        </div>
    </div>
</div>

<style>
    .pagination li {
        cursor: pointer;
    }
</style>
<script type="text/javascript">
    angular.module('myApp', []).controller('myPage', ['$scope', '$http', function ($scope, $http) {
        $scope.total = "${pageTotal}";
        $scope.currentSelPage = 1;//当前页码数
        $scope.PageNum=5;//当前页码默认展示五条数据
        $scope.TotalPageNum= $scope.total%$scope.PageNum?$scope.total%$scope.PageNum+1:$scope.total/$scope.PageNum ;//计算页面总页数
        $scope.PowerList = [];//遍历 数据 集合
        $scope.SelectPageList=[5,10,15,20,25,30];//Select 集合
        console.log($scope.TotalPageNum);
        for (var i = 0; i < $scope.TotalPageNum; i++) {
            if (i + 1 <= $scope.total ) {
                $scope.PowerList[i] = i + 1;
            }
        }
        $scope.selectpage = function (page) {
            var f=false;
            $scope.currentSelPage=page;//更新当前页码数
            $scope.PowerList = [];
            var index = 0;
            //约束参数
             $scope.start=page-3;
             $scope.end=page+2;
            if(page-3<0){
                $scope.start=0;
            }
            if(page+2>$scope.TotalPageNum){
                $scope.end=$scope.TotalPageNum;
            }
            for (var i = $scope.start; i < $scope.end ; i++) {
                    $scope.PowerList[index] = i + 1;
                    index++;
            }
            f=true;
            return f;
        };
        //设置当前页码样式
        $scope.isSelectPage = function (page) {
            return $scope.currentSelPage == page;
        };
        //下一页
        $scope.nextPage = function(){
            if($scope.currentSelPage+1<= $scope.TotalPageNum){
                var f = $scope.selectpage($scope.currentSelPage+1);
                if(f){
                    $scope.paging($scope.currentSelPage,$scope.PageNum);
                }
            }
            $scope.selectpage($scope.currentSelPage+1);
        };
        //上一页
        $scope.previousPage = function(){
            if($scope.currentSelPage-1>0){
                $scope.selectpage($scope.currentSelPage-1);
            }
        };
        $scope.SelectOnChenge =function(){
            console.log($scope.PageNum);
        };
        //     ---------分页处理-----------
        $scope.paging=function (pagesize,pagenum) {
            console.log(pagesize+"----"+pagenum);
            $("#currentSelPage").val(pagesize);
            $("#PageNum").val(pagenum);
            $("#paginationForm").submit();
        }
    }])
</script>
</body>
</html>