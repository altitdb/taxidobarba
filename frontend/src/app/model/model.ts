class Driver {
    id: string;
    name: string;
}

class Car {
    id: string;
    name: string;
}

class CityRequest {
    car: string;
    driver: string;
    totalReceived: DoubleRange;
    date: Date;
    startKm: BigInteger;
    endKm: BigInteger;
    otherKm: BigInteger;
}

class CityResponse {
    car: Car;
    driver: Driver;
    priceKmDriver: DoubleRange;
    km: BigInteger;
    price: DoubleRange;
    totalReceived: DoubleRange;
    difference: DoubleRange;
    date: Date;
    startKm: BigInteger;
    endKm: BigInteger;
    otherKm: BigInteger;
}

class TravelRequest {
    car: string;
    driver: string;
    price: DoubleRange;
    city: string;
    date: Date;
    km: BigInteger;
}

class TravelResponse {
    car: Car;
    driver: Driver;
    percentualDriver: DoubleRange;
    valueDriver: DoubleRange;
    city: string;
    price: DoubleRange;
    netValue: DoubleRange;
    km: BigInteger;
    ageragePriceKm: DoubleRange;
    date: Date;
}