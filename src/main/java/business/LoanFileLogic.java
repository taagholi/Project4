package business;


import dataAccess.model.*;
import java.util.List;


public class LoanFileLogic {

    private LoanTypeCRUD loanTypeCRUD = new LoanTypeCRUD();
    private LoanFileCRUD loanFileCRUD = new LoanFileCRUD();
    private CustomerCRUD customerCRUD = new CustomerCRUD();


    public long decisionAllocate(String nameOfLoan, long duration, long amount, long customerID) {
        long trackingNumber = -1;
        LoanType loanType = loanTypeCRUD.getModel(nameOfLoan);
        List<GrandCondition> grandConditions = loanType.getGrandConditions();
        for (GrandCondition grandCondition : grandConditions) {
            if (grandCondition.getMinDurationContract() <= duration & grandCondition.getMaxDurationContract() >= duration) {
                if (grandCondition.getMinAmountContract() <= amount & grandCondition.getMaxAmountContract() >= amount) {
                    LoanFile loanFile = new LoanFile();
                    loanFile.setAmountContract(amount);
                    loanFile.setDurationContract(duration);
                    loanFile.setLoanType(loanType);
                    trackingNumber = loanFileCRUD.saveModel(loanFile);
                    customerCRUD.updateCustomer(customerID, loanFile);
                    Log.logger.info("The Loan " + loanType.getLoanName() + " Allocated to Custmoer with id: " + customerID
                    +", And the Loan File ID is:" + loanFile.getId());
                    break;
                }
            }
        }
        return trackingNumber;
    }
}
