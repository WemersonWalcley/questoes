import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Questoes {

    //########################################################################
    //##############################  QUESTÃO 1 ##############################
    //########################################################################

    public void questaoUm() {

        Scanner input = new Scanner(System.in); // Instância da entrada de dados

        System.out.print("\n### Questão 1 ###\n" +
                "Digite o tamanho da escada: ");
        int entrada = input.nextInt();

        System.out.println(); // pula linha

        for (int i = 0; i < entrada; i++) { // Define o tamanho da escada

            for (int j = i + 1; j < entrada; j++) {
                System.out.print(" ");  // Imprime os espaços necessários de forma decrescente
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");  // Imprime os asterisco de forma crescente
            }

            System.out.println(); // pula linha
        }
    }

    //########################################################################
    //##############################  QUESTÃO 2 ##############################
    //########################################################################

    public void questaoDois() {

        Scanner input = new Scanner(System.in); // Instância da entrada de dados
        String password;
        System.out.print("\n#Sua senha precisa ter no mínimo 6 caracters.\n" +
                "#Precisa possuir ao menos UM dígito\n" +
                "#Conter ao menos UMA letra maiúscula\n" +
                "#Conter ao menos UMA letra minúscuta\n" +
                "#Conter, no mínimo, UM caractere especial.\n\n" +
                "Digite a senha: ");
        password = input.nextLine();

        // Caracters necessários para validação da senha
        String requiredPassword = "^(?:(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&*()_+]).*)$";

        do {

            if (password.length() < 6) { // Verifica se a senha tem o mínimo de 6 caracters e imprime quantos faltam
                System.out.print("\nSenha inválida!\n" +
                        "Faltam " + (6 - password.length()) +
                        " caracters para sua senha ser considerada segura.\n" +
                        "Senha atual: " + password +
                        "\n\nDigite a senha: ");
                password = password + input.nextLine();
            }

            if (password.length() >= 6 && !password.matches(requiredPassword)) { // Verifica se a senha contém os caracters necessários para validação
                System.out.print("\nSenha não atende aos requisitos!\n" +
                        "#Sua senha precisa possuir ao menos UM dígito\n" +
                        "#Conter ao menos UMA letra maiúscula\n" +
                        "#Conter ao menos UMA letra minúscuta\n" +
                        "#Conter, no mínimo, UM caractere especial.\n" +
                        "Por favor, digite uma senha válida.\n" +
                        "Senha atual: " + password +
                        "\n\nDigite a senha: ");
                password = password + input.nextLine();
            }

            if (password.length() >= 6 && password.matches(requiredPassword)) { // Se a senha atender aos requisitos, printa o valor e encerra a aplicação
                System.out.println("\nA senha é: " + (password));
                System.out.println("Senha válida!");
            }

        } while (password.length() < 6 || !password.matches(requiredPassword)); // Enquanto a senha não atender aos requisitos exigidos, execute o loop

    }

    //########################################################################
    //##############################  QUESTÃO 3 ##############################
    //########################################################################

    public void questaoTres() {

        Scanner input = new Scanner(System.in);

        System.out.print("\nInforme a String a ser verificada: ");
        String entrada = input.nextLine();
        char[] word;
        int anagramCount = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < entrada.length(); i++) { //Define, através da entrada de dados, a quantidade de vezes que acontecerá o loop
            for (int j = i; j < entrada.length(); j++) {
                word = entrada.substring(i, j + 1).toCharArray(); //Variável word recebe as combinações possíveis através do método substring, usando o I e o J como parâmetros
                Arrays.sort(word); //Metodo que ordena os dados dentro do array
                String validation = new String(word);
                if (map.containsKey(validation)){ //Verifica, através do método containsKey, se o parâmetro passado existe dentro do map
                    map.put(validation, map.get(validation) + 1); //Caso exista, aumenta o contador em +1 no conjunto compatível
                }
                else {
                    map.put(validation, 1); //Caso o parâmetro não exista, adiciona ao map os dados atuais contidos na variável validation e adiciona 1 ao valor do conjunto
                }
            }
        }

        for (String key : map.keySet()) { // Adiciona a variável key, em ordem, os valores contidos no map
            int i = map.get(key); //Variável i recebe o inteiro dentro do keyset atual
            anagramCount += (i * (i - 1)) / 2; //Se i for igual a 2, a contagem de anagramas pares recebe 1
        }

        System.out.println("\nO número de anagramas pares é: " + anagramCount);
    }
}



