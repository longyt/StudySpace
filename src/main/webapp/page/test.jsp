<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/6/14
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/plugs/angular/bootstrap.css">
    <style>
        .page-list .pagination {float:left;}
        .page-list .pagination span {cursor: pointer;}
        .page-list .pagination .separate span{cursor: default; border-top:none;border-bottom:none;}
        .page-list .pagination .separate span:hover {background: none;}
        .page-list .page-total {float:left; margin: 25px 20px;}
        .page-list .page-total input, .page-list .page-total select{height: 26px; border: 1px solid #ddd;}
        .page-list .page-total input {width: 40px; padding-left:3px;}
        .page-list .page-total select {width: 50px;}
    </style>
</head>
<body ng-controller="testController">

<tm-pagination conf="paginationConf"></tm-pagination>

<script src="/plugs/angular/angular.js"></script>
<script src="/plugs/angular/tm.pagination.min.js"></script>
<script>
    angular.module('myApp', ['tm.pagination']).controller('testController', function($scope, $timeout){
        /**
         * I'm not good at English, wish you you catch what I said And help me improve my English.
         *
         * A lightweight and useful pagination directive
         * conf is a object, it has attributes like below:
         *
         * currentPage: Current page number, default 1
         * totalItems: Total number of items in all pages, if you want to get totalItems from ajaxRequest,
         *             you can set the totalItems in onChange function;
         *
         * itemsPerPage:  number of items per page, default 15
         * onChange: when the pagination is change, it will excute the function.
         * pagesLength: number for pagination size, default 9
         * perPageOptions: defind select how many items in a page, default [10, 15, 20, 30, 50]
         *
         */
        $scope.paginationConf = {
            currentPage: 1,
            totalItems: 8000,
            itemsPerPage: 15,
            pagesLength: 15,
            perPageOptions: [10, 20, 30, 40, 50],
            onChange: function(){
            }
        };








    })
</script>
</body>
</html>
