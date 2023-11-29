package com.uce.edu.inventario.repository;

import com.uce.edu.inventario.repository.modelo.Producto;

public interface IProductoRepository {

	public Producto seleccionar(String codigoBarras);

	public void insertar(Producto Producto);

	public void actualizar(Producto Producto);

	public void eliminar(String codigoBarras);
}
