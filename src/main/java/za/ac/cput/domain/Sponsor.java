package za.ac.cput.domain;

/* Sponsor.java
   Entity for the Sponsor
   Author: Joshua Daniel Jonkers(215162668)
   Date: 08/04/2022
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Sponsor {
    @NotNull
    @Id
    private String roleID;
    @NotNull
    private String taxNumber;
    @NotNull
    private String companyName;

    private Sponsor(Sponsor.Builder builder) {
        this.roleID = builder.roleID;
        this.taxNumber = builder.taxNumber;
        this.companyName = builder.companyName;
    }

    public String getRoleID() {
        return roleID;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "roleID='" + roleID + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    public static class Builder {
        private String roleID;
        private String taxNumber;
        private String companyName;

        public Sponsor.Builder setRoleID(String roleID) {
            this.roleID = roleID;
            return this;
        }

        public Sponsor.Builder setTaxNumber(String taxNumber) {
            this.taxNumber = taxNumber;
            return this;
        }

        public Sponsor.Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Sponsor.Builder copy(Sponsor sponsor) {
            this.roleID = sponsor.roleID;
            this.taxNumber = sponsor.taxNumber;
            this.companyName = sponsor.companyName;
            return this;
        }

        public Sponsor build() {
            return new Sponsor(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Builder)) return false;
            Builder builder = (Builder) o;
            return roleID.equals(builder.roleID) && taxNumber.equals(builder.taxNumber) && companyName.equals(builder.companyName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(roleID, taxNumber, companyName);
        }
    }
}
