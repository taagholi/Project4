package dataAccess.model;

import dataAccess.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class LoanTypeCRUD {

    public static boolean saveModel(LoanType loanType){
        Session sessionHibernate = HibernateUtil.getSession();
        try {
            Transaction transaction = sessionHibernate.beginTransaction();
            sessionHibernate.saveOrUpdate(loanType);
            transaction.commit();
        } finally {
            sessionHibernate.close();
        }

        return true;
    }

    public static ArrayList<LoanType> getAllModels(){
        Session sessionHibernate = HibernateUtil.getSession();
        List<LoanType> loanTypes;
        try {
            loanTypes = sessionHibernate.createQuery("from LoanType").list();
        } finally {
            sessionHibernate.close();
        }
        return (ArrayList<LoanType>) loanTypes;
    }

    public static LoanType getModel(String nameOfLoan){
        Session sessionHibernate = HibernateUtil.getSession();
        LoanType loanType;
            Query query = sessionHibernate.createQuery("from LoanType l where l.loanName = :name");
            query.setParameter("name", nameOfLoan);
            loanType = (LoanType) query.list().get(0);
            Hibernate.initialize(loanType.getGrantConditons());
            sessionHibernate.close();
        return loanType;

    }
}
