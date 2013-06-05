package specializes.ex02;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Arquillian.class)
public class DefaultInjectionTest {
	private static final Logger logger = Logger.getLogger("org.cdi.advocacy");
	
	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				.addPackage(Service.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

		logger.info(jar.toString(true));
		return jar;
	}
	
	@Inject
	private Service service;
	
	@Test
	public void testDefaultServiceInjected() throws Exception {
		assertThat(service.greet("Hideo"), is("Hi, Hideo!"));
	}
}
