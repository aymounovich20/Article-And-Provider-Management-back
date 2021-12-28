package com.sip.ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sip.ams.entities.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

}
