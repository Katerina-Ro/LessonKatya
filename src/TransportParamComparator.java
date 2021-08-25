import java.util.Comparator;

public class TransportParamComparator implements Comparator<Transport> {
    @Override
    public int compare(Transport o1, Transport o2) {
        return o1.param.compareTo(o2.param);
    }
}