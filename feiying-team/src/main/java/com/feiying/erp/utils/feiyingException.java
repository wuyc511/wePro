package com.feiying.erp.utils;

/**
 * @title: 平台异常基类
 * @description: 用于包装一些异常信息，打印日志等服务
 */
@SuppressWarnings("serial")
public class feiyingException extends Exception {
    public long errorCode = -1;

    public String message;

    public feiyingException() {
        super();
    }

    public feiyingException(String message) {
        super(message);
        this.message = message;
    }

    public feiyingException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public feiyingException(Throwable cause) {
        super(cause);
    }

    public feiyingException(long errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public feiyingException(String message, long errorCode) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public feiyingException(String message, long errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.message = message;
    }

    public feiyingException(long errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
