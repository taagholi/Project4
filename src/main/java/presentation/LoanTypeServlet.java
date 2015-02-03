package presentation;

import business.LoanTypeLogic;
import dataAccess.model.GrantConditon;
import dataAccess.model.LoanType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class LoanTypeServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getServletPath().equalsIgnoreCase("/newLoanType")){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoanType/Step1_Name_LoanType.jsp");
            requestDispatcher.forward(request, response);
        }

        else if(request.getServletPath().equalsIgnoreCase("/InsertFirstGrandCondition")){
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("isFirstCondition", "true");
            LoanType loanType = new LoanType();
            loanType.setLoanName(request.getParameter("NameOfLoan"));
            loanType.setProfit(Long.parseLong(request.getParameter("ProfitOfLoan")));
            request.getSession().setAttribute("loantype",loanType);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoanType/Step2_Add_Condition_LoanType.jsp");
            requestDispatcher.forward(request, response);
        }

        else if(request.getServletPath().equalsIgnoreCase("/AddFirstCondition")){
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("isFirstCondition", "false");
            ArrayList<GrantConditon> grantConditons = new ArrayList<GrantConditon>();
            GrantConditon grantConditon = new GrantConditon();
            grantConditon.setName(request.getParameter("GrandConditionName"));
            grantConditon.setMinAmountContract(Long.parseLong(request.getParameter("minAmount")));
            grantConditon.setMaxAmountContract(Long.parseLong(request.getParameter("maxAmount")));
            grantConditon.setMinDurationContract(Long.parseLong(request.getParameter("minDuration")));
            grantConditon.setMaxDurationContract(Long.parseLong(request.getParameter("maxDuration")));
            grantConditons.add(grantConditon);
            ((LoanType) request.getSession().getAttribute("loantype")).setGrantConditons(grantConditons);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoanType/Step2_Add_Condition_LoanType.jsp");
            requestDispatcher.forward(request, response);
        }


        else if(request.getServletPath().equalsIgnoreCase("/AddAnotherGrandCondition")){
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("isFirstCondition", "false");
            GrantConditon grantConditon = new GrantConditon();
            grantConditon.setName(request.getParameter("GrandConditionName"));
            grantConditon.setMinAmountContract(Long.parseLong(request.getParameter("minAmount")));
            grantConditon.setMaxAmountContract(Long.parseLong(request.getParameter("maxAmount")));
            grantConditon.setMinDurationContract(Long.parseLong(request.getParameter("minDuration")));
            grantConditon.setMaxDurationContract(Long.parseLong(request.getParameter("maxDuration")));
            ((LoanType) request.getSession().getAttribute("loantype")).getGrantConditons().add(grantConditon);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("LoanType/Step2_Add_Condition_LoanType.jsp");
            requestDispatcher.forward(request, response);
        }

        else if(request.getServletPath().equalsIgnoreCase("/RegisterLoanType")){
            LoanTypeLogic.registerLoanType(((LoanType) request.getSession().getAttribute("loantype")));
            request.getSession().removeAttribute("loantype");
            request.getSession().setAttribute("resultOfSaveModel", "success");
            response.sendRedirect("/LoanType/Step3_Result_Creation_LoanType.jsp");

        }

    }
}
