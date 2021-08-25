import java.util.*;

public class FuelAccounting {
    static String[] array = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
    static List<Transport> listTransport = new ArrayList<>();

    public static void main(String[] args) {
        //Перемещаем данные из строкового массива в список типа Transport
        for (int j = 0; j < array.length; j++) {
            int firstIndex_ = array[j].indexOf("_");
            String codeCar = array[j].substring(0, firstIndex_);
            String type_transport_in_array = null; ////получили параметр type_transport для передачи в элемент (объект) списка

            switch (codeCar) {
                case "C100":
                    type_transport_in_array = "Легковой";
                    break;
                case "C200":
                    type_transport_in_array = "Грузовой";
                    break;
                case "C300":
                    type_transport_in_array = "Пассажирский";
                    break;
                case "C400":
                    type_transport_in_array = "Тяжелая техника";
                    break;
            }

            int firstindex = array[j].indexOf("-");
            int secondindex = array[j].lastIndexOf("-");

            int number_transport = Integer.valueOf(array[j].substring(firstIndex_ + 1, firstindex));  //получили параметр  number_auto для передачи в элемент (объект) списка
            int param2 = 0; //получили параметр param для передачи в элемент (объект) списка
            int probegCar = 0; //получили параметр probeg для передачи в элемент (объект) списка
            if (secondindex == firstindex) {
                probegCar = Integer.parseInt(array[j].substring(firstindex + 1));
            } else {
                probegCar = Integer.parseInt(array[j].substring(firstindex + 1, secondindex));
                param2 = Integer.parseInt(array[j].substring(secondindex + 1));
            }

            if (!listTransport.isEmpty()) {
                for (int i = 0; i < listTransport.size(); i++) {
                    boolean check = listTransport.get(i).type_transport.equals(type_transport_in_array) && listTransport.get(i).number_auto.equals(number_transport);
                    if (check == true) {
                        listTransport.get(i).probeg = listTransport.get(i).probeg + probegCar;
                        listTransport.get(i).param = listTransport.get(i).param + param2;
                        //System.out.println("изменяется элемент коллекции " + listTransport.get(i));
                        break;
                    } else if (!check == true && i == listTransport.size() - 1) {
                        Transport transport = new Transport(type_transport_in_array, number_transport, probegCar, param2);
                        listTransport.add(transport);
                        break;
                    } else {
                        continue;
                    }
                }
            } else {
                Transport transport = new Transport(type_transport_in_array, number_transport, probegCar, param2);
                listTransport.add(transport);
            }
        }

        //Получаем общую стоимость расходов на ГСМ и расходы на каждый класс авто
        FuelCosts fc = new FuelCosts();
        double cost_of_expenses_for_fuel_car = 0.0;
        double cost_of_expenses_for_fuel_truck = 0.0;
        double cost_of_expenses_for_fuel_passenger_transport = 0.0;
        double cost_of_expenses_for_fuel_cranes = 0.0;

        double cost_of_expenses_for_fuel_total = 0.0;

        for (Transport r : listTransport) {
            if (r.type_transport.equals("Легковой")) {
                cost_of_expenses_for_fuel_car = cost_of_expenses_for_fuel_car + fc.calculationFuelCosts(r);
            } else if (r.type_transport.equals("Грузовой")) {
                cost_of_expenses_for_fuel_truck = cost_of_expenses_for_fuel_truck + fc.calculationFuelCosts(r);
            } else if (r.type_transport.equals("Пассажирский")) {
                cost_of_expenses_for_fuel_passenger_transport = cost_of_expenses_for_fuel_passenger_transport + fc.calculationFuelCosts(r);
            } else {
                cost_of_expenses_for_fuel_cranes = cost_of_expenses_for_fuel_cranes + fc.calculationFuelCosts(r);
            }
            cost_of_expenses_for_fuel_total = cost_of_expenses_for_fuel_car + cost_of_expenses_for_fuel_truck + cost_of_expenses_for_fuel_passenger_transport + cost_of_expenses_for_fuel_cranes;
        }

        System.out.println("Стоимость расходов на ГСМ на все легковые автомобили = " + cost_of_expenses_for_fuel_car);
        System.out.println("Стоимость расходов на ГСМ на все грузовые автомобили = " + cost_of_expenses_for_fuel_truck);
        System.out.println("Стоимость расходов на ГСМ на весь пассажирский транспорт = " + cost_of_expenses_for_fuel_passenger_transport);
        System.out.println("Стоимость расходов на ГСМ на всю тяжелую технику = " + cost_of_expenses_for_fuel_cranes);
        System.out.println();
        System.out.println("Общая стоимость расходов на ГСМ на все виды транспорта = " + cost_of_expenses_for_fuel_total);
        System.out.println();

        //Получаем тип транспорта наибольшего и наименьшего значений
        List <Double> listValueCosts = new ArrayList <>();
        listValueCosts.add(cost_of_expenses_for_fuel_car);
        listValueCosts.add(cost_of_expenses_for_fuel_truck);
        listValueCosts.add(cost_of_expenses_for_fuel_passenger_transport);
        listValueCosts.add(cost_of_expenses_for_fuel_cranes);

        Double maxValueCosts = Collections.max(listValueCosts);
        String type_transport_max = null;
        if (maxValueCosts == cost_of_expenses_for_fuel_car) {
            type_transport_max = "Легковой автомобиль";
        } else if (maxValueCosts == cost_of_expenses_for_fuel_truck) {
            type_transport_max = "Грузовой автомобиль";
        } else if (maxValueCosts == cost_of_expenses_for_fuel_passenger_transport) {
            type_transport_max = "Пассажирский транспорт";
        } else {
            type_transport_max = "Тяжелая техника";
        }
        System.out.println("Тип авто, имеющий наибольшую стоимость расходов, - это " + type_transport_max);

        Double minValueCosts = Collections.min(listValueCosts);
        String type_transport_min = null;
        if (minValueCosts == cost_of_expenses_for_fuel_car) {
            type_transport_min = "Легковой автомобиль";
        } else if (minValueCosts == cost_of_expenses_for_fuel_truck) {
            type_transport_min = "Грузовой автомобиль";
        } else if (minValueCosts == cost_of_expenses_for_fuel_passenger_transport) {
            type_transport_min = "Пассажирский транспорт";
        } else {
            type_transport_min = "Тяжелая техника";
        }
        System.out.println("Тип авто, имеющий наименьшую стоимость расходов, - это " + type_transport_min);
        System.out.println();

        //Выводим информацию о транспорте по запросу с консоли
        Scanner in = new Scanner(System.in);
        System.out.println("Какой вид транспорта вас интересует: легковой, грузовой, пассажирский, тяжелая техника?");

        getInfoTransport(in.nextLine());
        in.close();
    }


    public static void getInfoTransport(String console_input) {
        Comparator<Transport> comparator = new TransportProbegComparator().thenComparing(new TransportParamComparator());
        Collections.sort(listTransport, comparator);

        for (Transport p : listTransport) {
            if (p.type_transport.equalsIgnoreCase(console_input)) {
                System.out.println(p);
            }
        }
    }
}





