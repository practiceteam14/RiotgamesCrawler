package org.ajou.realcoding.riotgamescrawler.riotgamescrawler.service;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.riotgamescrawler.riotgamescrawler.api.RiotGamesApiClient;
import org.ajou.realcoding.riotgamescrawler.riotgamescrawler.domain.SummonerLeaguePosition;
import org.ajou.realcoding.riotgamescrawler.riotgamescrawler.repository.SummonerLeaguePositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RiotGamesService {
    @Autowired
    RiotGamesApiClient riotGamesApiClient;
    @Autowired
    SummonerLeaguePositionRepository summonerLeaguePositionRepository;

    public String getEncryptedSummonerId(String summonerName) {
        String encryptedSummonerId = riotGamesApiClient.requestSummonerId(summonerName);
        log.info("EncryptedSummonerId : {}", encryptedSummonerId);
        return encryptedSummonerId;
    }

    public SummonerLeaguePosition getLeaguePosition(String summonerName) {
        SummonerLeaguePosition summonerLeaguePosition = riotGamesApiClient.requestSummonerLeaguePosition(getEncryptedSummonerId(summonerName));

        // if league position exist
        if(summonerLeaguePosition != null){
            log.info("SummonerLeaguePosition : {}", summonerLeaguePosition);

            if(getCurrentLeaguePositionFromRepository(summonerName) == null){
                // if not exist in repository, then insert
                log.info("Does not exist in DB, insert");
                summonerLeaguePositionRepository.insertSummonerLeaguePosition(summonerLeaguePosition);
            }
            else {
                // if exist in repository, then update
                log.info("Exist in DB, update");
                summonerLeaguePositionRepository.updateSummonerLeaguePosition(summonerLeaguePosition);
            }
        }
        else {// if league position does not exist
            log.info("Summoner League Position info does not exist");
        }

        return summonerLeaguePosition;
    }

    public SummonerLeaguePosition getCurrentLeaguePositionFromRepository(String summonerName) {
        return summonerLeaguePositionRepository.currentSummonerLeaguePosition(getEncryptedSummonerId(summonerName));
    }
}
