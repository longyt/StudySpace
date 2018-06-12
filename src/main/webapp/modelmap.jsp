<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="/plugs/bootstarp/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="/plugs/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular-route.min.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular-ui-router.js" type="text/javascript"></script>
    <script src="/plugs/bootstarp/bootstrap.min.js" type="text/javascript"></script>
    <script src="/test/indexcontroller.js" type="text/javascript"></script>
</head>
<body>
    <button class="form-control">aa</button>
    <input type="text" class="form-control" onkeyup="Test(this)" value=""/>
</body>
    <script type="text/javascript">
            $(function () {
                console.log("kkk");
                $.ajax({
                    url:"/modelmap/select.action",
                    dataType:"json",
                    method:"POST",
                    success:function (data) {
                            console.log(data.resMsg);

                    }
                });
            })

        function Test(obj) {
            console.log(obj.value);
            obj.value=obj.value.replace(/\d+\.\d{3}/g,function (params) {
                alert("aa"+params.substr(0,params.indexOf(".")+3));
                return value.substr(0,params.indexOf(".")+3);
            });
        }
    </script>

</html>