package packTest;

import packWork.Platform;

public class ProtectedTest  extends Platform {

	public void testFields() {
		//fieldPrivate = 0;		-> error
		//fieldNoModifier = 0;	-> error
		fieldProtected = 0;
		fieldPublic = 0;		
	}

}
