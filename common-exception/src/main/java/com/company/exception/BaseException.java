package com.company.exception;

/**
 * <p>基本异常</p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public abstract class BaseException extends RuntimeException {

    /** 错误码 */
    private String errorCode = null;
    /** 错误描述 */
    private String errorDesc = null;

    public BaseException() {
        super();
    }

    /**
     * Constructs a MessageFormat for the default locale and the
     * specified pattern.
     * The constructor first sets the locale, then parses the pattern and
     * creates a list of subformats for the format elements contained in it.
     * Patterns and their interpretation are specified in the
     * <a href="#patterns">class description</a>.
     *
     * @param errorCode 错误码
     * @param errorDesc 错误描述
     * @param message   异常信息
     */
    public BaseException(String errorCode, String errorDesc, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    /**
     * Constructs a MessageFormat for the default locale and the
     * specified pattern.
     * The constructor first sets the locale, then parses the pattern and
     * creates a list of subformats for the format elements contained in it.
     * Patterns and their interpretation are specified in the
     * <a href="#patterns">class description</a>.
     *
     * @param errorCode 错误码
     * @param errorDesc 错误描述
     * @param cause     异常原因
     */
    public BaseException(String errorCode, String errorDesc, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
