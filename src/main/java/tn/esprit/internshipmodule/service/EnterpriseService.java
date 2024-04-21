package tn.esprit.internshipmodule.service;

import tn.esprit.internshipmodule.entities.Enterprise;

import java.util.List;

public interface EnterpriseService {

    List<Enterprise> retrieveAllEnterprise();
    Enterprise retrieveAnEnterprise(Long idEnterprise);
    Enterprise createOrUpdateEnterprise(Enterprise enterprise);
    void removeEnterprise(Long idEnterprise);
}
