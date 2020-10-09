package com.dmiscali.resorzas.kafka;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "routingmap")
public class RoutingMap {
	
	
	private String jsonpathInputKey;
	private String defaultDestination;
    private List<Destination> destinations;
 
 
    public String getDestinationByCode(String code){
    	
    	for(Destination dest : destinations)     		
    		if(code.matches(dest.getRegex()))
    			return dest.getOut();
    	   	
    	return defaultDestination;
    }
    
    public String getJsonpathInputKey() {
		return jsonpathInputKey;
	}



	public void setJsonpathInputKey(String jsonpathInputKey) {
		this.jsonpathInputKey = jsonpathInputKey;
	}



	public String getDefaultDestination() {
		return defaultDestination;
	}



	public void setDefaultDestination(String defaultDestination) {
		this.defaultDestination = defaultDestination;
	}



	public List<Destination> getDestinations() {
		return destinations;
	}



	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}



	public static class Destination{
		
		String regex;
		String out;
		public String getRegex() {
			return regex;
		}
		public void setRegex(String regex) {
			this.regex = regex;
		}
		public String getOut() {
			return out;
		}
		public void setOut(String out) {
			this.out = out;
		}
		
		
	}
}