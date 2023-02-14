package com.onlinefriendfinder.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.onlinefriendfinder.entity.Chat;
import com.onlinefriendfinder.service.ChatService;

	

	@RestController
	@RequestMapping("/off-chat")
	public class ChatController {
		
		@Autowired
		ChatService chatService;
		
		@PostMapping("/addChat")
		public Chat addChat(@RequestBody Chat chat) throws Exception{
			return chatService.addChat(chat);
		}
		
		@DeleteMapping("/deleteChat/{chatId}")
		public Chat deleteChat(@PathVariable int chatId) throws Exception{
			return chatService.deleteChat(chatId);
		}
		
		@PutMapping("/editChat")
		public Chat editChat(@RequestBody Chat chat) throws Exception{
			return chatService.editChat(chat);
		}
		
		@GetMapping("/viewChatById/{chatId}")
		public Chat viewChatById(@PathVariable int chatId) throws Exception{
			return chatService.viewChatById(chatId);
		}
		
		@PutMapping("/sendMessage/{message}/{chatId}")
		public Chat sendMessage(@PathVariable String message,@PathVariable  int chatId) throws Exception{
			return chatService.sendMessage(message, chatId);
		}
		
		@PutMapping("/replyMessage/{message}/{chatId}")
		public Chat replyMessage(@PathVariable String message,@PathVariable  int chatId) throws Exception{
			return chatService.replyMessage(message, chatId);
		}

}
