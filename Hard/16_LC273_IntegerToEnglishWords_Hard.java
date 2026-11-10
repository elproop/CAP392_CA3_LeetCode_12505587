class Solution {

    private static final String[] BELOW_20 = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"
    };

    private static final String[] TENS = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] THOUSANDS = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        int index = 0;
        StringBuilder result = new StringBuilder();

        while (num > 0) {

            if (num % 1000 != 0) {

                String chunk = helper(num % 1000);

                if (!THOUSANDS[index].isEmpty()) {
                    chunk += " " + THOUSANDS[index];
                }

                if (result.length() == 0) {
                    result.insert(0, chunk);
                } else {
                    result.insert(0, chunk + " ");
                }
            }

            num = num / 1000;
            index++;
        }

        return result.toString();
    }

    private String helper(int num) {

        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return BELOW_20[num];
        }

        if (num < 100) {
            return TENS[num / 10] +
                   (num % 10 == 0 ? "" : " " + BELOW_20[num % 10]);
        }

        return BELOW_20[num / 100] + " Hundred" +
               (num % 100 == 0 ? "" : " " + helper(num % 100));
    }
}