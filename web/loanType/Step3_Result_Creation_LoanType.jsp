    <%--
      Created by IntelliJ IDEA.
      User: Dotin school 6
      Date: 1/31/2015
      Time: 8:55 AM
      To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <link rel="stylesheet" href="/css/bootstrap.css">
        <script src="/js/bootstrap.min.js"></script>
        <title>نتیجه</title>
    </head>
    <body>
    <div style="height: 70px"></div>
    <div style="margin: auto; width: 800px; padding: 70px 25px 20px 25px; border: solid #ddd 1px; border-radius: 4px;">
        <%
            if (((String) request.getSession().getAttribute("resultOfSaveModel")).equalsIgnoreCase("success")) {
                request.getSession().removeAttribute("resultOfSaveModel");

        %>
        <div class="row text-center">
            کاربر محترم اطلاعات شما با موفقیت ثبت شد
        </div>
        <div class="row text-center">
            <a href="../index.jsp" class="btn btn-success" role="button">صفحه اصلی</a>
        </div>
        <%
        } else if (((String) request.getSession().getAttribute("resultOfSaveModel")).equalsIgnoreCase("fail")) {
            request.getSession().removeAttribute("resultOfSaveModel");
        %>
        <div class="row text-center">
            کاربر محترم درج اطلاعات شما با مشکل روبرو شد، لطفا بار دیگر امتحان کنید
        </div>
        <div class="row text-center">
            <a class="btn btn-danger" href="../index.jsp" role="button">Link</a>
        </div>
        <%
            } else {
                response.sendRedirect("../index.jsp");
            }
        %>
    </div>
    </body>
    </html>
