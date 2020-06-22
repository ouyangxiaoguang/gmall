package com.sz.lock.locktest.service;

import com.sz.lock.locktest.common.Constant;
import com.sz.lock.locktest.utils.JedisUtil;
import com.sz.lock.locktest.utils.RandomUtil;
import com.sz.lock.locktest.utils.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@Slf4j
public class TokenService {
    private static final String TOKEN_NAME = "token";
    @Autowired
    private JedisUtil jedisUtil;


    /*
    * 单进程实现幂等性
    * */
    public void checkToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_NAME);
        if (StringUtils.isBlank(token)) {// header中不存在token
            token = request.getParameter(TOKEN_NAME);
            if (StringUtils.isBlank(token)) {// parameter中也不存在token
                throw new ServiceException("没有携带令牌，非法操作");
            }
        }
        if (!jedisUtil.exists(token)) {
            throw new ServiceException("重复调用接口");
        }

        Long del = jedisUtil.del(token);
        log.info(del.toString());
//        if (del <= 0) {
//            throw new ServiceException("重复调用接口");
//        }
    }

    public String createToken() {

        String str = RandomUtil.UUID32();
        StrBuilder token = new StrBuilder();
        token.append(Constant.Redis.TOKEN_PREFIX).append(str);

        jedisUtil.set(token.toString(), token.toString(), Constant.Redis.EXPIRE_TIME_MINUTE);
        return token.toString();
    }


    public void testIdempotence(){
        log.info("调用了testIdempotence方法");
    }

}
