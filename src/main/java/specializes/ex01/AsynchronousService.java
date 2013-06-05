package specializes.ex01;

import javax.enterprise.inject.Default;

@Default
@Asynchronous
public class AsynchronousService implements Service {

	@Override
	public String greet(String name) {
		return "Hello, " + name + "!";
	}

}
