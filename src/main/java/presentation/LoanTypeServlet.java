package presentation;

import business.LoanTypeLogic;
import dataAccess.model.GrandCondition;
import dataAccess.model.LoanType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class LoanTypeServlet extends HttpServlet {
    private LoanTypeLogic loanTypeLogic = new LoanTypeLogic();
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getServletPath().equalsIgnoreCase("/newLoanType")){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoanType/Step1_NameOfLoanType.jsp");
            requestDispatcher.forward(request, response);
        }

        else if(request.getServletPath().equalsIgnoreCase("/InsertFirstGrandCondition")){
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("isFirstCondition", "true");
            LoanType loanType = new LoanType();
            loanType.setLoanName(request.getParameter("NameOfLoan"));
            loanType.setProfit(Long.parseLong(request.getParameter("ProfitOfLoan")));
            request.getSession().setAttribute("loantype",loanType);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoanType/Step2_AddConditionToLoanType.jsp");
            requestDispatcher.forward(request, response);
        }

        else if(request.getServletPath().equalsIgnoreCase("/AddFirstCondition")){
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("isFirstCondition", "false");
            ArrayList<GrandCondition> grandConditions = new ArrayList<GrandCondition>();
            GrandCondition grandCondition = new GrandCondition();
            grandCondition.setName(request.getParameter("GrandConditionName"));
            grandCondition.setMinAmountContract(Long.parseLong(request.getParameter("minAmount")));
            grandCondition.setMaxAmountContract(Long.parseLong(request.getParameter("maxAmount")));
            grandCondition.setMinDurationContract(Long.parseLong(request.getParameter("minDuration")));
            grandCondition.setMaxDurationContract(Long.parseLong(request.getParameter("maxDuration")));
            grandConditions.add(grandCondition);
            ((LoanType) request.getSession().getAttribute("loantype")).setGrandConditions(grandConditions);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoanType/Step2_AddConditionToLoanType.jsp");
            requestDispatcher.forward(request, response);
        }


        else if(request.getServletPath().equalsIgnoreCase("/AddAnotherGrandCondition")){
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("isFirstCondition", "false");
            GrandCondition grandCondition = new GrandCondition();
            grandCondition.setName(request.getParameter("GrandConditionName"));
            grandCondition.setMinAmountContract(Long.parseLong(request.getParameter("minAmount")));
            grandCondition.setMaxAmountContract(Long.parseLong(request.getParameter("maxAmount")));
            grandCondition.setMinDurationContract(Long.parseLong(request.getParameter("minDuration")));
            grandCondition.setMaxDurationContract(Long.parseLong(request.getParameter("maxDuration")));
            ((LoanType) request.getSession().getAttribute("loantype")).getGrandConditions().add(grandCondition);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoanType/Step2_AddConditionToLoanType.jsp");
            requestDispatcher.forward(request, response);
        }

        else if(request.getServletPath().equalsIgnoreCase("/RegisterLoanType")){
            loanTypeLogic.registerLoanType(((LoanType) request.getSession().getAttribute("loantype")));
            request.getSession().removeAttribute("loantype");
            request.getSession().setAttribute("resultOfSaveModel", "success");
            response.sendRedirect("/LoanType/Step3_ResultOfCreationLoanType.jsp");

        }

    }
}
