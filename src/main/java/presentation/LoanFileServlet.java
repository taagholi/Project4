package presentation;

import business.CustomerLogic;
import business.LoanFileLogic;
import business.LoanTypeLogic;
import dataAccess.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoanFileServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getServletPath().equalsIgnoreCase("/StartNewLoanFile")){
            request.setAttribute("Step", "StepGetCustomerNumber");
            request.setAttribute("Msg","");
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoanFile/Step1_Customer_Number_ChooseLoan.jsp");
            requestDispatcher.forward(request, response);
        }

        else if(request.getServletPath().equalsIgnoreCase("/RetrieveCustomer")){
            long CustomerNumber = Long.parseLong(request.getParameter("CustomerNumber"));
            Customer customer = CustomerLogic.loadCustomerByID(CustomerNumber);

            if(customer == null){
                request.setAttribute("Step", "StepGetCustomerNumber");
                request.setAttribute("Msg", "کاربر محترم شماره مشتری وارد شده اشتباه میباشد.");
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoanFile/Step1_Customer_Number_ChooseLoan.jsp");
                requestDispatcher.forward(request, response);
            }else{
                request.setAttribute("Step", "StepChooseLoanType");
                request.getSession().setAttribute("customer", customer);
                request.setAttribute("NamesOfLoanType", LoanTypeLogic.loadNameOfLoanType());
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoanFile/Step1_Customer_Number_ChooseLoan.jsp");
                requestDispatcher.forward(request, response);
            }
        }

        else if(request.getServletPath().equalsIgnoreCase("/DecisionAllocateLoan")){
            request.setCharacterEncoding("UTF-8");
            long customerID = ((Customer) request.getSession().getAttribute("customer")).getId();
            long trackingNumber = LoanFileLogic.decisionAllocate(request.getParameter("loanchosen"), Long.parseLong(request.getParameter("DurationOfUser")),
                    Long.parseLong(request.getParameter("AmountOfUser")) , customerID);
            request.getSession().setAttribute("trackingNumber", trackingNumber);
            response.sendRedirect("LoanFile/StepFinal_Show_Result.jsp");
        }
    }
}
