package za.ac.cput.domain.lookup;

/*
 * @author Karl Haupt (220236585)
 * Kit.java -> is an entity in the problem domain to store the various kit(s) that team(s) can wear.
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Kit {
    @NotNull @Id
    private String kitType = "Default";
    @NotNull
    private String kitColor, kitBrand;

    protected Kit() {}

    private Kit(Builder builder) {
        this.kitType = builder.kitType;
        this.kitColor = builder.kitColor;
        this.kitBrand = builder.kitBrand;
    }

    public String getKitType() {
        return kitType;
    }

    public String getKitColor() {
        return kitColor;
    }

    public String getKitBrand() {
        return kitBrand;
    }

    @Override
    public String toString() {
        return "Kit{" +
                "kitType='" + kitType + '\'' +
                ", kitColor='" + kitColor + '\'' +
                ", kitBrand='" + kitBrand + '\'' +
                '}';
    }



    public static class Builder {
        private String kitType;
        private String kitColor;
        private String kitBrand;

        public Builder setKitType(String kitType) {
            this.kitType = kitType;
            return this;
        }

        public Builder setKitColor(String kitColor) {
            this.kitColor = kitColor;
            return this;
        }

        public Builder setKitBrand(String kitBrand) {
            this.kitBrand = kitBrand;
            return this;
        }

        public Builder copy(Kit kit) {
            this.kitType = kit.kitType;
            this.kitColor = kit.kitColor;
            this.kitBrand = kit.kitBrand;
            return this;
        }

        public Kit build() {
            return new Kit(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kit kit = (Kit) o;
        return Objects.equals(kitType, kit.kitType) && Objects.equals(kitColor, kit.kitColor) && Objects.equals(kitBrand, kit.kitBrand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kitType, kitColor, kitBrand);
    }
}
