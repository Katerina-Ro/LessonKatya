import java.util.Comparator;

public class TransportProbegComparator implements Comparator <Transport> {
    @Override
    public int compare(Transport o1, Transport o2) {
        return o1.probeg.compareTo(o2.probeg);
    }
}




