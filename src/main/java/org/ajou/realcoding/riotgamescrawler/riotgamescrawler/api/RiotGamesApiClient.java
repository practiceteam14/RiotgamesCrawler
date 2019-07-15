package org.ajou.realcoding.riotgamescrawler.riotgamescrawler.api;

import org.springframework.stereotype.Service;

@Service
public class RiotGamesApiClient {

    private final String appid = "RGAPI-ad37473f-771c-4f39-9440-e3ac3fd4c370";
    private final String riotGamesSummonerUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={appid}";
    private final String riotGamesLeagueUrl = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedSummonerId}?api_key={appid}";


    
}
