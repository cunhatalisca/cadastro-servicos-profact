package com.example.Profact.service;

import com.example.Profact.entities.Services;
import com.example.Profact.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Services> findAllServices() {
        List<Services> allServices = servicoRepository.findAll();
        return allServices;
    }

    public List<Services> findServicesPendents() {
        List<Services> servicesPendents = servicoRepository.repositoryFindServicesPendents();
        return servicesPendents;
    }

    public List<Services> findServicesCanceled() {
        List<Services> serviceCanceled = servicoRepository.repositoryFindServicesCanceled();
        return serviceCanceled;
    }

    public Services addService(Services service) {
        if(service.getPricePaidOut() == null || service.getPricePaidOut() == 0 || service.getDatePayDay() == null) {
            service.setStatus("Pendente");
        } else {
            service.setStatus("Realizado");
        }

        Services servicesSave = servicoRepository.save(service);
        return servicesSave;
    }

    public Services alterService(Services service) {
        if(service.getPricePaidOut() != null && service.getPricePaidOut() > 0 && service.getDatePayDay() != null) {
            service.setStatus("Realizado");
        }
        Services configService = servicoRepository.saveAndFlush(service);
        return configService;
    }

    public void serviceCanceled(Long id) {
        Services servico = servicoRepository.findById(id).get();
        servico.setStatus("Cancelado");
        servicoRepository.save(servico);
    }

    public void removeService(Long id) {
        Optional<Services> optionalService = servicoRepository.findById(id);

        if (optionalService.isPresent()) {
            Services serviceToRemove = optionalService.get();
            servicoRepository.delete(serviceToRemove);
        }

    }

}
