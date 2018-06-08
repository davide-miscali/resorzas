import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyRouteTest extends CamelSpringTestSupport {

	@Test
	public void shouldGetBodyChangedByProcessor() throws InterruptedException {

		Exchange exchange = new DefaultExchange(context);
		exchange.getIn().setBody("this is my text");
		Exchange processed = template.send("direct:feed-me", exchange);

		assertEquals("received Body: this is my text", processed.getIn().getBody(String.class));
	}
	
	
	@Override
	protected AbstractApplicationContext createApplicationContext() {

		String[] contextFiles = new String[] { "META-INF/spring/camel-context.xml", 
												"META-INF/spring/beans.xml" };
		return new ClassPathXmlApplicationContext(contextFiles);
	}

}
