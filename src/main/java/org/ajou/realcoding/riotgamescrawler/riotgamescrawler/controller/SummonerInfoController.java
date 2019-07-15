package org.ajou.realcoding.riotgamescrawler.riotgamescrawler.controller;

import org.ajou.realcoding.riotgamescrawler.riotgamescrawler.api.RiotGamesApiClient;
import org.ajou.realcoding.riotgamescrawler.riotgamescrawler.domain.SummonerLeaguePosition;
import org.ajou.realcoding.riotgamescrawler.riotgamescrawler.service.RiotGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummonerInfoController {

    @Autowired
    RiotGamesService riotGamesService;

    // for checking EncryptedSummonerId
    @GetMapping("/riot-games/summoner-info/{summonerName}")
    public String getSummonerId(@PathVariable String summonerName) {
        return riotGamesService.getEncryptedSummonerId(summonerName);
    }

    @GetMapping("/riot-games/summoner-league-position/{summonerName}")
    public SummonerLeaguePosition getSummonerLeaguePosition(@PathVariable String summonerName) {
        return riotGamesService.getLeaguePosition(summonerName);
    }
}
