import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jesper on 21-7-2014.
 */
public class StreamAnalyser {

    private long highestProduct = 0;
    ArrayList<Integer> streamList = new ArrayList<Integer>();

    public long getHighestProduct(String stream, int windowLength) {
        setStreamList(stream);
        defineHighestProduct(windowLength);
        return highestProduct;
    }

    private void defineHighestProduct(int windowLength) {
        long newProduct, loops;
        loops = 0;
        for (int i = 0; i < streamList.size() - windowLength; i++) {
            loops++;
            newProduct = 1;
            for (int j = 0; j < windowLength; j++) {
                newProduct = newProduct * streamList.get(i + j);
            }

            if (newProduct > highestProduct) {
                highestProduct = newProduct;
                System.out.println(highestProduct);
            }
        }
    }

    private void setStreamList(String stream) {
        for (int i = 0; i < stream.length(); i++) {
            Scanner scanner = new Scanner(stream.substring(i, i + 1));
            streamList.add(scanner.nextInt());
        }
    }
}


