package com.ndirangu.scoutwatch.bootstrap;

import com.ndirangu.scoutwatch.model.Club;
import com.ndirangu.scoutwatch.model.Coach;
import com.ndirangu.scoutwatch.model.Country;
import com.ndirangu.scoutwatch.model.Player;
import com.ndirangu.scoutwatch.repostiory.ClubRepository;
import com.ndirangu.scoutwatch.repostiory.CoachRepository;
import com.ndirangu.scoutwatch.repostiory.PlayerRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private PlayerRepository playerRepository;
    private ClubRepository clubRepository;
    private CoachRepository coachRepository;

    public DevBootstrap(PlayerRepository playerRepository, ClubRepository clubRepository, CoachRepository coachRepository) {
        this.playerRepository = playerRepository;
        this.clubRepository = clubRepository;
        this.coachRepository = coachRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
initData();
    }
    private void initData(){
        //COUNTRIES
        Country home = Country.KENYA;

        //COACHES
        Coach ghost = new Coach("ghost", "mulei",home);
        Coach matano = new Coach("robert", "matano", home);
        coachRepository.save(ghost);
        coachRepository.save(matano);

        //CLUB
        Club highlanders = new Club("highlanders", home);

        //PLAYER
        Player mnona = new Player("striker", "mnoma","CF", "20000", home);
        Player beki = new Player("beki wa", "kupanda na kushuka","LB", "150000", home);
        mnona.setClub(highlanders);
        beki.setClub(highlanders);
        clubRepository.save(highlanders);
        playerRepository.save(mnona);
        playerRepository.save(beki);





    }
}
