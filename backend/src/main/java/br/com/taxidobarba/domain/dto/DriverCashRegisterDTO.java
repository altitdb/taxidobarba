package br.com.taxidobarba.domain.dto;

public class DriverCashRegisterDTO {

    private String id;
    private String name;

    public static class DriverCashRegisterBuilder {

        DriverCashRegisterDTO dto;

        public DriverCashRegisterBuilder() {
            dto = new DriverCashRegisterDTO();
        }

        public DriverCashRegisterBuilder withId(String id) {
            dto.id = id;
            return this;
        }

        public DriverCashRegisterBuilder withName(String name) {
            dto.name = name;
            return this;
        }

        public DriverCashRegisterDTO build() {
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
