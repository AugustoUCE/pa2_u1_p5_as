package com.uce.edu.inventario.repository;

import com.uce.edu.inventario.repository.modelo.Bodega;

public interface IBodegaRepository {

	public Bodega seleccionar(String codigo);

	public void insertar(Bodega Bodega);

	public void actualizar(Bodega Bodega);

	public void eliminar(String codigo);
}
