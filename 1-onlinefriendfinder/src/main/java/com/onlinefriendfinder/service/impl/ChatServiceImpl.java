package com.onlinefriendfinder.service.impl;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.onlinefriendfinder.entity.Chat;
import com.onlinefriendfinder.exception.ResourceNotFoundException;
import com.onlinefriendfinder.repository.ChatRepository;
import com.onlinefriendfinder.service.ChatService;

	
	@Service("ChatService")
	public class ChatServiceImpl implements ChatService {
		
		@Autowired
		ChatRepository chatRepository;

		@Override
		public Chat addChat(Chat chat) throws Exception {
			chatRepository.saveAndFlush(chat);
			return chat;
		}

		@Override
		public Chat deleteChat(int chatId) throws Exception {
			Chat bean = null;
			try {
				bean = chatRepository.findById(chatId).get();
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("Chat details not found!");
			}
			chatRepository.deleteById(chatId);
			return bean;
		}

		@Override
		public Chat editChat(Chat chat) throws Exception {
			Chat bean = null;
			try {
				bean = chatRepository.findById(chat.getChatId()).get();
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("Chat details not found!");
			}
			chatRepository.saveAndFlush(chat);
			return bean;
		}

		@Override
		public Chat viewChatById(int chatId) throws Exception {
			Chat bean = null;
			try {
				bean = chatRepository.findById(chatId).get();
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("Chat details not found!");
			}
			return bean;
		}

		@Override
		public Chat sendMessage(String message, int chatId) throws Exception {
			Chat bean = null;
			try {
				bean = chatRepository.findById(chatId).get();
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("Chat details not found!");
			}
			 bean.setSenderMessage(message);
			return bean;
		}

		@Override
		public Chat replyMessage(String message, int chatId) throws Exception {
			Chat bean = null;
			try {
				bean = chatRepository.findById(chatId).get();
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("Chat details not found!");
			}
			//bean.setSenderMessage(message);
			bean.setSenderMessage(message);
			return bean;
		}

}
