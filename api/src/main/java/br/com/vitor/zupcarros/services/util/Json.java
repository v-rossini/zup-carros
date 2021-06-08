package br.com.vitor.zupcarros.services.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
	private static ObjectMapper objectMapper = getDefaultObjectMapper();
	
	private static ObjectMapper getDefaultObjectMapper() {
		ObjectMapper defaultObjectMapper = new ObjectMapper();
		//...
		return defaultObjectMapper;
	}
	
	public static JsonNode parse(String string) throws IOException {
		return objectMapper.readTree(string);
	}
}
