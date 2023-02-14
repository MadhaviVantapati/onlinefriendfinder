package com.onlinefriendfinder.service;

import com.onlinefriendfinder.entity.Chat;

public interface ChatService {
		
		public Chat addChat(Chat chat) throws Exception;
		public Chat deleteChat(int chatId) throws Exception;
		public Chat editChat(Chat chat) throws Exception;
		public Chat viewChatById(int chatId) throws Exception;
		public Chat sendMessage(String message, int chatId) throws Exception;
		public Chat replyMessage(String message, int chatId) throws Exception;


}
