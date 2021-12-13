package com.usa.Ciclo4.TiendaVirtualMongo;

import com.usa.Ciclo4.TiendaVirtualMongo.interfase.OrderInterface;
import com.usa.Ciclo4.TiendaVirtualMongo.interfase.ProductInterface;
import com.usa.Ciclo4.TiendaVirtualMongo.interfase.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@Component
@SpringBootApplication
public class TiendaVirtualMongoApplication implements CommandLineRunner{
	//Se instancia la Interface Product para borrarla al iniciar la aplicación
	@Autowired
	private ProductInterface productInterface;

	//Se instancia la Interface User para borrarla al iniciar la aplicación
	@Autowired
	private UserInterface userInterface;

	//Se instancia la Interface Order para borrarla al iniciar la aplicación
	@Autowired
	private OrderInterface orderInterface;

	public static void main(String[] args) {
		SpringApplication.run(TiendaVirtualMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		productInterface.deleteAll();
		userInterface.deleteAll();
		orderInterface.deleteAll();

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	}
}
