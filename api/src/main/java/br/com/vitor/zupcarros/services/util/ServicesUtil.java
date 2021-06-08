package br.com.vitor.zupcarros.services.util;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Service
public class ServicesUtil {
    public Date converterData(String data) throws ParseException {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException exception) {
            throw new ParseException("Formato de data inválido (dd/mm/yyyy)",1);
        }
    }
    
    public String emailValidator(String email) throws AddressException {
        InternetAddress emailAddress = null;
        try {
            emailAddress = new InternetAddress(email);
        } catch (AddressException e) {
            throw new AddressException("Formato de email inválido");
        }
        emailAddress.validate();
        return emailAddress.getAddress();
    }
    
    public String urlParser(String url) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		return response.getBody();
    }
    
	public boolean isToday(DayOfWeek day) {
		LocalDate today = LocalDate.now();
		return day == today.getDayOfWeek() ;
	}
}
