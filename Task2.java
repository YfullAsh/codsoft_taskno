import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println("This a Grade Calculator");
        System.out.println("If You want to calculate your Grade on the basis of your Percentage,please proceed");
        System.out.println("===================================");

        Scanner sc = new Scanner(System.in);

        int a = getValidMark(sc, 1);
        int b = getValidMark(sc, 2);
        int c = getValidMark(sc, 3);
        int d = getValidMark(sc, 4);
        int e = getValidMark(sc, 5);

        if (a < 0 || a > 100 ||
                b < 0 || b > 100 ||
                c < 0 || c > 100 ||
                d < 0 || d > 100 ||
                e < 0 || e > 100) {
            System.out.println("Invalid input! Marks should be between 0 and 100.");
            return;
        }

        int totalMarks = 500;
        int marksObtained = a+b+c+d+e;

        float percentage = ((float) marksObtained /totalMarks) * 100;

        System.out.println("You Scored " + marksObtained + " out of 500");
        System.out.println("And Your Percentage is " + percentage);

        if (percentage>=95){
            System.out.println("Congratulations! Your Grade is A+");
        }
        else if (percentage>=90) {
            System.out.println("Congratulations! Your Grade is A");
        }
        else if (percentage>=80) {
            System.out.println("Congratulations! Your Grade is B+");
        }
        else if (percentage>=70) {
            System.out.println("Congratulations! Your Grade is B");
        }
        else if (percentage>=60) {
            System.out.println("Good Your Grade is C+");
        }
        else if (percentage>=50) {
            System.out.println("Good Your Grade is C");
        }
        else if (percentage>=40) {
            System.out.println("And Your Grade is D+");
        }
        else if (percentage>=33) {
            System.out.println("And Your Grade is D");
        }
        else System.out.println("Sorry! You failed the Exam");
    }

    public static int getValidMark(Scanner sc, int subjectNumber) {
        int mark;
        while (true) {
            System.out.println("Enter your Marks of Subject " + subjectNumber);
            mark = sc.nextInt();
            if (mark >= 0 && mark <= 100) {
                break;
            } else {
                System.out.println("Invalid input! Marks should be between 0 and 100. Please try again.");
            }
        }
        return mark;
    }

}


