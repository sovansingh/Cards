package com.app.cards.entity;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@ConfigurationProperties(prefix = "cards")
@Getter
@Setter
@ToString
public class CardConfigServer {

	private String msg;
	private String buildversion;
	private Map<String, String> mailDetails;
	private List<String> activeBranches;
}
