import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 借助redis缓存优化提取速度
 */
public class CacheSample {
    public CacheSample(){
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(new Goods(8818,"红富士苹果","好吃的苹果",3.5f));
        goodsList.add(new Goods(8819,"意大利菠萝","好吃的菠萝",20.0f));
        goodsList.add(new Goods(8820,"俄罗斯狗熊","好吃的狗熊",2000.0f));

        //将对象序列为json字符串存入到redis中
        Jedis jedis = new Jedis("localhost",6379);
        try {
            jedis.auth("root");
            jedis.select(3);
            for(Goods goods:goodsList){
                String json = JSON.toJSONString(goods);
                System.out.println(json);
                String key = "goods:" +goods.getGoodsId();
                jedis.set(key,json);
            }
        }catch (Exception e){
            System.out.println("error");
        }finally {
            jedis.close();
        }


    }

    public static void main(String[] args) {
        new CacheSample();
        System.out.println("请输入要查询到额商品编号：");
        String goodsId = new Scanner(System.in).next();
        Jedis jedis = new Jedis("localhost",6379);
        jedis.auth("root");
        jedis.select(3);
        if(jedis.exists("goods:"+goodsId)){
            String json = jedis.get("goods:"+goodsId);
            Goods g = JSON.parseObject(json,Goods.class);
            System.out.println(g);
        }else {
            System.out.println("商品不存在");
        }

    }

}
