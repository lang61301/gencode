/**
 * 
 */
package me.paddingdun.gen.code.exception;

/**
 * 业务异常;
 * @author paddingdun
 *
 * 2015年11月25日
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public BusinessException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
}
