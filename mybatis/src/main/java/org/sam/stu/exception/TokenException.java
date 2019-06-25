package org.sam.stu.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义Token异常处理
 * @author samphin
 */
@Setter
@Getter
public class TokenException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public TokenException(String message) {
		super();
		this.message = message;
	}
}
