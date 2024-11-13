package com.example.tourdulich.model;

import java.util.List;

public class ListData {
    private int type;
    private List<Tour> listTour;

    public ListData(int type, List<Tour> listTour ){
        this.type = type;
        this.listTour = listTour;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Tour> getListTour() {
        return listTour;
    }

    public void setListTour(List<Tour> listTour) {
        this.listTour = listTour;
    }

}
