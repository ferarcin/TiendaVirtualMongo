package com.usa.Ciclo4.TiendaVirtualMongo;

import com.usa.Ciclo4.TiendaVirtualMongo.interfase.ProductInterfase;
import com.usa.Ciclo4.TiendaVirtualMongo.interfase.UserInterfase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class TiendaVirtualMongoApplication implements CommandLineRunner{
	@Autowired
	private ProductInterfase productInterfase;

	@Autowired
	private UserInterfase userInterfase;

	public static void main(String[] args) {
		SpringApplication.run(TiendaVirtualMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		productInterfase.deleteAll();
		userInterfase.deleteAll();
	}
}
