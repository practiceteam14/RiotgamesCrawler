package org.ajou.realcoding.riotgamescrawler.riotgamescrawler.controller;

import org.ajou.realcoding.riotgamescrawler.riotgamescrawler.api.RiotGamesApiClient;
import org.ajou.realcoding.riotgamescrawler.riotgamescrawler.service.RiotGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SummonerInfoController {
    @Autowired
    RiotGamesService riotGamesService;

    @GetMapping("/riot-games/summoner-info/{summonerName}")
    public String getSummonerId(@PathVariable String summonerName) {
        return riotGamesService.getEncryptedSummonerId(summonerName);
    }
}
