package club.ppxia.core.annotation;

import club.ppxia.core.config.WechatConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by xiaoxuwang on 2019/5/15.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(WechatConfig.class)
public @interface EnableWechatConfig {
}
