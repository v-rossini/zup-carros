package br.com.vitor.zupcarros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vitor.zupcarros.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
