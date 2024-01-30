package entities;

public class TaxPayer {

    private double salaryIncome;
    private double servicesIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public double salaryTax() {
        if (salaryIncome / 12.0 < 3000.00) {
            return 0.0;
        }
        else if (salaryIncome / 12.0 < 5000.00) {
            return (salaryIncome / 12.0) * 0.10 * 12.0;
        }
        else if (salaryIncome / 12.0 > 5000.00) {
            return (salaryIncome / 12.0) * 0.20 * 12.0;
        }

        return 0.0;
    }

    public double servicesTax() {
        return servicesIncome * 0.15;
    }

    public double capitalTax() {
        return capitalIncome * 0.20;
    }

    public double grossTax() {

        if (salaryIncome / 12.0 < 3000.00) {
            return 0 + servicesTax() + capitalTax();
        }
        else if (salaryIncome / 12.0 < 5000.00) {
            return salaryTax() + servicesTax() + capitalTax();
        }
        else if (salaryIncome / 12.0 > 5000.00) {
            return salaryTax() + servicesTax() + capitalTax();
        }

        return 0.0;
    }

    public double taxRebate() {

        if (healthSpending + educationSpending > grossTax()) {
            return grossTax() * 0.30;
        }
        else {
            return healthSpending + educationSpending;
        }
    }

    public double netTax() {
        return grossTax() - taxRebate();
    }

    public String toString() {
        return "Imposto bruto total: " +
                String.format("%.2f%n", grossTax()) +
                "Abatimento: " + String.format("%.2f%n", taxRebate()) +
                "Imposto devido: " + String.format("%.2f%n", netTax());
    }
}
