package comm.it;

import java.lang.reflect.Field;

public class Test {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		Class<?> clz = Class.forName("comm.it.User");
		
		Object obj = clz.newInstance();
		User user=(User) obj;
		
		Field field = clz.getDeclaredField("age");
		field.setAccessible(true);
		
		field.set(user, 25); // setting value to variable
		
		user.printAge();
		
	}
}
