package math.com.controllers;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContextEvent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.sarxos.webcam.Webcam;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView getData() {

		ModelAndView model = new ModelAndView("first");
		
		// ====================================================================
		// ATTIVA LA WEB CAM ALLA CHIAMATA DEL METODO... prova per branch
		// ==============================================
		// Disattiva il thread per la ricerca dei devices...
//		Webcam.getDiscoveryService().setEnabled(false);
//		Webcam.getDiscoveryService().stop();
		// ==============================================
		Webcam webcam = Webcam.getDefault();
		//webcam.setViewSize(WebcamResolution.VGA.getSize());
		// Set dimensioni...
		webcam.setViewSize(new Dimension(640,480));
		webcam.open();
		BufferedImage image = webcam.getImage();
		
		webcam.close();
		try {
			ImageIO.write(image, "JPG", new File("C:\\Users\\Utente\\Desktop\\test.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Si potrebbe mettere qui lo stop del find devices...
		// Modo mogliore...
		Webcam.getDiscoveryService().stop(); 
		
		// Stampa il nome della webcam: Webcam Logitech HD Webcam C525 0
		System.out.println("LA TELECAMERA INSTALLATA E': "+webcam.toString());
		// ====================================================================
		
		model.addObject("nome", "Gianluca Proia");
		return model;

	}

}