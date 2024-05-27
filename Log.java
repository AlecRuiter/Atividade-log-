import java.io.BufferedWriter;
//  guarda o texto em um "buffer", Quando o buffer está cheio ou quando você termina de escrever, 
//todo o conteúdo é enviado para o arquivo de uma vez só. 

import java.io.FileWriter;
// cada pequena parte do texto é escrita diretamente no arquivo imediatamente.

import java.io.IOException;
//A IOException no Java é como uma notificação de que algo deu errado 

import java.util.Scanner;

public class Log {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filename = "Log.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            System.out.println("Digite aqui, seu texto. Digite 'sair' para finalizar o processo.");
            while (true) {
                System.out.print("Entrada: ");
                String input = scanner.nextLine();  

                if (input.equalsIgnoreCase("sair")) {
                    break;
                }

                writer.write(input);
                writer.newLine();
                writer.flush(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();  
        }
    }
}