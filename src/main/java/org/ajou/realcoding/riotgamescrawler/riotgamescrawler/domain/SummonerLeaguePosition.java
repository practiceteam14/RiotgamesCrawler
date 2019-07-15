package org.ajou.realcoding.riotgamescrawler.riotgamescrawler.domain;

import lombok.Data;

@Data
public class SummonerLeaguePosition {
    private String queueType;
    private String summonerName;
    private Boolean hotStreak;
    private int wins;
    private Boolean veteran;
    private int losses;
    private String rank;
    private String tier;
    private Boolean inactive;
    private Boolean freshBlood;
    private String leagueId;
    private String summonerId;
    private int leaguePoints;
}
