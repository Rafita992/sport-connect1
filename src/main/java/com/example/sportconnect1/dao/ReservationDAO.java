package com.example.sportconnect1.dao;

import com.example.sportconnect1.models.Court;
import com.example.sportconnect1.models.Reservation;
import com.example.sportconnect1.models.User;
import com.example.sportconnect1.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    public List<Reservation> getAllReservations(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Reservation> query = session.createQuery("FROM Reservation", Reservation.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveReservation(Reservation reservation){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(reservation);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteReservation(Reservation reservation){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(reservation);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Reservation> getUpComingReservation(User user, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Reservation> query = session.createQuery("FROM Reservation WHERE user = :user AND bookingDate >= :date", Reservation.class);
            query.setParameter("user", user);
            query.setParameter("date", date);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Reservation> getReservationByCourtAndDateTime(Court court, LocalDate date, LocalTime startHour){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Reservation> query = session.createQuery("FROM Reservation WHERE court = :court AND bookingDate = :date AND startTime = :startHour", Reservation.class);
            query.setParameter("court", court);
            query.setParameter("date", date);
            query.setParameter("startTime", startHour);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
