package com.shanepaulus.api;

import com.shanepaulus.message.Message;
import com.shanepaulus.message.MessageResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private final Logger logger = LoggerFactory.getLogger(MessageController.class);

	@SneakyThrows
	@MessageMapping("/message")
	@SendTo("/topic/conversation")
	public MessageResponse message(Message message) {
		logger.info("message() {}", message.toString());
		Thread.sleep(1000);
		return new MessageResponse("Hello, " + HtmlUtils.htmlEscape(message.getName()));
	}
}
