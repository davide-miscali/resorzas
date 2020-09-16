/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dmiscali.resorzas.kafka;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;

public class KafkaConnectorRouteBuilder extends RouteBuilder {

	@Override
    public void configure() throws Exception {

		//Bridge from WebLogic Kafka Topic to filesystem
		
	from("kafka:{{consumer.topic}}?"
		+ "brokers={{kafka.bootstrap.url}}"
		+ "&keyDeserializer=org.apache.kafka.common.serialization.StringDeserializer"
		+ "&valueDeserializer=org.apache.kafka.common.serialization.StringDeserializer").id("gpl-from-Kafka-to-file")
//	.process(new KafkaMessageRouterProcessor())
	.convertBodyTo(String. class)
	.log("RECEVIED:\n${body}")
	.to("direct:get-out-topic")
    .to("kafka:{{kafka.default-topic}}?"
		+ "brokers={{kafka.bootstrap.url}}"
		+ "&keySerializerClass=org.apache.kafka.common.serialization.StringSerializer"
		+ "&serializerClass=org.apache.kafka.common.serialization.StringSerializer");
    
	
	from("direct:get-out-topic")
		.log("RECEVIED:\n${body}")
		//get code_id
		.jsonpath("$.store.book[?(@.price < 10)]")
		//get related_topic
		
		//override topic with header
		.setHeader(KafkaConstants.OVERRIDE_TOPIC)
		;
    
    }
}
