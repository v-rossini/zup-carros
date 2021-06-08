package br.com.vitor.zupcarros.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.vitor.zupcarros.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
