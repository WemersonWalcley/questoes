import java.util.Scanner;

public class MenuApplication {

    Questoes questoes = new Questoes();

    public void menu() {
        Scanner input = new Scanner(System.in);
        String inputMenu;
        boolean repeat;

        do {
            System.out.print("\n##--Menu--##\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| Questão - 1                 |\n");
            System.out.print("| Questão - 2                 |\n");
            System.out.print("| Questão - 3                 |\n");
            System.out.print("| Sair -    4                 |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");

            inputMenu = input.nextLine();

            switch (inputMenu) {
                case "1":
                    questoes.questaoUm();
                    repeat = true;
                    break;
                case "2":
                    questoes.questaoDois();
                    repeat = true;
                    break;
                case "3":
                    questoes.questaoTres();
                    repeat = true;
                    break;
                case "4":
                    System.out.println("Fim da aplicação.");
                    repeat = false;
                    break;
                default:
                    System.out.println("Valor inválido");
                    repeat = true;
            }
        } while (repeat);
    }

}
