package br.com.taxidobarba.domain.dto;

public class CarResponseDTO {

    private String id;
    private String name;
    private String licensePlate;

    public static class CarResponseBuilder {

        private CarResponseDTO dto;

        public CarResponseBuilder() {
            dto = new CarResponseDTO();
        }

        public CarResponseBuilder withId(String id) {
            dto.id = id;
            return this;
        }

        public CarResponseBuilder withName(String name) {
            dto.name = name;
            return this;
        }

        public CarResponseBuilder withLicensePlate(String licensePlate) {
            dto.licensePlate = licensePlate;
            return this;
        }

        public CarResponseDTO build() {
            return dto;
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

}
