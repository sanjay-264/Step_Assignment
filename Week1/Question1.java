public class Question1 {
    public static void checkDuplicateSeats(int[] seatNumbers) {

        boolean foundDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {

            for (int j = i + 1; j < seatNumbers.length; j++) {

                if (seatNumbers[i] == seatNumbers[j]) {

                    System.out.println("Duplicate seat number: " + seatNumbers[i]);
                    foundDuplicate = true;
                    break;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {

        int[] seatNumbers = {101, 102, 103, 102, 104, 101};

        checkDuplicateSeats(seatNumbers);
    }
}