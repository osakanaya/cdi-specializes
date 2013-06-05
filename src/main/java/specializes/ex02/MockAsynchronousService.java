package specializes.ex02;

import javax.enterprise.inject.Specializes;

@Specializes
public class MockAsynchronousService extends AsynchronousService {

	@Override
	public String greet(String name) {
		return "Hi, " + name + "!";
	}
}
