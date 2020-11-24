package com.example.warService.service;

import com.example.warService.model.Kingdom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KingdomService {

    private KingdomService k;
    private final KingdomRepo repos;

    @Autowired
    KingdomService(KingdomRepo repos)
    {
        this.repos = repos;
    }

    public Kingdom addKingdom(String name, double sqare, int population, int amountOfBuildings){
        if(getKingdomByName(name) != null)
        {
            return null;
        }
        else{
            Kingdom new_k = new Kingdom(name, sqare, population, amountOfBuildings);
            repos.save(new_k);
            return new_k;
        }

    }

    public List<Kingdom> allKingdoms(){
        return (List<Kingdom>) repos.findAll();
    }

    public Kingdom getKingdomByName(String name){
        return repos.getKingdomByName(name);
    }

    public boolean deleteKingdomByName(String name){
        Kingdom k = getKingdomByName(name);
        repos.delete(k);
        if(getKingdomByName(name) == null)
        {
            return true;
        }
        else{
            return false;
        }

    }

    public Kingdom updateKingdom(String name, double sqare, int population, int amountOfBuildings){
        if(getKingdomByName(name) != null){
            Kingdom k = getKingdomByName(name);

            k.setAmountOfBuildings(amountOfBuildings);
            k.setPopulation(population);
            k.setSqare(sqare);
            repos.save(k);

            return k;
        }
        else{
            System.out.println("ERROR HAppened here!");
            return null;
        }

    }

    public boolean deleteOperation(List<Kingdom> list){
        if (list.size() == 0) return false;
        int iterator = 0;
        int iterationSize = list.size();

        for (iterator = 0; iterator < iterationSize; iterator++) {
            repos.delete(list.get(iterator));
        }
        return true;
    }

    public boolean deleteAllKingdoms(){
        List<Kingdom> list = (List<Kingdom>) repos.findAll();
        return deleteOperation(list);
    }

}
