import java.util.Scanner;

class MarksException extends Exception {
    public MarksException(String msg) {
        super(msg);
    }
}

class abc {
    int eng = 0, maths = 0, science = 0, social = 0, hindi = 0, total;
    double percent;

    void info() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter marks in English (out of 100)");
            eng = check(scan.nextInt());

            System.out.println("Enter marks in Maths (out of 100)");
            maths = check(scan.nextInt());

            System.out.println("Enter marks in Science (out of 100)");
            science = check(scan.nextInt());

            System.out.println("Enter marks in Social studies (out of 100)");
            social = check(scan.nextInt());

            System.out.println("Enter marks in Hindi (out of 100)");
            hindi = check(scan.nextInt());

        } catch (MarksException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    int check(int marks) throws MarksException {
        if (marks < 0 || marks > 100) {
            throw new MarksException("The marks you have entered is inappropriate.Enter valid details");
        }
        return marks;
    }

    void sum() {
        total = eng + maths + social + science + hindi;
        percent = (total / 5);
        System.out.println("Total marks of the student are " + total + " out of 500");

        System.out.println("Average Percentage of the student is " + percent + "%");

        if (percent >= 90 && percent <= 100) {
            System.out.println("Grade is A+");
        } else if (percent >= 80) {
            System.out.println(" Grade is A");
        } else if (percent >= 70) {
            System.out.println(" Grade is B+");
        } else if (percent >= 60) {
            System.out.println("Grade is B");
        } else if (percent >= 50) {
            System.out.println("Grade is C+");
        } else if (percent >= 40) {
            System.out.println("Grade is C");
        } else {
            System.out.println("FAIL");
        }
    }
}

class StudentGradeCalculator {
    public static void main(String args[]) {
        abc a = new abc();
        a.info();
        a.sum();
    }
}
