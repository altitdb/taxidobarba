class Driver {
    id: string;
    name: string;
}

class Car {
    id: string;
    name: string;
}

class CityResponse {
    id: string;
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
    id: string;
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
    id: string;
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
    grossValue: number;
    netValue: number;
}

class MonthlyReport {
    report: Array<MonthlyReportItem>
    amount: Amount;
}

class AnnualSummaryItem {
    month: string;
    grossValue: number;
    netValue: number;
}

class AmountAnnualSummary {
    grossValue: number;
    netValue: number;
}

class AnnualSummary {
    annualSummary: Array<AnnualSummaryItem>;
    amount: AmountAnnualSummary;   
}

class MonthlyGoalItem {
    date: Date;
    goal: number;
    lastMonth: number;
    actualMonth: number;
    percentage: number;
}

class MonthGoalSummary {
    goal: number;
    lastMonth: number;
    actualMonth: number;
    percentage: number;
}

class MonthlyGoal {
    goal: Array<MonthlyGoalItem>;
    summary: MonthGoalSummary;
}