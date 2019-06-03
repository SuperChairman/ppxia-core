package club.ppxia.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by xiaoxuwang on 2019/5/15.
 */
public class WechatConfig {

    @Value("${applet.wechat.app-id}")
    private String appId;

    @Value("${applet.wechat.app-secret}")
    private String appSecret;



}
