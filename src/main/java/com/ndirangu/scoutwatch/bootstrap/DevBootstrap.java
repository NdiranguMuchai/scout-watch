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
        Country home = Country.KENYA;
        Coach ghost = new Coach("ghost", "mulei",home);
        Player msee = new Player("ule", "msee", "CAM", "20,000", home);
        Club highlanders = new Club("arsenal",ghost);
        msee.getClub().add(highlanders);
        highlanders.getPlayers().add(msee);

        coachRepository.save(ghost);
        playerRepository.save(msee);
        clubRepository.save(highlanders);

    }
}
