package application;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = sc.nextInt();
        List<TaxPayer> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            System.out.println();
            System.out.printf("Digite os dados do %dº contribuinte: %n", i+1);
            System.out.print("Renda anual com salário: ");
            double salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            double servicesIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            double capitalIncome = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            double healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();

            TaxPayer taxPayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
            list.add(taxPayer);
            System.out.println();
        }

        int i = 0;
        for (TaxPayer obj : list) {
            System.out.printf("Resumo do %dº contribuinte: %n",  i+1);
            System.out.println(obj);
            i++;
        }

        sc.close();
    }
}
