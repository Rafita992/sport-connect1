package com.example.sportconnect1.service;

import com.example.sportconnect1.dao.CourtDAO;
import com.example.sportconnect1.models.Court;
import com.example.sportconnect1.models.Sport;

import java.util.List;

public class CourtService {
    private CourtDAO courtDAO = new CourtDAO();

    public List<Court> getCourtBySport(Sport sport){
       return courtDAO.getCourtBySport(sport);
    }

    public void saveCourt(Court court){
        courtDAO.saveCourt(court);
    }

    public void deleteCourt(Court court){
        courtDAO.deleteCourt(court);
    }

    public List<Court> getAllCourts(){
        return courtDAO.getAllCourts();
    }
}
