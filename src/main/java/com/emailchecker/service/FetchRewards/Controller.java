package com.emailchecker.service.FetchRewards;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String emailChecker() {
		return "Please enter list of emails after the URL, e.g. localhost:8080/test@gmail.com, test+spam@gmail.com";
	}

	@RequestMapping(value = "/{eList:.+}", method = RequestMethod.GET)
	public String emailChecker(@PathVariable("eList") String[] eList) {
		
		System.out.println(Arrays.toString(eList));
		
		Set<String> uniqueEmails = new HashSet<String>();
		StringBuilder new_email;
		
		for (String email : eList) {
			new_email = new StringBuilder();
			for (int i = 0; i < email.length(); i++) {
				char c = email.charAt(i);
				if (c == '.')
					continue;
				else if (c == '+' || c == '@') {
					while (email.charAt(i) != '@') {
						i++;
					}
					new_email.append(email.substring(i));
					break;
				} else {
					new_email.append(c);
				}
			}
			if(new_email.toString().matches("^[A-Za-z0-9]+@[A-Za-z0-9]+.+$")) {
				uniqueEmails.add(new_email.toString());
			}
			else {
				return "An invalid email detected, please enter list of valid emails!";
			}
		}
		
		if(uniqueEmails.size() == 0) {
			return "Please enter valid email!";
		}
		
		return "Total number of unique emails: "+String.valueOf(uniqueEmails.size());
	}
	
}
