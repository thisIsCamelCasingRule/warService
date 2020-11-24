package com.example.warService.model;

import javax.persistence.*;

@Entity
@Table(name = "kingdoms")
public class Kingdom {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;
    private double sqare;
    private int population;
    private int amountOfBuildings;

    public Kingdom(String name, double sqare, int population, int amountOfBuildings) {
        this.name = name;
        this.sqare = sqare;
        this.population = population;
        this.amountOfBuildings = amountOfBuildings;
    }

    public Kingdom() {
    }

    @Column(name = "name", nullable = false)
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "sqare", nullable = false)
    public double getSqare() {
        return sqare;
    }

    public void setSqare(double sqare) {
        this.sqare = sqare;
    }

    @Column(name = "population", nullable = false)
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Column(name="amount_of_buildings", nullable = false)
    public int getAmountOfBuildings() {
        return amountOfBuildings;
    }

    public void setAmountOfBuildings(int amountOfBuildings) {
        this.amountOfBuildings = amountOfBuildings;
    }

}
