package com.joelreinoso.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joelreinoso.apirest.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository <Producto, Long>{

}
