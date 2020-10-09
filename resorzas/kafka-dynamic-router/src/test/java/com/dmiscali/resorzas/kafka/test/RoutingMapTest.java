package com.dmiscali.resorzas.kafka.test;


import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dmiscali.resorzas.kafka.RoutingMap;
import com.dmiscali.resorzas.kafka.RoutingMap.Destination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoutingMapTest {

	@Autowired
	private RoutingMap routingMap;

	@Test
	public void shouldGetRoutingMap() {
		
		Map<String, Destination> map = routingMap.getDestinations().stream().collect(Collectors.toMap(Destination::getRegex, destination -> destination));
		
 		assertEquals("wrong size", 3, routingMap.getDestinations().size());
		
	}

	@Test
	public void shouldGetFirstFor1234() {
		
		String destination = routingMap.getDestinationByCode("12345");

		assertEquals("Wrong destination", "first.dest", destination);
	
	}
	
	@Test
	public void shouldGetSecondFor23456() {
		
		String destination = routingMap.getDestinationByCode("23456");

		assertEquals("Wrong destination", "second.dest", destination);
	
	}

	@Test
	public void shouldGetThirdFor34567() {
		
		String destination = routingMap.getDestinationByCode("34567");

		assertEquals("Wrong destination", "third.dest", destination);
	
	}
	
	@Test
	public void shouldGetDefault() {
		
		String destination = routingMap.getDestinationByCode("45678");

		assertEquals("Wrong destination for " + destination, "default.dest", destination);
		
		destination = routingMap.getDestinationByCode("H45678");
		
		assertEquals("Wrong destination for " + destination, "default.dest", destination);
		
		
	}

}