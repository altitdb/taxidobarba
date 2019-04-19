package br.com.taxidobarba.domain.dto;

public class CarCashRegisterDTO {

    private String id;
    private String name;

    public static class CarCashRegisterBuilder {

        private CarCashRegisterDTO dto;

        public CarCashRegisterBuilder() {
            dto = new CarCashRegisterDTO();
        }

        public CarCashRegisterBuilder withId(String id) {
            dto.id = id;
            return this;
        }

        public CarCashRegisterBuilder withName(String name) {
            dto.name = name;
            return this;
        }

        public CarCashRegisterDTO build() {
            return dto;
        }

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
