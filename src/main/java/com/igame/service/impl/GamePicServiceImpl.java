package com.igame.service.impl;

import com.igame.entity.GameImages;
import com.igame.mapper.GameImagesMapper;
import com.igame.service.GamePicService;
import com.igame.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-15 8:29
 */
@Service
public class GamePicServiceImpl implements GamePicService {

    @Resource
    GameImagesMapper gameImagesMapper;
    @Autowired
    RedisTemplate<String, GameImages> redisTemplate;
    @Autowired
    RedisUtil redisUtil;

    @Override
//    @Cacheable(value = "pic")
    public List<GameImages> selectByGameId(Integer gameId) {
//        List<GameImages> gameImages = null;
//        if(redisTemplate.hasKey("pic_" + gameId)){
//            System.out.println("Select from cache :: pic_" + gameId);
//            Set<GameImages> members = redisTemplate.opsForSet().members("pic_" + gameId);
//            gameImages = new ArrayList<>(members);
//        }else{
//            System.out.println("Select from sql :: pic_" + gameId);
//            gameImages = gameImagesMapper.selectByGameId(gameId);
//            for (GameImages gameImage : gameImages) {
//                redisTemplate.opsForSet().add("pic_" + gameId, gameImage);
//            }
//        }
//        return gameImages;


//        Map<Object, Object> hgetall = redisUtil.hgetall("gid_" + gameId);
//        if (!hgetall.isEmpty()){
//            System.out.println("select from cache :: gid_" + gameId);
//            for (Map.Entry<Object, Object> entry : hgetall.entrySet()) {
//                System.out.println(entry.getValue());
//            }
//        }else{
//            System.out.println("select from sql :: gid_" + gameId);
//            List<GameImages> gameImages = gameImagesMapper.selectByGameId(gameId);
//            for (GameImages gameImage : gameImages) {
//                redisUtil.hset("gid_" + gameId, "pic_" + gameImage.getImageId() , JSON.toJSONString(gameImage));
//            }
//        }


        return gameImagesMapper.selectByGameId(gameId);
    }
}
