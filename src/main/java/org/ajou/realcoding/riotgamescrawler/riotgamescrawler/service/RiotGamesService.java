package org.ajou.realcoding.riotgamescrawler.riotgamescrawler.service;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.riotgamescrawler.riotgamescrawler.api.RiotGamesApiClient;
import org.ajou.realcoding.riotgamescrawler.riotgamescrawler.domain.SummonerLeaguePosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RiotGamesService {
    @Autowired
    RiotGamesApiClient riotGamesApiClient;
    public String getEncryptedSummonerId(String summonerName) {
        String encryptedSummonerId = riotGamesApiClient.requestSummonerId(summonerName);
        log.info("EncryptedSummonerId : {}", encryptedSummonerId);
        return encryptedSummonerId;
    }

    public SummonerLeaguePosition getLeaguePosition(String summonerName) {
        SummonerLeaguePosition summonerLeaguePosition = riotGamesApiClient.requestSummonerLeaguePosition(getEncryptedSummonerId(summonerName));
        log.info("SummonerLeaguePosition : {}", summonerLeaguePosition);
        return summonerLeaguePosition;
    }
}
