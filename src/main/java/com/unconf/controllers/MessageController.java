package com.unconf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.AliceBotMother;

@CrossOrigin
@RestController
public class MessageController {
	
	AliceBot mybot;
	
	public MessageController() throws Exception {
		// TODO Auto-generated constructor stub
		AliceBotMother mother = new AliceBotMother();
		mybot = mother.newInstance();
	}
	
	@RequestMapping(value="/msg", method=org.springframework.web.bind.annotation.RequestMethod.POST)
	public ResponseEntity < String > message(@RequestBody String input){
		String str = "Nothing";
		try {
			input=input.replace("+", " ");
			input=input.replace("=", "");
			String ask = input; // Here You can ask Dynamic question.
			System.out.println(ask);
			str = mybot.respond(ask);
			System.out.println(str);
			return ResponseEntity.ok(str);
		} catch (Exception ex) {
			System.err.println(ex.toString());

		}
		return ResponseEntity.ok("problem string --> "+str);
	}
}
