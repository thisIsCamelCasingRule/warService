package com.example.warService.service;

import com.example.warService.model.Kingdom;
import org.springframework.stereotype.Service;

@Service
public class WarService {
    private final com.example.warService.service.KingdomService kservice;

    public WarService(com.example.warService.service.KingdomService kservice) {
        this.kservice = kservice;
    }

    public boolean war(String kname1, String kname2) {

        Kingdom kingdom1 = kservice.getKingdomByName(kname1);
        Kingdom kingdom2 = kservice.getKingdomByName(kname2);

        double kingdomPower1 = kingdom1.getAmountOfBuildings()*kingdom1.getPopulation() / kingdom1.getPopulation();
        double kingdomPower2 = kingdom2.getAmountOfBuildings()*kingdom2.getPopulation() / kingdom2.getPopulation();

        int prewPopulation1 = kingdom1.getPopulation();
        int prewPopulation2 = kingdom2.getPopulation();

        if(kingdomPower1 > kingdomPower2) {
            kingdom1.setPopulation((kingdom1.getPopulation() / 2) + (int) (Math.random() * (kingdom1.getPopulation() / 2)));
            kingdom1.setAmountOfBuildings(kingdom1.getAmountOfBuildings() + kingdom2.getAmountOfBuildings());
            kingdom1.setSqare(kingdom1.getSqare() + kingdom2.getSqare());

            kingdom2.setPopulation( (kingdom2.getPopulation() / 2 - (int) (Math.random() * (kingdom2.getPopulation() / 2))));

            System.out.println("The Great War is over! Winer is " + kingdom1.getName() + ". The population after war has changed:  " + kingdom1.getPopulation() +"(" + (kingdom1.getPopulation() - prewPopulation1) +") for " + kingdom1.getName() + ", and " + kingdom2.getPopulation() + "(" + (kingdom2.getPopulation() - prewPopulation2) +") for " + kingdom2.getName() + ".");

            kingdom1.setPopulation(kingdom1.getPopulation() + kingdom2.getPopulation());

            kservice.updateKingdom(kingdom1.getName(), kingdom1.getSqare(), kingdom1.getPopulation(), kingdom1.getAmountOfBuildings());

            kservice.deleteKingdomByName(kingdom2.getName());

            return true;
        }
        else if(kingdomPower1 < kingdomPower2) {
            kingdom2.setPopulation((kingdom2.getPopulation() / 2) + (int) Math.random() * (kingdom2.getPopulation() / 2) + (kingdom1.getPopulation() / 2 - (int) Math.random() * (kingdom1.getPopulation() / 2)));
            kingdom2.setAmountOfBuildings(kingdom2.getAmountOfBuildings() + kingdom1.getAmountOfBuildings());
            kingdom2.setSqare(kingdom2.getSqare() + kingdom1.getSqare());

            kingdom1.setPopulation( (kingdom1.getPopulation() / 2 - (int) (Math.random() * (kingdom1.getPopulation() / 2))));

            System.out.println("The Great War is over! Winer is " + kingdom2.getName() + ". The population after war has changed:  " + kingdom2.getPopulation() +"(" + (kingdom2.getPopulation() - prewPopulation2) +") for " + kingdom2.getName() + ", and " + kingdom1.getPopulation() + "(" + (kingdom1.getPopulation() - prewPopulation1) +") for " + kingdom1.getName() + ".");

            kingdom2.setPopulation(kingdom2.getPopulation() + kingdom1.getPopulation());

            kservice.updateKingdom(kingdom2.getName(), kingdom2.getSqare(), kingdom2.getPopulation(), kingdom2.getAmountOfBuildings());

            kservice.deleteKingdomByName(kingdom1.getName());

            return true;
        }
        else {
            kingdom1.setPopulation((kingdom1.getPopulation() / 2) + (int) Math.random() * (kingdom1.getPopulation() / 2));
            kingdom2.setPopulation((kingdom2.getPopulation() / 2) + (int) Math.random() * (kingdom2.getPopulation() / 2));

            System.out.println("The Great War is over! It is a thie. The population after war:  " + kingdom2.getPopulation() +"(" + (kingdom2.getPopulation() - prewPopulation2) +") for " + kingdom2.getName() + ", and " + kingdom1.getPopulation() + "(" + (kingdom1.getPopulation() - prewPopulation1) +") for " + kingdom1.getName() + ".");

            kservice.updateKingdom(kingdom1.getName(), kingdom1.getSqare(), kingdom1.getPopulation(), kingdom1.getAmountOfBuildings());
            kservice.updateKingdom(kingdom2.getName(), kingdom2.getSqare(), kingdom2.getPopulation(), kingdom2.getAmountOfBuildings());

            return true;
        }
    }
}
