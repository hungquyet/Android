package com.example.tourdulich.model;

import java.util.List;

public class ListData {
    private int type;
    private List<Tour> listTour;
    private List<TourFavorite> listTourFavorite;
    private List<TourHeader> listTourHeader;

    public ListData(int type, List<TourFavorite> listTourFavorite, List<Tour> listTour,List<TourHeader> listTourHeader ) {
        this.type = type;
        this.listTourFavorite = listTourFavorite;
        this.listTour = listTour;
        this.listTourHeader = listTourHeader;

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

    public List<TourFavorite> getListTourFavorite() {
        return listTourFavorite;
    }

    public void setListTourFavorite(List<TourFavorite> listTourFavorite) {
        this.listTourFavorite = listTourFavorite;
    }

    public List<TourHeader> getListTourHeader() {
        return listTourHeader;
    }

    public void setListTourHeader(List<TourHeader> listTourHeader) {
        this.listTourHeader = listTourHeader;
    }
}
