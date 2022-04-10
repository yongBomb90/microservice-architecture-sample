package com.example.oauthservice.module.client.jpa.repository;

import com.example.oauthservice.module.client.jpa.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity,Long> {

    ClientEntity findClientEntityByClientId(String clientId);

}
