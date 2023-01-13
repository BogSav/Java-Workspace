package packWork;

import java.awt.image.BufferedImage;

public abstract class AbstractBuffer {
	public abstract void put(BufferedImage image, int currentImage);
	public abstract BufferedImage[] GetImages();
}
