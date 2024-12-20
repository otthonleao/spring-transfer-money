package dev.otthon.transfermoney.dtos;

import dev.otthon.transfermoney.entities.Wallet;
import dev.otthon.transfermoney.entities.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

public class CreateWalletDTO {

    private Long id;

    @NotBlank
    private String fullName;

    @NotBlank
    private String cpfCnpj;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private WalletType walletType;

    public CreateWalletDTO() {
    }

    public CreateWalletDTO(Wallet entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public WalletType getWalletType() {
        return walletType;
    }

    public void setWalletType(WalletType walletType) {
        this.walletType = walletType;
    }
}
