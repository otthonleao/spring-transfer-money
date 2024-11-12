package dev.otthon.transfermoney.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "TB_WALLET_TYPE")
public class WalletType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public WalletType() {
    }

    public WalletType(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletType that = (WalletType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "WalletType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    public enum Enum {
        CUSTOMER_PF(1L, "Pessoa Física"),
        CUSTOMER_PJ(2L, "Pessoa Jurídica");

        private long id;
        private String description;

        Enum(long id, String description) {
            this.id = id;
            this.description = description;
        }

        public WalletType get() {
            return new WalletType(id, description);
        }
    }
}
