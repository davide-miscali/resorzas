package com.dmiscali.resorzas;

import org.apache.camel.Exchange;

public class SimpleProcessor {
	
	public void changeBody(Exchange exchange) throws Exception {
       
        String oldBody = exchange.getIn().getBody(String.class);
		exchange.getIn().setBody("received Body: " + oldBody );
    }

}
