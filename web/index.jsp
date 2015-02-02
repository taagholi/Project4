<%@ page import="org.hibernate.Session" %>
<%@ page import="dataAccess.util.HibernateUtil" %>
<%@ page import="business.Log" %>
<%--
  Created by IntelliJ IDEA.
  User: Dotin school 6
  Date: 1/28/2015
  Time: 8:05 AM
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <link rel="stylesheet" href="/css/bootstrap.css">
        <script src="/js/bootstrap.min.js"></script>
        <title>پروژه چهارم</title>
    </head>
    <body>
    <div style="margin: auto; width: 350px; padding-top: 70px;">
        <div class="row text-center"><img src="img/logo.png" /></div>
        <%--<div class="row"><a class="btn btn-default btn-lg btn-block" href="#" role="button">افزودن مشتری جدید</a></div>--%>
        <div style="height: 10px"></div>
        <div class="row"><a class="btn btn-default btn-lg btn-block" href="/newLoanType" role="button">افزودن تسهیلات جدید</a></div>
        <div style="height: 10px"></div>
        <div class="row"><a class="btn btn-default btn-lg btn-block" href="/StartNewLoanFile" role="button">افزودن پرونده تسهیلاتی</a></div>
    </div>


    </body>
    </html>
