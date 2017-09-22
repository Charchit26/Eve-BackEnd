package com.unconf.controllers;

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
	@RequestMapping(value="/msg", method=org.springframework.web.bind.annotation.RequestMethod.POST)
	public ResponseEntity < String > message(@RequestBody String input){
		String str = "Nothing";
		try {
			AliceBotMother mother = new AliceBotMother();
			AliceBot mybot = mother.newInstance();
			input=input.replace("+", " ");
			input=input.replace("=", "");
			String ask = input; // Here You can ask Dynamic question.
			str = mybot.respond(ask);
			System.out.println(str);
			return ResponseEntity.ok(str);
		} catch (Exception ex) {
			System.err.println(ex.toString());

		}
		return ResponseEntity.ok("problem string --> "+str);
	}
}
