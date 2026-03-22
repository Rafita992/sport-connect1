package com.example.sportconnect1.service;

import com.example.sportconnect1.dao.ReservationDAO;
import com.example.sportconnect1.models.Reservation;
import com.example.sportconnect1.models.User;

import java.time.LocalDate;
import java.util.List;

public class ReservationService {
    private ReservationDAO reservationDAO = new ReservationDAO();

    public List<Reservation> getAllReservations(){
        return reservationDAO.getAllReservations();
    }

    public void deleteReservation(Reservation reservation){
        reservationDAO.deleteReservation(reservation);
    }

    public boolean saveReservation(Reservation reservation){
        List<Reservation> reservations = reservationDAO.getReservationByCourtAndDateTime(reservation.getCourt(), reservation.getBookingDate(), reservation.getStartTime());
        if(reservations.isEmpty()){
            reservationDAO.saveReservation(reservation);
            return true;
        } else{
            return false;
        }
    }

    public List<Reservation> getUpcomingReservations(User user, LocalDate date){
        return reservationDAO.getUpComingReservation(user, date);
    }
}
