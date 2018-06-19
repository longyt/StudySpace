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
                        <tbody>
                        <tr ng-repeat="item in powerLists">
                            <td>{{item.index+1}}</td>
                            <td>{{item.optionsID}}</td>
                            <td>{{item.optionsName}}</td>
                            <td>{{item.optionsPid}}</td>
                            <td>{{item.optionsSrc}}</td>
                            <td>{{item.optionCreatePer}}</td>
                            <td>{{item.optionUpdatePer}}</td>
                            <td>{{item.optionCreateDate}}</td>
                            <td>{{item.optionUpdateDate}}</td>
                            <td>无</td>
                        </tr>
                        </tbody>
                    </table>
                    <nav>
                        <ul class="pagination">
                            <li>
                                <a ng-click="previousPage()">
                                    <span>上一页</span>
                                </a>
                            </li>
                            <li ng-repeat="page in PowerPageList" ng-class="{active: isSelectPage(page)}">
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
        $scope.powerLists = [];// 数据 遍历
        $scope.PowerPageList = [];//分页 遍历
        $scope.currentSelPage = 1;
        $scope.PageNum = 5;
        $scope.SelectPageList = [5, 10, 15, 20, 25, 30];//Select 选项 遍历
        //查询数据
        var URL = "/power/powerlist.action";
        var config = {
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function (obj) {
                var str = [];
                for (var p in obj) {
                    str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                }
                return str.join("&");
            }
        };
        $scope.Search = function (CurrentPage, PageNum) {
            console.log(CurrentPage + "---" + PageNum);
            $http.post(URL, {
                currentSelPage: CurrentPage,
                PageNum: PageNum
            }, config).then(function successCallback(data) {
                //中心数据
                $scope.powerLists = data.data.powerList;
                //分页展示
                $scope.total = data.data.pageTotal * 1;//总数据量
                $scope.currentSelPage = data.data.currentSelPage * 1;//当前第几页
                $scope.PageNum = data.data.PageNum * 1;//每页展示多少条
                $scope.TotalPageNum = $scope.total % $scope.PageNum ? $scope.total % $scope.PageNum + 1 : $scope.total / $scope.PageNum;//计算页面总页数
                for (var i = 0; i < $scope.TotalPageNum; i++) {
                    if (i + 1 <= $scope.total) {
                        $scope.PowerPageList[i] = i + 1;
                    }
                }
                //分页展示结束
            })
        };

        $scope.Search($scope.currentSelPage, $scope.PageNum);
        //查询数据结束

        //上一页  下一页  点击页码
        $scope.selectpage = function (page) {
            $scope.currentSelPage = page;// 更新当前页码数
            $scope.PowerPageList = [];
            var index = 0;
            //约束参数  不能超过最大页数  不能小于最小页数
            $scope.start = page - 3;
            $scope.end = page + 2;

            if (page - 3 < 0) {
                $scope.start = 0;
            }
            if (page + 2 > $scope.TotalPageNum) {
                $scope.end = $scope.TotalPageNum;
            }
            for (var i = $scope.start; i < $scope.end; i++) {
                $scope.PowerPageList[index] = i + 1;
                index++;
            }
            //改动页码时  查询一遍数据
            $scope.Search($scope.currentSelPage, $scope.PageNum);
        };
        //下一页
        $scope.nextPage = function () {
            if ($scope.currentSelPage + 1 <= $scope.TotalPageNum) {
                $scope.selectpage($scope.currentSelPage + 1);
            }
        };
        //上一页
        $scope.previousPage = function () {
            if ($scope.currentSelPage - 1 > 0) {
                $scope.selectpage($scope.currentSelPage - 1);
            }
        };
        //动态设置当前页码样式
        $scope.isSelectPage = function (page) {
            return $scope.currentSelPage == page;
        };
    }])
</script>
</body>
</html>