'use strict';
angular.module('app',[])
.controller('indexcontroller',['$scope',function ($scope) {
    $scope.searchh = function () {
        $.ajax({
            type:'POST',
            dataType:'json',
            contentType:'application/json;charset=UTF-8',
            url:'/stu/select.action'
        }).then(function (result) {
            console.log(angular.toJson(result));
        })
    }
}]);