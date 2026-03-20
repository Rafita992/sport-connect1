package com.example.sportconnect1.dao;

import com.example.sportconnect1.models.Court;
import com.example.sportconnect1.models.Sport;
import com.example.sportconnect1.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CourtDAO {

    public List<Court> getAllCourts(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Court> query = session.createQuery("FROM Court", Court.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveCourt(Court court){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(court);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteCourt(Court court){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(court);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Court> getCourtBySport(Sport sport){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Court> query = session.createQuery("FROM Court WHERE sport = :sport", Court.class);
            query.setParameter("sport", sport);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
