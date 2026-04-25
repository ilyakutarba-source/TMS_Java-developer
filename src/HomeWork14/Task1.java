/**
 * @author Ilya
 * @date 20.04.2026
 */
package HomeWork14;

import java.io.*;


public class Task1 {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("romeo.txt"))) {
            bw.write("O Romeo, Romeo! wherefore art thou Romeo?");
        } catch (IOException e) {
            System.out.println("Ошибка записи исходного файла");
        }

        String longestWord = "";

        // 2. Читаем файл и ищем самое длинное слово
        try (BufferedReader br = new BufferedReader(new FileReader("romeo.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {

                // очищаем строку от знаков
                line = line.replaceAll("[^a-zA-Z ]", "");

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }

        // 3. Записываем результат в другой файл
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"))) {
            bw.write("Самое длинное слово: " + longestWord);
        } catch (IOException e) {
            System.out.println("Ошибка записи результата");
        }

        System.out.println("Самое длинное слово: " + longestWord);
    }
}