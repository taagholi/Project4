package dataAccess.model;

import dataAccess.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;

public class LoanTypeCRUD {

    public static boolean saveModel(LoanType loanType){
        Session sessionHibernate = HibernateUtil.getSession();
        Transaction transaction = sessionHibernate.beginTransaction();
        sessionHibernate.saveOrUpdate(loanType);
        transaction.commit();
        sessionHibernate.close();
        return true;
    }

    public static ArrayList<LoanType> getAllModels(){
        Session sessionHibernate = HibernateUtil.getSession();
        return (ArrayList<LoanType>) sessionHibernate.createQuery("from LoanType").list();
    }

    public static LoanType getModel(String nameOfLoan){
        Session sessionHibernate = HibernateUtil.getSession();
        Query query = sessionHibernate.createQuery("from LoanType l where l.loanName = :name");
        query.setParameter("name", nameOfLoan);
        return (LoanType) query.list().get(0);

    }
}
