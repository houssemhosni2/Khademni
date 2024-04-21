package tn.esprit.internshipmodule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.internshipmodule.entities.Enterprise;
import tn.esprit.internshipmodule.repositories.EnterpriseRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EnterpriseServiceImpl implements EnterpriseService {

        private final EnterpriseRepository enterpriseRepository;
        @Override
        public List<Enterprise> retrieveAllEnterprise(){
            return enterpriseRepository.findAll();
        }

        @Override
        public Enterprise retrieveAnEnterprise(Long idEnterprise){
            return enterpriseRepository.findById(idEnterprise).orElse(null);
        }
        @Override
        public Enterprise createOrUpdateEnterprise(Enterprise enterprise){
            return enterpriseRepository.save(enterprise);
        }
        @Override
        public void removeEnterprise(Long idEnterprise){
            enterpriseRepository.deleteById(idEnterprise);
        }
    }
