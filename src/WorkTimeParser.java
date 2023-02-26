public class WorkTimeParser {

    public static String[][] prepareWorkTime(String[][] grafic) {
        if (grafic.length == 0) {
            return grafic;
        }
        final int COLUMNS_NUMBER = 8;
        var result = new String[grafic.length][COLUMNS_NUMBER];

        var index = 1;
        result[0] = grafic[0];
        for (int i = 1; i < grafic.length; i++) {
            var isRepeated = false;
            for (int j = 0; j < index + 1; j++) {
                // if names are equal
                if (grafic[i][0].equals(result[j][0])) {
                    for (int k = 1; k < COLUMNS_NUMBER; k++) {
                        var timeA = grafic[i][k];
                        var timeB = result[j][k];
                        result[j][k] = combineTimes(timeA, timeB);
                    }
                    isRepeated = true;
                    break;
                }
            }
            // if not repeated add to the end of array
            if (!isRepeated) {
                result[index] = grafic[i];
                index++;
            }
        }
        return result;
    }

    private static String combineTimes(String a, String b) {
        if (a.isEmpty()) {
            return b;
        }
        if (b.isEmpty()) {
            return a;
        }

        try {
            int startA = Integer.parseInt(a.substring(0, 2));
            int endA = Integer.parseInt(a.substring(6, 8));

            int startB = Integer.parseInt(b.substring(0, 2));
            int endB = Integer.parseInt(b.substring(6, 8));

            // 6 possible conditions:
            if (startA <= startB) {
                if (startB <= endA) {
                    if (endB <= endA) {
                        // 1: A: 8-12 + B: 12-16 = 8-16
                        return String.format("%02d:00-%02d:00", startA, endA);
                    } else {
                        // 2: A: 8-12 + B: 10-16 = 8-16
                        return String.format("%02d:00-%02d:00", startA, endB);
                    }
                } else {
                    // 3: A: 8-12 + B: 14-16 = 8-12, 14-16
                    return String.format("%02d:00-%02d:00,%02d:00-%02d:00", startA, endA, startB, endB);
                }
            } else {
                // else startB < startA
                if (startA <= endB) {
                    if (endA <= endB) {
                        // 4: B: 8-12 + A: 12-16 = 8-16
                        return String.format("%02d:00-%02d:00", startB, endB);
                    } else {
                        // 5: B: 8-12 + A: 10-16 = 8-16
                        return String.format("%02d:00-%02d:00", startB, endA);
                    }
                } else {
                    // 6: B: 8-12 + A: 14-16 = 8-12, 14-16
                    return String.format("%02d:00-%02d:00,%02d:00-%02d:00", startB, endB, startA, endA);
                }
            }
        } catch (Exception e) {
            return "Please provide valid time!";
        }

    }
    
    
}
