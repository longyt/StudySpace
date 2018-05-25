<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<link href="/plugs/bootstarp/sidebar.less" rel="stylesheet/less" type="text/css">
<link href="/plugs/bootstarp/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="/plugs/jquery/jquery.min.js" type="text/javascript"></script>
<script src="/plugs/angular/angular.js" type="text/javascript"></script>
<script src="/plugs/angular/angular-route.min.js" type="text/javascript"></script>
<script src="/plugs/angular/angular-ui-router.js" type="text/javascript"></script>
<script src="/plugs/bootstarp/bootstrap.min.js" type="text/javascript"></script>
<script src="/test/indexcontroller.js" type="text/javascript"></script>
<script type="text/javascript">

    var app=angular.module('app',[]);

    angular.module('app',[])
        .controller('stu',function ($scope) {
            console.log("aaa");
            $scope.searchh = function () {
                $.ajax({
                    type:'POST',
                    dataType:'json',
                    contentType:'application/json;charset=UTF-8',
                    url:'/study01/stu/select.action',
                    success:function (data) {
                        console.log(angular.toJson(data));
                    }
                }).then(function (value) {

                });
            };
           $scope.searchh();
            $("#file").change(function () {
                var filepath=$("#file").val();
                var filepathvalue = filepath.substring(filepath.lastIndexOf("\\")+1,filepath.length);
                $("#filevalue").val(filepathvalue);
            });

            //导入数据
            $scope.importFile=function () {
                var filepath=$("#file").val();
                if(!filepath){
                    alert("请选择导入文件。。");
                    return false;
                }
                var FileSuffix = filepath.substring(filepath.lastIndexOf(".")+1,filepath.length);
                if(FileSuffix!="xlsx"){
                    alert("请导入xlsx格式的文件 。。");
                    return false;
                }

                var formdate = new FormData();
                var file =  $("#file").get(0).files[0];
                formdate.append("file",file);
                $.ajax({
                    url : '/stu/importfile.action',
                    type : 'POST',
                    data : formdate,
                    async : false,
                    cache : false,
                    contentType : false, // 不设置内容类型
                    processData : false, // 不处理数据
                    success : function(data) {

                    }
                });
                $("#myModal").modal('hide');
            }
        });

</script>

<body >
<div ng-app="app">
    <div>
        <!-- Nav -->
        <ul class="nav nav-pills">
            <li role="presentation" class="active"><a>Home</a></li>
            <li role="presentation"><a href="#">Profile</a></li>
            <li role="presentation"><a href="#">Messages</a></li>
        </ul>
        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">批量导入</button>
        <!-- Nav -->
        <div class="table-div"  ng-controller="stu">
            <!-- Table -->
            <table class="table table-striped b-t b-light text-center table-01">
                <thead>
                <tr>
                    <th>id</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>性别</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="item in stuList.data">
                    <td>{{item.id}}</td>
                    <td>{{item.name}}</td>
                    <td>{{item.age}}</td>
                    <td>{{item.sex}}</td>
                </tr>
                </tbody>
            </table>
            <!-- Table -->
            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                        </div>
                        <div class="modal-body">
                           <input type="file" name="file" id="file" style="display: none"/>
                            <div class="form-inline">
                                <label class="control-label" for="file">批量导入</label>
                                <input type="text" id="filevalue" class="form-control" placeholder="选择xlsl文件....."/>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" ng-click="importFile()">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Modal -->
            <!-- new control -->
            <div>
                <a href="/modelmap/jump.action">Jump To  ModelMap</a>
            </div>

            <ul class="nav nav-tabs">
                <li role="presentation" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                        Dropdown <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
            <!-- new control -->
        </div>
    </div>
</div>


</body>


<style type="text/css">
    .table-01{
        width: 89%;
    }
    .table-div{
        width: 100%;
        margin: 0 auto;
    }
</style>


</html>