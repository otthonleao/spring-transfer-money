package dev.otthon.transfermoney.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

@Entity
@Table(name = "TB_WALLET")
public class Wallet {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "CPF_CNPJ", unique = true)
    private String cpfCnpj;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CURRENCY")
    private Currency currency = Currency.getInstance("BRL");

    @Column(name = "BALANCE")
    private BigDecimal balance;

    @Column(name = "TRANSACTION_LIMIT")
    private BigDecimal transactionLimit = getBalance();

    @ManyToOne
    @JoinColumn(name = "WALLET_TYPE_ID")
    private WalletType walletType;

    public Wallet() {
    }

    public Wallet(Long id, String fullName, String cpfCnpj, String email, String password, Currency currency, BigDecimal balance, BigDecimal transactionLimit, WalletType walletType) {
        this.id = id;
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.currency = currency;
        this.balance = balance;
        this.transactionLimit = transactionLimit;
        this.walletType = walletType;
    }

    public boolean isTransferAllowedForWalletType() {
        return this.walletType.equals(WalletType.Enum.CUSTOMER_PF.get());
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(BigDecimal transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public WalletType getWalletType() {
        return walletType;
    }

    public void setWalletType(WalletType walletType) {
        this.walletType = walletType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", currency=" + currency +
                ", balance=" + balance +
                ", transactionLimit=" + transactionLimit +
                ", walletType=" + walletType +
                '}';
    }
}
