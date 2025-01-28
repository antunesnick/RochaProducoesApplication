package com.nickolas.RochaProducoes.models;


import com.nickolas.RochaProducoes.models.enums.CostumerGender;
import com.nickolas.RochaProducoes.validation.constraints.NumberPhone;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "costumers")
public class Costumer {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID costumerId;

    @Column(name = "costumer_name", nullable = false)
    @NotBlank
    private String costumerName;

    @Column(name = "costumer_email", nullable = false, unique = true)
    @Email
    private String costumerEmail;

    @Column(name = "costumer_phone", nullable = false, length = 14)
    @NotBlank
    @NumberPhone
    private String costumerPhone;

    @Column(name = "costumer_gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotBlank
    private CostumerGender costumerGender;

    @Column(name = "costumer_birth", nullable = false)
    @NotBlank
    private Date costumerBirth;

    @Column(name = "costumer_zipcode", nullable = false, length = 9)
    @NotBlank
    private String costumerZipcode;

    @Column(name = "costumer_city", nullable = false)
    @NotBlank
    private String costumerCity;

    @Column(name = "costumer_state", nullable = false)
    @NotBlank
    private String costumerState;

    @Column(name = "costumer_address", nullable = false)
    @NotBlank
    private String costumerAddress;

    public UUID getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(UUID costumerId) {
        this.costumerId = costumerId;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public String getCostumerEmail() {
        return costumerEmail;
    }

    public void setCostumerEmail(String costumerEmail) {
        this.costumerEmail = costumerEmail;
    }

    public String getCostumerPhone() {
        return costumerPhone;
    }

    public void setCostumerPhone(String costumerPhone) {
        this.costumerPhone = costumerPhone;
    }

    public CostumerGender getCostumerGender() {
        return costumerGender;
    }

    public void setCostumerGender(CostumerGender costumerGender) {
        this.costumerGender = costumerGender;
    }

    public Date getCostumerBirth() {
        return costumerBirth;
    }

    public void setCostumerBirth(Date costumerBirth) {
        this.costumerBirth = costumerBirth;
    }

    public String getCostumerZipcode() {
        return costumerZipcode;
    }

    public void setCostumerZipcode(String costumerZipcode) {
        this.costumerZipcode = costumerZipcode;
    }

    public String getCostumerCity() {
        return costumerCity;
    }

    public void setCostumerCity(String costumerCity) {
        this.costumerCity = costumerCity;
    }

    public String getCostumerState() {
        return costumerState;
    }

    public void setCostumerState(String costumerState) {
        this.costumerState = costumerState;
    }

    public String getCostumerAddress() {
        return costumerAddress;
    }

    public void setCostumerAddress(String costumerAddress) {
        this.costumerAddress = costumerAddress;
    }
}
