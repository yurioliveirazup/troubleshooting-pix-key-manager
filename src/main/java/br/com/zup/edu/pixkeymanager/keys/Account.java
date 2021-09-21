package br.com.zup.edu.pixkeymanager.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Embeddable
public class Account {

    @NotBlank
    @Column(name = "financial_institution", nullable = false)
    private String institution;

    @NotBlank
    @Column(name = "owner_name", nullable = false)
    private String owner;

    @NotBlank
    @Size(max = 11)
    @Column(name = "owner_document", length = 11, nullable = false)
    private String document;

    @NotBlank
    @Size(max = 4)
    @Column(name = "bank_branch", length = 4, nullable = false)
    private String branch;

    @NotBlank
    @Size(max = 6)
    @Column(name = "account_number", length = 6, nullable = false)
    private String number;

    public Account(String institution,
                   String owner,
                   String document,
                   String branch,
                   String number) {
        this.institution = institution;
        this.owner = owner;
        this.document = document;
        this.branch = branch;
        this.number = number;
    }

    /**
     * @deprecated hibernate eyes only
     */
    @Deprecated
    Account() { }

    public String getInstitution() {
        return institution;
    }

    public String getOwner() {
        return owner;
    }

    public String getDocument() {
        return document;
    }

    public String getBranch() {
        return branch;
    }

    public String getNumber() {
        return number;
    }
}
