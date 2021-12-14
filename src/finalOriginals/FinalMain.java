package finalOriginals;

public class FinalMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();

		// TASK 2: ADD A USER GAME OBJECT
		Type_D_GameObject user = new Type_D_GameObject(200, 200);
		Type_A_GameObject objectA = new Type_A_GameObject(200, 200);
		Type_B_GameObject objectB = new Type_B_GameObject(200, 200);	
		Type_C_GameObject objectC = new Type_C_GameObject(200, 200);

		user.setVelocity(10);
		objectA.setVelocity(10);
		objectB.setVelocity(10);
		objectC.setVelocity(10);

		canvas.addGameObject(user);
		canvas.addGameObject(objectA);
		canvas.addGameObject(objectC);
		canvas.addGameObject(objectB);
		
		canvas.addKeyListener(user);
		canvas.addKeyListener(objectA);
		
		

		
	}

}
