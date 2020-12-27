package com.cicadasworld;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SalesData {

    private final StringProperty company = new SimpleStringProperty();
    private final DoubleProperty units = new SimpleDoubleProperty();

    public SalesData() {
        this("", 0.0);
    }

    public SalesData(String company, Double units) {
        setCompany(company);
        setUnits(units);
    }

    public String getCompany() {
        return company.get();
    }

    public StringProperty companyProperty() {
        return company;
    }

    public void setCompany(String company) {
        this.company.set(company);
    }

    public double getUnits() {
        return units.get();
    }

    public DoubleProperty unitsProperty() {
        return units;
    }

    public void setUnits(double units) {
        this.units.set(units);
    }
}
