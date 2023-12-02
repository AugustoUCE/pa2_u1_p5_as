package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IBodegaService;
import com.uce.edu.inventario.service.IInventarioService;
import com.uce.edu.inventario.service.IProductoService;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5AsApplication implements CommandLineRunner {

	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IBodegaService bodegaService;
	
	@Autowired
	private IInventarioService inventarioService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5AsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Producto p1 = new Producto();
		p1.setNombre("HP 15 laptop");
		p1.setStock(0);
		p1.setCodigoBarras("12345");
		this.productoService.guardar(p1);

		Producto p2 = new Producto();
		p2.setNombre("Teclado HP");
		p2.setStock(0);
		p2.setCodigoBarras("567");
		this.productoService.guardar(p2);

	
		Bodega b1 = new Bodega();
		b1.setNombre("Supermaxi");
		b1.setDireccion("Las gasca");
		b1.setCodigo("2424");
		b1.setCapacidad(100);
		
		this.bodegaService.guardar(b1);
		
		
		this.inventarioService.registrar("2424", "12345", 50);
		System.out.println("producto 1: "+this.inventarioService.buscar("232323"));
		
		this.inventarioService.registrar("2424", "567", 100);
		
		System.out.println("producto 2: "+this.inventarioService.buscar("232323"));
		
		this.inventarioService.registrar("2424", "12345", 20);
		System.out.println("producto 1: "+this.inventarioService.buscar("232323"));
		
	}

}
