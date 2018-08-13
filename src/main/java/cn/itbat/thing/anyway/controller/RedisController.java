package cn.itbat.thing.anyway.controller;

import cn.itbat.thing.anyway.common.domain.RedisInfo;
import cn.itbat.thing.anyway.common.base.AbsResponse;
import cn.itbat.thing.anyway.service.RedisService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("info")
//    @RequiresPermissions("redis:list")
    public String getRedisInfo(Model model) {
        List<RedisInfo> infoList = this.redisService.getRedisInfo();
        model.addAttribute("infoList", infoList);
        return "system/redis/info";
    }

    @RequestMapping("terminal")
//    @RequiresPermissions("redis:terminal")
    public String redisTerminal(Model model) {
        String osName = System.getProperty("os.name");
        model.addAttribute("osName", osName);
        return "system/redis/terminal";
    }

    @RequestMapping("keysSize")
    @ResponseBody
    public String getKeysSize() {
        return JSON.toJSONString(redisService.getKeysSize());
    }

    @RequestMapping("memeryInfo")
    @ResponseBody
    public String getMemeryInfo() {
        return JSON.toJSONString(redisService.getMemeryInfo());
    }

    @RequestMapping("keys")
    @ResponseBody
    public AbsResponse keys(String arg) {
        try {
            Set<String> set = this.redisService.getKeys(arg);
            return AbsResponse.ok(set);
        } catch (Exception e) {
            return AbsResponse.error(e.getMessage());
        }
    }

    @RequestMapping("get")
    @ResponseBody
    public AbsResponse get(String arg) {
        try {
            String result = this.redisService.get(arg);
            return AbsResponse.ok(result == null ? "" : result);
        } catch (Exception e) {
            return AbsResponse.error(e.getMessage());
        }
    }

    @RequestMapping("set")
    @ResponseBody
    public AbsResponse set(String arg) {
        try {
            String args[] = arg.split(",");
            if (args.length == 1)
                return AbsResponse.error("(error) ERR wrong number of arguments for 'set' command");
            else if (args.length != 2)
                return AbsResponse.error("(error) ERR syntax error");
            String result = this.redisService.set(args[0], args[1]);
            return AbsResponse.ok(result);
        } catch (Exception e) {
            return AbsResponse.error(e.getMessage());
        }
    }

    @RequestMapping("del")
    @ResponseBody
    public AbsResponse del(String arg) {
        try {
            String args[] = arg.split(",");
            Long result = this.redisService.del(args);
            return AbsResponse.ok("(integer) " + result);
        } catch (Exception e) {
            return AbsResponse.error(e.getMessage());
        }
    }

    @RequestMapping("exists")
    @ResponseBody
    public AbsResponse exists(String arg) {
        try {
            int count = 0;
            String arr[] = arg.split(",");
            for (String key : arr) {
                if (this.redisService.exists(key))
                    count++;
            }
            return AbsResponse.ok("(integer) " + count);
        } catch (Exception e) {
            return AbsResponse.error(e.getMessage());
        }
    }

    @RequestMapping("pttl")
    @ResponseBody
    public AbsResponse pttl(String arg) {
        try {
            return AbsResponse.ok("(integer) " + this.redisService.pttl(arg));
        } catch (Exception e) {
            return AbsResponse.error(e.getMessage());
        }
    }

    @RequestMapping("pexpire")
    @ResponseBody
    public AbsResponse pexpire(String arg) {
        try {
            String arr[] = arg.split(",");
            if (arr.length != 2 || !isValidLong(arr[1])) {
                return AbsResponse.error("(error) ERR wrong number of arguments for 'pexpire' command");
            }
            return AbsResponse.ok("(integer) " + this.redisService.pexpire(arr[0], Long.valueOf(arr[1])));
        } catch (Exception e) {
            return AbsResponse.error(e.getMessage());
        }
    }

    private static boolean isValidLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
