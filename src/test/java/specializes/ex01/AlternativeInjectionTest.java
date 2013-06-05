package specializes.ex01;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class AlternativeInjectionTest {
	private static final Logger logger = Logger.getLogger("org.cdi.advocacy");
	
	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				.addPackage(Service.class.getPackage())
				.addAsManifestResource("beans.xml", "beans.xml");

		logger.info(jar.toString(true));
		return jar;
	}
	
	@Inject
	private Service service;
	
	@Test
	public void testAlternativeServiceInjected() throws Exception {
		assertThat(service.greet("Hideo"), is("Hi, Hideo!"));
	}
}
