package org.ajou.realcoding.riotgamescrawler.riotgamescrawler.repository;

import org.ajou.realcoding.riotgamescrawler.riotgamescrawler.domain.SummonerLeaguePosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class SummonerLeaguePositionRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    private final String key = "summonerId";

    public void insertSummonerLeaguePosition(SummonerLeaguePosition summonerLeaguePosition) {
        mongoTemplate.insert(summonerLeaguePosition);
    }

    public void updateSummonerLeaguePosition(SummonerLeaguePosition summonerLeaguePosition) {

        Criteria criteria = new Criteria(key);
        criteria.is(summonerLeaguePosition.getSummonerId());

        Query query = new Query(criteria);

        Update update = new Update();

        update.set("queueType", summonerLeaguePosition.getQueueType());
        update.set("summonerName", summonerLeaguePosition.getSummonerName());
        update.set("hotStreak", summonerLeaguePosition.getHotStreak());
        update.set("wins", summonerLeaguePosition.getWins());
        update.set("veteran", summonerLeaguePosition.getVeteran());
        update.set("losses", summonerLeaguePosition.getLosses());
        update.set("rank", summonerLeaguePosition.getRank());
        update.set ("tier", summonerLeaguePosition.getTier());
        update.set("inactive", summonerLeaguePosition.getInactive());
        update.set("freshBlood", summonerLeaguePosition.getFreshBlood());
        update.set("leagueId", summonerLeaguePosition.getLeagueId());
        update.set("summonerId", summonerLeaguePosition.getSummonerId());
        update.set("leaguePoints", summonerLeaguePosition.getLeaguePoints());

        mongoTemplate.updateFirst(query, update, "summonerLeaguePosition");

    }

    public SummonerLeaguePosition currentSummonerLeaguePosition(String encryptedId) {
        Query query = Query.query(Criteria.where("summonerId").is(encryptedId));
        return mongoTemplate.findOne(query, SummonerLeaguePosition.class);
    }
}
