package com.dynamodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Configuration
public class BeansConfig {
	
	@Bean
	@Primary
	public ObjectMapper objectMapper(final Jackson2ObjectMapperBuilder builder) {
		return builder.build()
				.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true)
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}
	
	@Bean
	public XmlMapper xmlMapper() {
		final JacksonXmlModule module = new JacksonXmlModule(); 
		module.setDefaultUseWrapper(false);
		
		final XmlMapper xmlMapper = new XmlMapper(module);
		xmlMapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)
				.setSerializationInclusion(JsonInclude.Include.NON_NULL);		
		return xmlMapper;
	}	
}