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

    LoanTypeLogic loanTypeLogic = new LoanTypeLogic();
    CustomerLogic customerLogic = new CustomerLogic();
    LoanFileLogic loanFileLogic = new LoanFileLogic();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getServletPath().equalsIgnoreCase("/StartNewLoanFile")){
            request.setAttribute("Step", "StepGetCustomerNumber");
            request.setAttribute("Msg","");
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoanFile/Step1_CustomerNumber_ChooseLoan.jsp");
            requestDispatcher.forward(request, response);
        }

        else if(request.getServletPath().equalsIgnoreCase("/RetrieveCustomer")){
            long CustomerNumber = Long.parseLong(request.getParameter("CustomerNumber"));
            Customer customer = customerLogic.loadCustomerByID(CustomerNumber);

            if(customer == null){
                request.setAttribute("Step", "StepGetCustomerNumber");
                request.setAttribute("Msg", "کاربر محترم شماره مشتری وارد شده اشتباه میباشد.");
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoanFile/Step1_CustomerNumber_ChooseLoan.jsp");
                requestDispatcher.forward(request, response);
            }else{
                request.setAttribute("Step", "StepChooseLoanType");
                request.getSession().setAttribute("customer", customer);
                request.setAttribute("NamesOfLoanType", loanTypeLogic.loadNameOfLoanType());
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoanFile/Step1_CustomerNumber_ChooseLoan.jsp");
                requestDispatcher.forward(request, response);
            }
        }

        else if(request.getServletPath().equalsIgnoreCase("/DecisionAllocateLoan")){
            long customerID = ((Customer) request.getSession().getAttribute("customer")).getId();
            long trackingNumber = loanFileLogic.decisionAllocate(request.getParameter("loanchosen"), Long.parseLong(request.getParameter("DurationOfUser")),
                    Long.parseLong(request.getParameter("AmountOfUser")) , customerID);
            request.getSession().setAttribute("trackingNumber", trackingNumber);
            response.sendRedirect("LoanFile/StepFinal_ShowResult.jsp");
        }
    }
}
