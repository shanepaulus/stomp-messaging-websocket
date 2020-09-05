package com.shanepaulus.message;

import lombok.Data;
import lombok.NonNull;

/**
 * @author Shane Paulus
 * <p>
 * Date Created : 05-Sep-2020.
 */

@Data
public class MessageResponse {

	@NonNull
	private String content;

}
