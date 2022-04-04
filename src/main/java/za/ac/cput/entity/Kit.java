package za.ac.cput.entity;

/*
 * Karl Haupt (220236585)
 * Kit.java -> is an entity in the problem domain to store the various kit(s) that team(s) can wear.
 */

public class Kit {
    private String kitType;
    private String kitColor;
    private String kitBrand;

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
}
