
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        task1(5);
        task2("Hallo");
        task3();
        task4(3,37);
    }

    public static void task1(int length) {
        System.out.println("\nTask 1");
        double sum = 0;
        int minNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;

        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(201) - 100;
            sum+=array[i];
            if(array[i]>maxNumber) {
                maxNumber = array[i];
            }
            if(array[i]<minNumber) {
                minNumber = array[i];
            }
        }
        double avgNumber = sum/length; 
        System.out.println("\nМассив:");
        System.out.println(Arrays.toString(array));
        System.out.println("Минимальное: "+ minNumber+"\nМаксимально: "+ maxNumber + "\nСреднее значение: "+ avgNumber);
        
    }
    public static void task2(String word){
        System.out.println("\nTask 2");

        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : word.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        Boolean isHas = false;
        System.out.println("Слово: " + word);

        System.out.print("Повторяющиеся символы:");
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > 1) {
                isHas = true;
                System.out.print(entry.getKey() + " ");
            }
        }

        String answer = isHas ? ";" : " нету";
        System.out.println(answer);
    }
    public static void task3(){
        System.out.println("\nTask 3");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите температуру в градусах Цельсия: ");
            double celsius = scanner.nextDouble();

            boolean validInput = false;
            String target = "";
            while (!validInput) {
                System.out.print("Введите (1-2) единицу измерения для конвертации: \n1. Кельвин \n2. Фаренгейт\n");
                String choice = scanner.next();

                switch (choice) {
                    case "1" -> {
                        target = "kelvin";
                        validInput = true;
                    }
                    case "2" -> {
                        target = "fahrenheit";
                        validInput = true;
                    }
                    default -> System.out.println("Некорректный ввод.");
                }
            }
            BaseConverter converter = new BaseConverter(celsius);
            double result = converter.convert(target);

            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    public static void task4(int hours, int minutes){
        System.out.println("\nTask 4");
        if (hours < 0 || hours > 12 || minutes < 0 || minutes >= 60) {
            System.out.println("Часы должны быть от 0 до 12, минуты — от 0 до 60");
            return;
        }
        System.out.println(hours + " часов " + minutes + " минут");

        System.out.println("Угол равен: "+corner(hours,minutes));
    }
    private static double corner(int hours,int minutes){
        double pointH =  360/12 * hours;
        double pointM =  360/60 * minutes;

        double corner = pointH > pointM ? pointH - pointM: pointM - pointH;
        return corner;
    }
}