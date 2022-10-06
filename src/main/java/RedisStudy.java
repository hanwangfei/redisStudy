/**
 * 1. redis是基于key-value的Nosql数据库,redis可以简单的认为是一个超大型的map
 * 2. redis将数据存储到内存(ram)中，但是也可以持久化到磁盘
 * 3. redis常用于缓存，提高程序的处理速度
 * 4. redis的特点： 《1 速度快  《2 广泛的语言支持   《3 提供持久化，一种叫rdb，基于全量的备份，一种叫aof，基于日志的更新
 *                《4  支持多种数据结构        《5 主从复制    《6 分布式与高可用（哨兵机制）
 * 5. 启动windows版的redis,进入redis解压缩目录，输入 redis-server redis.windows.conf启动,默认占用6379端口
 *
 */

/**
 * redis常用基本配置：（前往redis.windows.conf文件进行修改）
 *   命令           示例                                 说明
 * daemonize    daemonize yes                       是否启用后台运行，默认no(windows版本暂不支持进行修改)
 * port         port 6379                           设置端口号，默认6379
 * logfile      logfile 日志文件                     设置日志文件
 * databases    databases 255                       设置redis数据库总量
 * dir          dir 数据文件目录                      设置数据文件存储目录
 * requirepass  requirepass 12345                   设置使用密码
 * protected-mode  protected-mode yes                是否开启保护模式，默认开启，如果需要远程访问需要设置为no
 * bind            bind 0.0.0.0                     默认是bind 127.0.0.1,只允许本机访问，建议改成0.0.0.0,所有主机均可访问
 */

/**
 * redis内置操作命令
 * 1.首先按照上面的命令启动redis，然后新开一个cmd，注意原来的不要关掉，因为windows版redis默认不是守护进程，一旦关掉原cmd，就相当于关闭了redis服务
 * 2.再新开的cmd中进入redis安装目录，输入redis-cli即可进入redis服务（其实也可以直接找到该文件双击打开）
 * 3.ping  检查redis是否正常工作，工作的话应该返回pong
 * 4.select   选择当前使用第几号数据库,redis的数据库式没有名字的，他们就是一个个的数字,数据库默认0-15,超出会报越界，如想增加参考上面的配置文件修改
 * 5 auth     进行密码认证，如auth root
 */

/**
 * redis通用命令
 * 命令           示例                 说明
 * select        select 0           选择0号数据库
 * set          set name lily       设置key=name,value=lily
 * get           get hello          获得key=hello的结果
 * keys          keys he*           根据pattern表达式查询符合条件的key
 * dbsize        dbsize             返回key的总数
 * exists        exists a           检查key=a是否存在
 * del            del a             删除key=a的数据
 * expire         expire hello 20   设置key = hello 30秒后过期
 * ttl           ttl hello          检查key=a 的过期剩余时间
 */

/**
 * redis数据类型
 * String 字符串类型：String 最大512mb,建议单个字符串不超过100kb,字符串常用命令：
 * mset/mget  mset hello world  java best /mget hello java        一次性设置或获取多个值
 * incr/decr  incr count/decr count                                key值自增、自减1
 * incrby/decrby   incrby count 99/decrby count 99                  自增自建指定步长
 *
 * Hash    Hash类型:用于存储结构化数据，利用一个key来包含一系列属性
 * 命令           示例                                  说明
 * hget          hget emp:1 age                    获取hash中key=age的值
 * hset          hset emp:1 age 23                 设置hash中age=23
 * hmset         hmset emp:1 age 30 name kaka      设置hash多个值
 * hmget         hmget emp:1 age name              获取hash多个值
 * hgetall       hgetall emp:1                      获取hash所有值(包括键和值)
 * hdel          hdel emp:1 age                     删除emp:1的age
 * hexists       hexists emp:1  name                检查是否存在
 * hlen          hlen emp:1                          获取指定长度(属性个数）
 *
 *
 * List    列表类型：一系列字符串的数组，集合成员不唯一，按插入顺序进行排序
 * 命令              示例                                    说明
 * rpush         rpush listkey c b a                   右侧插入
 * lpush         lpush listkey f e d                   左侧插入
 * rpop           rpop listkey                         右侧弹出
 * lpop           lpop listkey                         左侧弹出
 * lrange         lrange list 0 -1                     输出list所有元素，0代表起始位置，-1代表最后位置
 *
 *
 * Set     集合类型：无序集合，集合成员是唯一的
 * 命令                 示例                                   说明
 *  sadd               sadd set1 a                          创建一个集合set1,加入成员a
 *  smembers           smembers set1                        输出set1集合的所有成员
 *  sinter             sinter set1 set2                     输出set1,set2的交集
 *  sunion             sunion set1 set2                     输出set1,set2的并集
 *  sdiff              sdiff  set1 set2                     输出set1,set2的差集（set1有，set2没有）
 *
 *
 * Zset    有序集合类型：有序集合，集合成员是唯一的
 * 命令                示例                                 说明
 *  zadd              zadd zset1 100 a                  创建一个zset名为zset1,添加一个排序分数为100的元素a
 *  zrange            zrange zset1 0 -1                 输出zset所欲元素
 *  withscores        zrange zset1 0 -1 withscores      输出zset所有元素的同时打印分数
 *  zrangebyscore     zrangebyscore zset1 100 103       输出分数范围内的元素
 *
 */
public class RedisStudy {

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
