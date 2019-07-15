package org.ajou.realcoding.riotgamescrawler.riotgamescrawler.api;

import org.ajou.realcoding.riotgamescrawler.riotgamescrawler.domain.SummonerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiotGamesApiClient {

    private final String appid = "RGAPI-ad37473f-771c-4f39-9440-e3ac3fd4c370";
    private final String riotGamesSummonerUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={appid}";
    private final String riotGamesLeagueUrl = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedSummonerId}?api_key={appid}";

    @Autowired
    RestTemplate restTemplate;

    public String requestSummonerId(String summonerName){
        return restTemplate.exchange(riotGamesSummonerUrl, HttpMethod.GET, null, SummonerInfo.class, summonerName, appid)
                .getBody().getId();
    }




}
