package com.igame.controller.admin;

import com.igame.entity.wrapper.GameInfoWrapper;
import com.igame.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-28 17:00
 */
@Controller
@RequestMapping("/admin/game")
public class GameController {

    @Autowired
    GameInfoService gameInfoService;

    @GetMapping("/updgame/{gid}")
    public String toUpdGamePage(@PathVariable("gid")Integer gid,
                                Map<String, Object> map){

        GameInfoWrapper game = gameInfoService.selectByGameId(gid);
        map.put("game", game);

        return "admin/game/gUpdate";
    }


}
