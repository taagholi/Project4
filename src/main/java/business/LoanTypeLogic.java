package business;

import dataAccess.model.LoanType;
import dataAccess.model.LoanTypeCRUD;

import java.util.ArrayList;


public class LoanTypeLogic {


    public static boolean registerLoanType(LoanType loanType){
        LoanTypeCRUD.saveModel(loanType);
        Log.logger.info("New Loan: "+ loanType.getLoanName() + " " + loanType.getProfit() + " "+
        "with ID: " + loanType.getId() + " Saved.");
        return true;
    }

    public static ArrayList<String> loadNameOfLoanType(){
        ArrayList<String> names = new ArrayList<String>();
        for (LoanType loanType : LoanTypeCRUD.getAllModels()){
            names.add(loanType.getLoanName());
        }
        return names;
    }

}
