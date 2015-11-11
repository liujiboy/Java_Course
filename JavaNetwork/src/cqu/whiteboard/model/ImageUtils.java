package cqu.whiteboard.model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {
	
	public static byte[] image2bytes(BufferedImage image) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "png", buffer);
			return buffer.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static BufferedImage bytes2Image(byte datas[]) {
		ByteArrayInputStream in = new ByteArrayInputStream(datas);
		BufferedImage image = null;
		try {
			image = ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

}
