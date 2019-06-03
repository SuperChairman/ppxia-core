package club.ppxia.core.annotation;

import club.ppxia.core.config.JedisConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by xiaoxuwang on 2019/5/15.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = JedisConfig.class)
public @interface EnableJedisConfig {
}
