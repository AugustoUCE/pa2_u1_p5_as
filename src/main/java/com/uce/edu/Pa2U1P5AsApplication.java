package com.uce.edu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5AsApplication implements CommandLineRunner {

	@Autowired
	private ITransferenciaService transferenciaService;
	@Autowired
	private ICuentaBancariaService cuentaBancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5AsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 1. Crear cuentas
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setCedulaPropietario("1752083905");
		ctaOrigen.setNumero("1234");
		ctaOrigen.setSaldo(new BigDecimal(100));
		this.cuentaBancariaService.guardar(ctaOrigen);

		// ctadestino
		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setCedulaPropietario("1234658790");
		ctaDestino.setNumero("5678");
		ctaDestino.setSaldo(new BigDecimal(200));
		this.cuentaBancariaService.guardar(ctaDestino);

		this.transferenciaService.realizar("1234", "5678", new BigDecimal(40));
		System.out.println(ctaOrigen.hashCode());

		this.transferenciaService.realizar("1234", "5678", new BigDecimal(10));
		this.transferenciaService.realizar("5678", "1234", new BigDecimal(10));

		// construir un reporte del estado de cuenta de todas las trasnferencias
		System.out.println("\n Inicio Reporte");
		
		List<Transferencia> listrep = this.transferenciaService.buscarTodo();

		int indice = 0;

		for (Transferencia trans : listrep) {
			indice++;
			System.out.println(indice + ":" + trans);
		}
		System.out.println("Fin Reporte\n");

		//Imprimir para ver la cuentas origen y destino
		CuentaBancaria ctaOrigen1 = this.cuentaBancariaService.buscar("1234");
		System.out.println(ctaOrigen1);
		CuentaBancaria ctaDestino1 = this.cuentaBancariaService.buscar("5678");
		System.out.println(ctaDestino1);
		System.out.println("fin");
		
		

	}

}
