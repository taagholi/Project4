<%@ page import="dataAccess.model.Customer" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <script src="/js/bootstrap.min.js"></script>
    <title>پرونده جدید</title>
</head>
<body>
<div style="height: 70px"></div>
<div style="margin: auto; width: 500px; padding: 70px 25px 20px 25px; border: solid #ddd 1px; border-radius: 4px;">
    <%
        if (((String) request.getAttribute("Step")).equalsIgnoreCase("StepGetCustomerNumber")) {
    %>
    <p class="bg-danger text-center"><%=request.getAttribute("Msg")%>
    </p>

    <form method="post" action="/RetrieveCustomer">
        <div class="row text-center">کاربر محترم لطفا شماره مشتری خود را وارد کنید.</div>
        <br>

        <div class="row">
            <input type="text" style="width: 130px; margin: auto;" size="10" maxlength="10" name="CustomerNumber"
                                            class="form-control" required placeholder="شماره مشتری"></div>
        <br>

        <div class="row text-center"><input type="submit" class="btn btn-success btn-lg" value="بـازیــابی"></div>
    </form>
    <%
    } else if (((String) request.getAttribute("Step")).equalsIgnoreCase("StepChooseLoanType")) {
    %>
    <div>
        <form>
            <fieldset style="width: 250px;" disabled>
                <div class="form-group">
                    <label for="CustomerNumber">شماره مشتری: </label>
                    <input type="text" id="CustomerNumber" class="form-control"
                           style="font-family: 'yekan', Arial !important;"
                           placeholder="<%=((Customer) request.getSession().getAttribute("customer")).getId()%>">
                </div>
                <div class="form-group">
                    <label for="CustomerName">نام مشتری:</label>
                    <input type="text" id="CustomerName" class="form-control"
                           style="font-family: 'yekan', Arial !important;"
                           placeholder="<%=((Customer) request.getSession().getAttribute("customer")).getName()%>">
                </div>
                <div class="form-group">
                    <label for="CustmoerFamily">نام خانوادگی </label>
                    <input type="text" id="CustmoerFamily" class="form-control"
                           style="font-family: 'yekan', Arial !important;"
                           placeholder="<%=((Customer) request.getSession().getAttribute("customer")).getFamily()%>">
                </div>
            </fieldset>
        </form>
    </div>
    <div class="row">
        تسهیلات انتخابی شما:
    </div>
    <form method="post" action="/DecisionAllocateLoan">
        <div class="row">
            <select name="loanchosen" style="font-family: 'yekan', Arial !important; width:150px;" class="form-control">
                <%
                    ArrayList<String> names = (ArrayList<String>) request.getAttribute("NamesOfLoanType");
                    for (String name : names) {
                %>
                <option><%=name%>
                </option>
                <%
                    }
                %>
            </select>
        </div>
        <br>
        <div class="row">
            <div class="col-xs-3"><input type="text" class="form-control" name="AmountOfUser"></div>
            <div class="col-xs-3">مبلغ قرارداد</div>
            <div class="col-xs-3"><input type="text" class="form-control" name="DurationOfUser"></div>
            <div class="col-xs-3">مدت قرارداد</div>
        </div>
        <br>
        <div class="row text-right">
            <input type="submit" class="btn btn-success btn-lg" value="درخواست بررسی">
        </div>
    </form>
    <%
        }
    %>
</div>
</body>
</html>
