public class FuelCosts {
    double cost_of_a_liter_of_fuel_passenger_transport = 47.50;
    double cost_of_a_liter_of_fuel_cranes = 48.90;
    double cost_of_a_liter_of_fuel_car = 46.10;
    double cost_of_a_liter_of_fuel_truck = 48.90;

    double fuel_consumption_per_100_km_truck = 12;
    double fuel_consumption_per_100_km_passenger_transport = 11.5;
    double fuel_consumption_per_100_km_cranes = 20;
    double fuel_consumption_per_100_km_car = 12.5;

    double cost_of_expenses_for_fuel_transport = 0.0;

    public FuelCosts() {
    }

    double calculationFuelCosts(Transport t) {

        switch (t.type_transport) {
            case "Легковой":
                double fuel_consumption_per_1_km_car = fuel_consumption_per_100_km_car / 100;
                cost_of_expenses_for_fuel_transport = t.probeg * fuel_consumption_per_1_km_car * cost_of_a_liter_of_fuel_car;
                break;

            case "Грузовой":
                double fuel_consumption_per_1_km_truck = fuel_consumption_per_100_km_truck / 100;
                cost_of_expenses_for_fuel_transport = t.probeg * fuel_consumption_per_1_km_truck * cost_of_a_liter_of_fuel_truck;
                break;

            case "Пассажирский":
                double fuel_consumption_per_1_km_passenger_transport = fuel_consumption_per_100_km_passenger_transport / 100;
                cost_of_expenses_for_fuel_transport = t.probeg * fuel_consumption_per_1_km_passenger_transport * cost_of_a_liter_of_fuel_passenger_transport;
                break;

            default:
                double fuel_consumption_per_1_km_cranes = fuel_consumption_per_100_km_cranes / 100;
                cost_of_expenses_for_fuel_transport = t.probeg * fuel_consumption_per_1_km_cranes * cost_of_a_liter_of_fuel_cranes;
                break;
        }
        return cost_of_expenses_for_fuel_transport;
    }

    @Override
    public String toString() {
        return "FuelCosts{" +
                "Стоимость литра топлива для пассажирского транспорта = " + cost_of_a_liter_of_fuel_passenger_transport +
                ", стоимость литра топлива для тяжелой техники = " + cost_of_a_liter_of_fuel_cranes +
                ", стоимость литра топлива для легкового автомобиля = " + cost_of_a_liter_of_fuel_car +
                ", стоимость литра топлива для грузового автомобиля = " + cost_of_a_liter_of_fuel_truck +
                ", расход топлива на 100 км у грузового автомобиля = " + fuel_consumption_per_100_km_truck +
                ", расход топлива на 100 км у пассажирского транспорта = " + fuel_consumption_per_100_km_passenger_transport +
                ", расход топлива на 100 км у тяжелой техники = " + fuel_consumption_per_100_km_cranes +
                ", расход топлива на 100 км у легкового автомобиля = " + fuel_consumption_per_100_km_car +
                '}';
    }
}
