public class Transport {
    String type_transport;
    Integer number_auto;
    Integer probeg;
    Integer param;

    public Transport(String type_transport, int number_auto, int probeg, int param) {
        this.type_transport = type_transport;
        this.number_auto = number_auto;
        this.probeg = probeg;
        this.param = param;
    }
    @Override
    public String toString() {
        return "Transport{" +
                " Тип транспорта = " + type_transport +
                ", государственный номер = " + number_auto +
                ", пробег = " + probeg +
                ", дополнительный параметр = " + param +
                '}';
    }
}

