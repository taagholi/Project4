package business;

import dataAccess.model.LoanType;
import dataAccess.model.LoanTypeCRUD;

import java.util.ArrayList;


public class LoanTypeLogic {

    private LoanTypeCRUD loanTypeCRUD = new LoanTypeCRUD();

    public boolean registerLoanType(LoanType loanType){
        loanTypeCRUD.saveModel(loanType);
        Log.logger.info("New Loan: "+ loanType.getLoanName() + " " + loanType.getProfit() + " "+
        "with ID: " + loanType.getId() + " Saved.");
        return true;
    }

    public ArrayList<String> loadNameOfLoanType(){
        ArrayList<String> names = new ArrayList<String>();
        for (LoanType loanType : loanTypeCRUD.getAllModels()){
            names.add(loanType.getLoanName());
        }
        return names;
    }

}
