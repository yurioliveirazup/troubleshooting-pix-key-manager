package br.com.zup.edu.pixkeymanager.keys;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

import static java.time.LocalDateTime.now;
import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "pix_key",
        uniqueConstraints = { @UniqueConstraint(
                name = "uk_pix_key",
                columnNames = { "key" }
        ) }
)
public class PixKey {

    @Id
    private UUID id = UUID.randomUUID();

    @NotNull
    private UUID clientId;

    @NotNull
    @Enumerated(STRING)
    private KeyType type;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String key;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

    @NotNull
    @Embedded
    private Account account;


    @Column(nullable = false)
    private LocalDateTime createdAt = now();

    public PixKey(UUID clientId,
                  KeyType type,
                  String key,
                  AccountType accountType,
                  Account account) {

        this.clientId = clientId;
        this.type = type;
        this.key = key;
        this.accountType = accountType;
        this.account = account;
    }

    /**
     * @deprecated hibernate eyes only
     */
    @Deprecated
    PixKey() { }

    public UUID getId() {
        return id;
    }

    public UUID getClientId() {
        return clientId;
    }

    public KeyType getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Account getAccount() {
        return account;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
