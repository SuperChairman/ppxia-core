package club.ppxia.core.exception;

import lombok.Getter;

/**
 * Created by xiaoxuwang on 2019/5/20.
 */
@Getter
public enum GlobalErrorCode implements BaseErrorCode {

    UNKNOWN("999", "未知错误"),
    REDIS_ERROR("10000", "redis异常");

    private String code;
    private String message;

    private GlobalErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
