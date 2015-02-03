    <%@ page import="dataAccess.model.LoanType" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="dataAccess.model.GrantConditon" %>
    <%--
      Created by IntelliJ IDEA.
      User: Dotin school 6
      Date: 1/30/2015
      Time: 10:32 AM
      To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <link rel="stylesheet" href="/css/bootstrap.css">
        <script src="/js/bootstrap.min.js"></script>
        <title>شرایط اعطا</title>
    </head>
    <body>
    <div style="height: 70px"></div>
    <div style="margin: auto; width: 800px; padding: 70px 25px 20px 25px; border: solid #ddd 1px; border-radius: 4px;">
        <% String isFirstCondition = (String) request.getAttribute("isFirstCondition");
            if (isFirstCondition.equalsIgnoreCase("false")) {
        %>
        <p class="bg-info">
            کاربر محترم برای ثبت نهایی تسهیلات
            <%=((LoanType) request.getSession().getAttribute("loantype")).getLoanName()%>
            باید بر روی ثبت نهایی کلیک فرمایید در غیر اینصورت هیچ اطلاعاتی ثبت نمی شود.

        </p>
        <table class="table table-hover">
            <thead>
            <tr>
                <th class="text-right">نام</th>
                <th class="text-right">حداکثر مبلغ قرارداد</th>
                <th class="text-right">حداقل مبلغ قرارداد</th>
                <th class="text-right">حداکثر مدت قرارداد</th>
                <th class="text-right">حداقل مدت قرارداد</th>

            </tr>
            </thead>
            <tbody>
            <%
                ArrayList<GrantConditon> grantConditons =
                        (ArrayList<GrantConditon>) ((LoanType) request.getSession().getAttribute("loantype")).getGrantConditons();
                for (GrantConditon grantConditon : grantConditons) {
            %>
            <tr>
                <td style="font-family: 'yekan', Arial !important;"><%=grantConditon.getName()%>
                </td>
                <td><%=grantConditon.getMaxAmountContract()%>
                </td>
                <td><%=grantConditon.getMinAmountContract()%>
                </td>
                <td><%=grantConditon.getMaxDurationContract()%>
                </td>
                <td><%=grantConditon.getMinDurationContract()%>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <br>

        <form method="post" action="/AddAnotherGrandCondition">
            <div class="row">
                <div class="col-xs-2">
                    <input type="text" name="minDuration" class="form-control" required placeholder="حداقل مدت">
                </div>
                <div class="col-xs-2">
                    <input type="text" name="maxDuration" class="form-control" required placeholder="حدکثر مدت">
                </div>
                <div class="col-xs-2">
                    <input type="text" name="minAmount" class="form-control" required placeholder="حداقل مبلغ">
                </div>
                <div class="col-xs-2">
                    <input type="text" name="maxAmount" class="form-control" required placeholder="حداکثر مبلغ">
                </div>
                <div class="col-xs-4">
                    <input type="text" style="font-family: 'yekan', Arial !important;" name="GrandConditionName" class="form-control" required placeholder="نام شرایط">
                </div>
            </div>
            <br>

            <div class="row">
                <div class="col-xs-6"></div>
                <div class="col-xs-3">
                    <a href="/RegisterLoanType" class="btn btn-success btn-block" role="button">ثبت نهایی اطلاعات</a>
                </div>
                <div class="col-xs-3">
                    <input type="submit" value="افزودن شرط دیگر" class="btn btn-primary btn-block">
                </div>

            </div>
        </form>
        <%
        } else {
        %>
        <div class="row">
            <p class="bg-danger"><br>
                کاربر گرامی برای ثبت تسهیلات حدقل یک شرط اعطا باید وجود داشته باشد.
            </p>
            <ul>
                <li>
                    نام تسهیلات:
                    <%=((LoanType) request.getSession().getAttribute("loantype")).getLoanName()%>
                </li>
                <li>
                    نرخ سود تسهیلات به درصد:
                    <%=((LoanType) request.getSession().getAttribute("loantype")).getProfit()%>
                </li>

            </ul>
        </div>
        <form method="post" action="/AddFirstCondition">
            <div class="row">
                <div class="col-xs-2">
                    <input type="text" name="minDuration" class="form-control" required placeholder="حداقل مدت">
                </div>
                <div class="col-xs-2">
                    <input type="text" name="maxDuration" class="form-control" required placeholder="حدکثر مدت">
                </div>
                <div class="col-xs-2">
                    <input type="text" name="minAmount" class="form-control" required placeholder="حداقل مبلغ">
                </div>
                <div class="col-xs-2">
                    <input type="text" name="maxAmount" class="form-control" required placeholder="حداکثر مبلغ">
                </div>
                <div class="col-xs-4">
                    <input type="text" style="font-family: 'yekan', Arial !important;" name="GrandConditionName" class="form-control" required placeholder="نام شرایط">
                </div>
            </div>
            <br>

            <div class="row">
                <div class="col-xs-6"></div>
                <div class="col-xs-3">
                    <button type="button" class="btn btn-warning btn-block" disabled="disabled">ثبت اطلاعات</button>
                </div>
                <div class="col-xs-3">
                    <input type="submit" value="افزودن شرط اول" class="btn btn-primary btn-block">
                </div>

            </div>

        </form>
        <%
            }
        %>
    </div>
    </body>
    </html>
