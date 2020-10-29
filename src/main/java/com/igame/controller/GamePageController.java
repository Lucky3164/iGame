package com.igame.controller;

import com.igame.utils.RankListUtil;
import com.igame.entity.GameImages;
import com.igame.entity.GameScore;
import com.igame.entity.Msg;
import com.igame.entity.User;
import com.igame.entity.wrapper.GameInfoWrapper;
import com.igame.service.GameInfoService;
import com.igame.service.GamePicService;
import com.igame.service.ScoreService;
import com.igame.utils.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-14 17:26
 */
@Controller
@RequestMapping("/game")
public class GamePageController {

    @Autowired
    GameInfoService gameInfoService;
    @Autowired
    GamePicService gamePicService;
    @Autowired
    ScoreService scoreService;
    @Autowired
    RankListUtil RankListUtil;


    @GetMapping("/{gameId}")
    public String toGameInfoPage(@PathVariable("gameId")Integer gameId,
                                 Map<String, Object> map){
        User loginUser = LoginUtil.getLoginUser();
        GameInfoWrapper gameInfoWrapper = gameInfoService.selectByGameId(gameId);
        map.put("gameNow", gameInfoWrapper);
        List<GameImages> gameImages = gamePicService.selectByGameId(gameId);
        map.put("gameNowPic", gameImages);
        if (loginUser != null){
            GameScore gameScore = scoreService.selectScoreByGidUid(gameId, loginUser.getUserId());
            map.put("uScore", gameScore);
        }else{
            map.put("uScore", null);
        }
        List<GameInfoWrapper> released = gameInfoService.selectRelease(true, null);
        map.put("released", released);

        return "gamePage";
    }

    @PostMapping("/score")
    @ResponseBody
    public Msg scoreGame(Integer gameId,
                         Float score){
        User loginUser = LoginUtil.getLoginUser();
        if(loginUser == null){
            return  new Msg("400", "未登陆").add("error", "请先登陆");
        }
        int result = scoreService.insertScore(gameId, loginUser.getUserId(), score);
        if(result == -1){
            return new Msg("401", "重复评分").add("error", "您已提交过评分");
        }
//        gameInfoService.delCacheByGid(gameId);
        //List<GameScore> gameScores = scoreService.selectScoreByGid(gameId);
        return new Msg("200", "评分成功").add("tips", "评分成功，可刷新页面查看最新数据");
    }

    @PostMapping("/countviews")
    @ResponseBody
    public Msg countViews(Integer id){

        GameInfoWrapper gameInfoWrapper = gameInfoService.selectByGameId(id);
        RankListUtil.updateViews(gameInfoWrapper, gameInfoWrapper.getViews() + 1);

        return null;
    }

}
