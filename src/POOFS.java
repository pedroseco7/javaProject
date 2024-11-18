import java.util.ArrayList;
import java.util.Scanner;

public class POOFS {
    public static void main(String[] args) {

        // Listas de Clientes e Faturas
        ArrayList<Cliente> listClients = new ArrayList<>();
        ArrayList<Fatura> listInvoices = new ArrayList<>();

        // Scanners para Pausas e recolha de dados.
        Scanner pause = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        //region Menu

        // MENU  ////////////////////////////////////////////////////////////////
        int opcao;

        do {
            System.out.println("\nBem-vindo ao POO Financial Services.\n" +
                    "Escolha uma das opções:");
            System.out.println("[1] Criar e editar cliente");
            System.out.println("[2] Listar clientes");
            System.out.println("[3] Criar e editar faturas");
            System.out.println("[4] Listar faturas");
            System.out.println("[5] Visualizar fatura");
            System.out.println("[6] Importar e exportar faturas");
            System.out.println("[7] Estatísticas");
            System.out.println("[0] Sair");
            System.out.print("\nSelecione uma opção: ");

            //Garante que a opção seja um nº do tipo inteiro
            while(!input.hasNextInt()){
                input.next();
                System.out.println("Opção inválida! Tente novamente");
                System.out.print("Selecione uma opção: ");
            }
            opcao = input.nextInt();
            input.nextLine();   // Limpeza do canal de entrada

            switch (opcao) {

                case 1:

                    //region Criar e editar CLIENTE
                    do {
                        // SubMENU do Cliente
                        System.out.println();
                        System.out.println("[1] Criar Cliente");
                        System.out.println("[2] Editar Cliente");
                        System.out.println("[3] Voltar");
                        System.out.print("\nSelecione uma opção: ");
            
                        // Garante que a opção seja um nº do tipo inteiro
                        while (!input.hasNextInt()) {
                            input.next();
                            System.out.println("Opção inválida! Tente novamente");
                            System.out.print("Selecione uma opção: ");
                        }
                        opcao = input.nextInt();
                        input.nextLine();   // Limpeza do canal de entrada
            
                        switch (opcao) {
            
                            case 1:
                                // Criar CLIENTE
                                System.out.println("\n-- Cliente a adicionar --");
            
                                // Pede e recebe o nome
                                System.out.print("Indique o nome: ");
                                String name = input.nextLine();
            
                                // Pede e recebe o nif
                                System.out.print("Indique o nif: ");
                                int nif;

                                while (!input.hasNextInt()) {
                                    input.next();
                                    System.out.println("Valor inválido! Tente novamente.");
                                    System.out.print("nif: ");
                                }
                                nif = input.nextInt();
                                input.nextLine();   // Limpeza do canal de entrada

                                // Garante que o NIF tenha 9 dígitos
                                while (String.valueOf(nif).length() != 9) {
                                    System.out.println("Opção inválida! Tente novamente");
                                    System.out.print("nif: ");
                                    nif = input.nextInt();
                                    input.nextLine();   // Limpeza do canal de entrada
                                };
            
                                // Pede e recebe a Localização
                                System.out.print("Indique a localização (Continente, Madeira, Açores): ");
                                String location = input.nextLine();
                                while (!(location.equalsIgnoreCase("Continente") || location.equalsIgnoreCase("Madeira") || location.equalsIgnoreCase("Açores"))) {
                                    System.out.println("Opção inválida! Tente novamente");
                                    System.out.print("Indique a localização (Continente, Madeira, Açores): ");
                                    location = input.nextLine();
                                }
            
                                // Criação de novo Cliente
                                if(location.equalsIgnoreCase("Continente")){
                                    Cliente novoCliente = new Cliente(name, nif, local.CONTINENTE);
                                    listClients.add(novoCliente);
                                    System.out.println("\nCliente adicionado com sucesso!");
                                }

                                else if(location.equalsIgnoreCase("Madeira")){
                                    Cliente novoCliente = new Cliente(name, nif, local.MADEIRA);
                                    listClients.add(novoCliente);
                                    System.out.println("\nCliente adicionado com sucesso!");
                                }

                                else if(location.equalsIgnoreCase("Açores")){
                                    Cliente novoCliente = new Cliente(name, nif, local.ACORES);
                                    listClients.add(novoCliente);
                                    System.out.println("\nCliente adicionado com sucesso!");
                                }
                            
            
                                // Pausa no programa
                                System.out.print("Pressione Enter para continuar... ");
                                pause.nextLine();
                                break;
            
                            case 2:
                                // Editar CLIENTE
                                System.out.println("\n-- Lista de Clientes --");
                                for (Cliente cliente : listClients) {
                                    System.out.println(cliente.toString());
                                }
                                System.out.println("-----------------------");
            
                                // Pede e recebe o nif
                                System.out.print("\nIndique o nif do cliente a editar: ");
                                // Pede e recebe o nif
                                System.out.print("Indique o nif: ");

                                while (!input.hasNextInt()) {
                                    input.next();
                                    System.out.println("Valor inválido! Tente novamente.");
                                    System.out.print("nif: ");
                                }
                                nif = input.nextInt();
                                input.nextLine();   // Limpeza do canal de entrada

                                // Garante que o NIF tenha 9 dígitos
                                while (String.valueOf(nif).length() != 9) {
                                    System.out.println("Opção inválida! Tente novamente");
                                    System.out.print("nif: ");
                                    nif = input.nextInt();
                                    input.nextLine();   // Limpeza do canal de entrada
                                };
            
                                // Localiza o cliente pelo NIF
                                Cliente clienteEncontrado = null;
                                for (Cliente cliente : listClients) {
                                    if (cliente.getNif() == nif) {
                                        clienteEncontrado = cliente;
                                        break;
                                    }
                                }
            
                                if (clienteEncontrado != null) {
                                    // Pede os novos dados
                                    System.out.println("-- Cliente a editar --");
            
                                    System.out.print("Novo nome: ");
                                    clienteEncontrado.setNome(input.nextLine());
            
                                    System.out.print("Novo nif: ");
                                    while (!input.hasNextInt()) {
                                        input.next();
                                        System.out.println("Valor inválido! Tente novamente.");
                                        System.out.print("nif: ");
                                    }
                                    nif = input.nextInt();
                                    input.nextLine();   // Limpeza do canal de entrada
    
                                    // Garante que o NIF tenha 9 dígitos
                                    while (String.valueOf(nif).length() != 9) {
                                        System.out.println("Opção inválida! Tente novamente");
                                        System.out.print("nif: ");
                                        nif = input.nextInt();
                                        input.nextLine();   // Limpeza do canal de entrada
                                    };
            
                                    System.out.print("Nova localização: ");
                                    String newLocation = input.nextLine();;
                                    while (!(newLocation.equalsIgnoreCase("Continente") || newLocation.equalsIgnoreCase("Madeira") || newLocation.equalsIgnoreCase("Açores"))) {
                                        System.out.println("Opção inválida! Tente novamente");
                                        System.out.print("Indique a localização (Continente, Madeira, Açores): ");
                                        newLocation = input.nextLine();
                                    }

                                    if(newLocation.equalsIgnoreCase("Continente")){
                                        clienteEncontrado.setLocalizacao(local.CONTINENTE);
                                    }
    
                                    else if(newLocation.equalsIgnoreCase("Madeira")){
                                        clienteEncontrado.setLocalizacao(local.MADEIRA);
                                    }
    
                                    else if(newLocation.equalsIgnoreCase("Açores")){
                                        clienteEncontrado.setLocalizacao(local.ACORES);
                                    }

                                    System.out.println("\nCliente alterado com sucesso");
                                } else {
                                    System.out.println("Cliente não encontrado!");
                                }
            
                                // Pausa no programa
                                System.out.print("Pressione Enter para continuar... ");
                                pause.nextLine();
                                break;
            
                            case 3:
                                System.out.println("A voltar ao menu...");
                                break;
            
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    } while (opcao != 3);

                    break;
                
                case 2:
                    System.out.println("\n--- Todos os Clientes ---");

                    for (Cliente cliente : listClients)
                        System.out.println(cliente.toString());

                    System.out.println("\n-------------------------");

                    // Pausa no programa
                    System.out.print("\nenter para voltar ao menu.. ");
                    pause.nextLine();

                    break;
                case 0:
                    System.out.println("A sair do programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        // Fecho dos objetos Scanner
        input.close();
        pause.close();

        //endregion
    }
}