package br.com.vitor.zupcarros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vitor.zupcarros.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
