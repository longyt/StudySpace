<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <title>图书管理系统</title>
    <link href="/plugs/bootstarp/sidebar.less" rel="stylesheet/less" type="text/css">
    <link href="/plugs/bootstarp/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="/plugs/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular-route.min.js" type="text/javascript"></script>
    <script src="/plugs/angular/angular-ui-router.js" type="text/javascript"></script>
    <script src="/plugs/bootstarp/bootstrap.min.js" type="text/javascript"></script>
</head>
<body class="body-style">
<div>
    <nav class="navbar navbar-default navbar_content">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand top_context" href="#">
                    欢迎来到 图书管理系统
                </a>
            </div>
        </div>
        <div class="tab-navbar">
            <ul class="breadcrumb">
                <li><a href="javascript:void(0)">Home</a></li>
            </ul>
        </div>
    </nav>
    <div class="content" id="nav-content">
        <div id="sidebar" class="sidebar-nav side_div_style">
            <form class="search form-inline">
                <input type="text" class="form-control" style="width: 175px;" placeholder="搜索  ...">
            </form>

        </div>
        <div class="nav-content">
            <iframe id="iframe" width="100%" scrolling="no" onerror="IframeError()"></iframe>
        </div>
    </div>
</div>


</body>
<style>
    #iframe {
        overflow: hidden;
    }

    .body-style {
        overflow: hidden;
    }

    .navbar_content {
        height: 61px;
    }

    .tab-navbar {
        margin-top: 2px;
        margin-left: 9.1%;
        width: 100%;
        height: 28px;
        background-color: #f7f7f7;
    }

    .top_context {
        font-size: 14px;
        color: #5bc0de;
        height: 100%;
    }

    .sidediv_style {
        width: 173px;
        margin-top: 13px;
    }

    .icon_style {
        width: 20px;
        margin-left: 10px;
    }

    .a_style {
        text-decoration-line: none;
        padding-top: 5px;
        padding-bottom: 5px;
        width: 200px;
        padding-right: 59px;
        line-height: 20px;
    }

    .ul_style {
        width: 173px;
    }

    .li_style {
        width: 173px;
    }

    .li_a_style {
        margin-left: 10px;
    }

    .ul_style li a:hover {
        background-color: #c0c3ff;
        border-radius: 10px;
    }

    a:link {
        text-decoration: none;
        cursor: pointer;
    }

    a:visited {
        text-decoration: none;
        cursor: pointer
    }

    a:active {
        text-decoration: none;
        cursor: pointer
    }

    a:hover {
        text-decoration: none;
        cursor: pointer
    }

    .side_div_style {
        width: 9.1%;
        height: 99%;
        background-color: #f7f7f7;
        float: left;
        margin-top: -19px;
    }

    .nav-content {
        width: 90.8%;
        height: 100%;
        background-color: #f1e6ef;
        float: left;
        margin-left: 1px;
        margin-top: 15px;
    }

    .content {
        width: 100%;
        height: 100%;
    }

    .tab-font a {
        color: #1618ff;
    }
</style>

<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            url: "/power/list.action",
            dataType: "json",
            success: function (data) {
                console.log(data.options);
                $.each(data.options, function (k, v) {
                    if (v.optionsPid == "0") {
                        $("#sidebar").append("" +
                            "<div class=\"sidediv_style\">\n" +
                            " <a href=\"#menu_" + v.optionsID + "\"  class=\"nav-header a_style\" data-toggle=\"collapse\"><i\n" +
                            "                class=\"glyphicon glyphicon-book icon_style\"></i>" + v.optionsName + "</a>\n" +
                            "</div>\n" +
                            "<ul id=\"menu_" + v.optionsID + "\" class=\"nav nav-list collapse ul_style\">\n" +
                            "       \n" +
                            "</ul>");
                    } else {
                        $("#menu_" + v.optionsPid).append("<li class=\"li_style\"><a href=\"javascript:void(0)\" onclick='ItemClick(this," + v.optionsPid + ",\"" + v.optionsSrc + "\")' class=\"li_a_style\">" + v.optionsName + "</a></li>");
                    }
                })
            }
        });
        $("#iframe").onload = IframeLoad;
        $("#iframe")[0].src = "/page/home.jsp";
        $("#iframe").height($(window).height());
        $("#nav-content").height($(window).height());

    });

    function ItemClick(value, id, Src) {
        var _this = value;
        var f = true;
        $(".breadcrumb").find("li").each(function () {
            $(this).e
            $(this)[0].removeAttribute("class");//移除所有的class属性
            if ($(_this).text() == $(this).text()) {
                f = false;
                return false;
            }
        });
        if (f) {//没有tab页  添加新的tab页
            $(".breadcrumb").append("<li id='breadcrumb_" + id + "'><a href=\"javascript:void(0)\" onclick='ItemClick(this," + id + ")'>" + $(_this).text() + "</a></li>");
            document.getElementById("breadcrumb_" + id).setAttribute("class", "tab-font");
        } else if (!f) {//已经有tab页
            document.getElementById("breadcrumb_" + id).setAttribute("class", "tab-font");
        }
        //跳转页面
        if (Src == "undefined") {
            $("#iframe").attr("src", "page/error.jsp");
        } else {
            $("#iframe").attr("src", Src);
        }
    }


    function IframeLoad() {
        document.getElementById("iframe").height = 0;
        document.getElementById("iframe").height = document.getElementById("iframe").contentWindow.document.body.scrollHeight;
    }

    function IframeError() {
        console.log("error");
        //$("#iframe").attr("src","Img/500view.jpg");
    }
</script>
</html>