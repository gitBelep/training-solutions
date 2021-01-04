package exceptions.faults;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FaultList {

    public List<String> processLines(List<String> lines) {
        List<String> faults = new ArrayList<>();
        int number = 0;

        if (lines == null) {
            throw new IllegalArgumentException("Null list");
        }

        for (String s : lines) {
            try {
                number = Integer.parseInt(s.substring(0, s.indexOf(",")).trim());
            } catch (NumberFormatException ex) {
                continue;
            }
            String[] datas = s.split(",");
            if (datas.length == 3) {
                ProcessingResult f = checkData(datas);
                if (f != ProcessingResult.NO_ERROR) {
                    faults.add(number + "," + f.getCode());
                    continue;
                }
            } else {
                faults.add(number + ",2");
            }
        }
        return faults;
    }

    private ProcessingResult checkData(String[] datas) {
        double d = 0;
        try {
            d = Double.parseDouble(datas[1]);
        } catch (NumberFormatException dnfx) {
            System.out.println("double: "+ dnfx);
        }
        LocalDate ld = null;
        try {
            String[] date = datas[2].split("[.]");
            ld = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        } catch (NumberFormatException dnfx) {
            System.out.println("Date: "+ dnfx);
        }
        if (d == 0) {
            if (ld == null) {
                return ProcessingResult.VALUE_AND_DATE_ERROR;
            } else {
                return ProcessingResult.VALUE_ERROR;
            }
        } else if (ld == null) {
            return ProcessingResult.DATE_ERROR;
        }
        return ProcessingResult.NO_ERROR;
    }

}


