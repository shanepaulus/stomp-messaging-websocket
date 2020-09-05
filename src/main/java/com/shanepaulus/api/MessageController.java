package com.shanepaulus.api;

import com.shanepaulus.message.Message;
import com.shanepaulus.message.MessageResponse;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import lombok.SneakyThrows;

/**
 * @author Shane Paulus
 * <p>
 * Date Created : 05-Sep-2020.
 */

@Controller
public class MessageController {

	@SneakyThrows
	@MessageMapping("/message")
	@SendTo("/topic/conversation")
	public MessageResponse message(Message message) {
		Thread.sleep(1000);
		return new MessageResponse("Hello, " + HtmlUtils.htmlEscape(message.getName()));
	}
}
