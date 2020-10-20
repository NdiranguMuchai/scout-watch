package com.ndirangu.scoutwatch.dataloader;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.model.Coach;
import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.model.Position;
import com.ndirangu.scoutwatch.service.ClubService;
import com.ndirangu.scoutwatch.service.CoachService;
import com.ndirangu.scoutwatch.service.PlayerService;
import com.ndirangu.scoutwatch.service.PositionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Dataloader implements CommandLineRunner {
    private final ClubService clubService;
    private final CoachService coachService;
    private final PlayerService playerService;
    private final PositionService positionService;


    public Dataloader(ClubService clubService,
                      CoachService coachService,
                      PlayerService playerService,
                      PositionService positionService) {
        this.clubService = clubService;
        this.coachService = coachService;
        this.playerService = playerService;
        this.positionService = positionService;
    }

    @Override
    public void run(String... args) throws Exception {
        //creating position
        Position gola = new Position();
        gola.setName("right back");
        gola.setAbbreviation("RB");
        UUID savedGolaId = positionService.create(gola);

        //position2
        Position centerBack = new Position();
        centerBack.setName("centre back");
        centerBack.setAbbreviation("CB");
         positionService.create(centerBack);


        //coach
        Coach sting = new Coach();
        sting.setName("Coach Sido");
        UUID savedStingId = coachService.create(sting);

        //coach2
        Coach atieri = new Coach();
        atieri.setName("Coach Atieri");
         coachService.create(atieri);


        //club
        Club waleWasee = new Club();
        waleWasee.setName("Rurie");

        waleWasee.setCoach(coachService.findOne(savedStingId).orElseThrow(()-> new Exception("Sting not found")));

        UUID savedWaleeWaseeId = clubService.create(waleWasee);

        //club 2
        Club kiamumbi = new Club();
        kiamumbi.setName("kiamumbi fc");

        kiamumbi.setCoach(atieri);

         clubService.create(kiamumbi);

        //player1
        Player dira = new Player();
        dira.setName("drogba");

        dira.getPositions().add(positionService.findOne(savedGolaId).orElseThrow(()-> new Exception("Gola not found")));
        dira.setClub(clubService.findOne(savedWaleeWaseeId).orElseThrow(()-> new Exception("Wale wasee not found")));
        playerService.create(dira);

        //player 2
        Player asena = new Player();
        asena.setName("asena");

        asena.getPositions().add(centerBack);
        asena.setClub(kiamumbi);
        playerService.create(asena);

    }
}
