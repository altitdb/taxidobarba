class Driver {
    id: string;
    name: string;
}

class Car {
    id: string;
    name: string;
}

class CityResponse {
    car: Car;
    driver: Driver;
    priceKmDriver: number;
    km: BigInteger;
    price: number;
    totalReceived: number;
    difference: number;
    date: Date;
    startKm: BigInteger;
    endKm: BigInteger;
    otherKm: BigInteger;
}

class TravelResponse {
    car: Car;
    driver: Driver;
    percentualDriver: number;
    valueDriver: number;
    city: string;
    price: number;
    netValue: number;
    km: BigInteger;
    ageragePriceKm: number;
    date: Date;
}

class FuelResponse {
    car: Car;
    driver: Driver;
    price: number;
    km: BigInteger;
    date: Date;
    liters: number;
    fuelPrice: number
}

enum MonthlyType {
    CITY = 'Cidade',
    TRAVEL = 'Viagem'
}

class MonthlyReportItem {
    date: Date;
    value: number;
    km: BigInteger;
    type: MonthlyType;
    driver: string;
}

class Amount {
    amount: number;
}

class MonthlyReport {
    report: Array<MonthlyReportItem>
    amount: Amount;
}