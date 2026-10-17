
package com.carritogt.repository;

import com.carritogt.entity.CarritoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoRepository extends JpaRepository<CarritoItem, Integer> {

    List<CarritoItem> findByCodUsuario(String codUsuario);

}

