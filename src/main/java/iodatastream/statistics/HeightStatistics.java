package iodatastream.statistics;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HeightStatistics {
    public void saveHeights(List<Integer> heights, Path path){
        try (DataOutputStream ds = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            ds.writeInt(heights.size());
            for(int i : heights){
                ds.writeInt(i);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }

}
