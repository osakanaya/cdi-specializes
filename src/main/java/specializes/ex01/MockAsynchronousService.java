package specializes.ex01;

import javax.enterprise.inject.Alternative;

@Alternative
public class MockAsynchronousService extends AsynchronousService {

	@Override
	public String greet(String name) {
		return "Hi, " + name + "!";
	}
}
