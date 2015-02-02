<%@ page import="dataAccess.model.Customer" %>
<%--
  Created by IntelliJ IDEA.
  User: Dotin school 6
  Date: 1/31/2015
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <link rel="stylesheet" href="/css/bootstrap.css">
        <script src="/js/bootstrap.min.js"></script>
        <title>نتیجه بررسی</title>
    </head>
    <body>
    <div style="height: 70px"></div>

    <div style="margin: auto; width: 500px; padding: 70px 25px 20px 25px; border: solid #ddd 1px; border-radius: 4px;">
        <br>
        <%
            if(request.getSession().getAttribute("trackingNumber").toString().equalsIgnoreCase("-1")){
        %>
        <div class="row text-center">
        کاربر محترم با عرض پوزش با درخواست شما موافقت نشد.
        <br>
        با آرزوی موفقیت
        <br>
        </div>
        <div class="row text-center">
            <div class="col-xs-6 text-right">
            <a href="../index.jsp" class="btn btn-warning btn-lg" role="button">صفحه اصلی</a>
            </div>
            <div class="col-xs-6 text-left">
                <a href="/RetrieveCustomer?CustomerNumber=<%=((Customer)request.getSession().getAttribute("customer")).getId()%>" class="btn btn-info btn-lg" role="button">سعی مجدد</a>
            </div>
        </div>
        <%
            } else{
        %>
        <div class="row text-center">
            کاربر گرامی درخواست شما مورد پذیرش قرار گرفت
        <br>
            شماره پیگیری پرونده شما:
        </div>
        <div class="row text-center">
            <%=request.getSession().getAttribute("trackingNumber").toString()%>
        </div>
        <br>
        <div class="row text-center">
            <a href="../index.jsp" class="btn btn-success btn-lg" role="button">صفحه اصلی</a>
        </div>
        <%
            }
        %>
    </div>
    </body>
    </html>
