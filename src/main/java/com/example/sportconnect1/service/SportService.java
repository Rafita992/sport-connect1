package com.example.sportconnect1.service;

import com.example.sportconnect1.dao.SportDAO;
import com.example.sportconnect1.models.Sport;

import java.util.List;

public class SportService {
    private SportDAO sportDAO = new SportDAO();

    public void saveSport(Sport sport){
        sportDAO.saveSport(sport);
    }

    public void deleteSport(Sport sport){
        sportDAO.deleteSport(sport);
    }

    public List<Sport> getAllSports(){
        return sportDAO.getAllSports();
    }
}
