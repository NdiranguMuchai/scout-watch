package com.ndirangu.scoutwatch.dataloader;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.model.Coach;
import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.model.Position;
import com.ndirangu.scoutwatch.repository.ClubRepository;
import com.ndirangu.scoutwatch.repository.CoachRepository;
import com.ndirangu.scoutwatch.repository.PlayerRepository;
import com.ndirangu.scoutwatch.repository.PositionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Dataloader
        implements CommandLineRunner
{
    private final ClubRepository clubRepository;
    private final CoachRepository coachRepository;
    private final PlayerRepository playerRepository;
    private final PositionRepository positionRepository;

    public Dataloader(ClubRepository clubRepository,
                      CoachRepository coachRepository,
                      PlayerRepository playerRepository,
                      PositionRepository positionRepository) {
        this.clubRepository = clubRepository;
        this.coachRepository = coachRepository;
        this.playerRepository = playerRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //creating position
        Position gola = new Position();
        gola.setName("Goal Keeper");
        gola.setAbbreviation("GK");
        Position savedGola = positionRepository.save(gola);

        //position2
        Position centerBack = new Position();
        centerBack.setName("centre back");
        centerBack.setAbbreviation("CB");
         positionRepository.save(centerBack);


        //coach
        Coach sting = new Coach();
        sting.setName("Coach Sido");
        Coach savedSting = coachRepository.save(sting);

        //coach2
        Coach atieri = new Coach();
        atieri.setName("Coach Atieri");
         coachRepository.save(atieri);


        //club
        Club rurie = new Club();
        rurie.setName("Rurie");

        rurie.setCoach(savedSting);

       Club savedRurie = clubRepository.save(rurie);

        //club 2
        Club kiamumbi = new Club();
        kiamumbi.setName("kiamumbi fc");

        kiamumbi.setCoach(atieri);

         clubRepository.save(kiamumbi);

        //player1
        Player dira = new Player();
        dira.setName("dira");

        dira.getPositions().add(savedGola);
        dira.setClub(savedRurie);
        playerRepository.save(dira);

        //player 2
        Player asena = new Player();
        asena.setName("asena");

        asena.getPositions().add(centerBack);
        asena.setClub(kiamumbi);
        playerRepository.save(asena);

    }
}
