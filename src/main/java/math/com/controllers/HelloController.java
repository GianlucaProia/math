package math.com.controllers;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.sarxos.webcam.Webcam;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView getData() throws IOException {

		ModelAndView model = new ModelAndView("first");
		
		// ====================================================================
		Webcam webcam = Webcam.getDefault();
		//webcam.setViewSize(WebcamResolution.VGA.getSize());
		// Set dimensioni...
		webcam.setViewSize(new Dimension(640,480));
		webcam.open();
		BufferedImage image = webcam.getImage();
		
		webcam.close();
		ImageIO.write(image, "JPG", new File("C:\\Users\\Utente\\Desktop\\test.jpg"));
		
		// Stampa il nome della webcam: Webcam Logitech HD Webcam C525 0
		System.out.println(webcam.toString());
		// ====================================================================
		
		model.addObject("nome", "Gianluca Proia");
		return model;

	}

}