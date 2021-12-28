package com.sip.ams.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;

@RestController
@RequestMapping({ "/providers", "/hom*" })
@CrossOrigin(origins = "*")
public class ProviderController {
	@Autowired
	private ProviderRepository providerRepository;

	@GetMapping("/list")
	public List<Provider> getAllProviders() {
		return (List<Provider>) providerRepository.findAll();
	}

	@PostMapping("/add")
	public Provider createProvider(@Valid @RequestBody Provider provider) {
		return providerRepository.save(provider);
	}

	@PutMapping("/{providerId}")
	public Provider updateProvider(@PathVariable Long providerId, @Valid @RequestBody Provider providerRequest) {
		return providerRepository.findById(providerId).map(provider -> {
			provider.setName(providerRequest.getName());
			provider.setEmail(providerRequest.getEmail());
			provider.setAddress(providerRequest.getAddress());
			return providerRepository.save(provider);
		}).orElseThrow(() -> new IllegalArgumentException("ProviderId " + providerId + " not found"));
	}

	@DeleteMapping("/{providerId}")
	public ResponseEntity<?> deleteProvider(@PathVariable Long providerId) {
		return providerRepository.findById(providerId).map(provider -> {
			providerRepository.delete(provider);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new IllegalArgumentException("ProviderId " + providerId + " not found"));
	}

	@GetMapping("/{providerId}")
	public Provider getProvider(@PathVariable Long providerId) {
		Optional<Provider> p = providerRepository.findById(providerId);
		return p.get();
	}

}
