<%--
  Created by IntelliJ IDEA.
  User: Dotin school 6
  Date: 1/30/2015
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <script src="/js/bootstrap.min.js"></script>
    <title>تسهیلات جدید</title>
</head>
<body>
<div style="height: 70px"></div>
<div style="margin: auto; width: 400px; padding: 70px 25px 20px 25px; border: solid #ddd 1px; border-radius: 4px;">
<form method="post" action="/InsertFirstGrandCondition">
    <div class="form-group">
        <label for="nameLoan">نام نوع تسهیلات</label>
        <input type="text" style="font-family: 'yekan', Arial !important;" name="NameOfLoan" class="form-control" id="nameLoan" placeholder="نام نوع تسهیلات را وارد کنید." required >
    </div>
    <div class="form-group">
        <label for="profitLoan">نرخ سود</label>
        <input type="text" name="ProfitOfLoan" class="form-control" id="profitLoan" placeholder="نرخ سود تسهیلات را وارد کنید."required >
    </div>
    <input type="submit" value="مرحله بعد" class="btn btn-primary">
</form>
</div>
</body>
</html>
