package Health_insurance.demo.controller;

import Health_insurance.demo.model.PolicyHolder;
import Health_insurance.demo.services.PolicyHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policyholders")
public class PolicyHolderController {

    @Autowired
    private PolicyHolderService service;

    @PostMapping
    public PolicyHolder createPolicyHolder(@RequestBody PolicyHolder policyHolder) {
        return service.createPolicyHolder(policyHolder);
    }

    @GetMapping
    public List<PolicyHolder> getAllPolicyHolders() {
        return service.getAllPolicyHolders();
    }


}
