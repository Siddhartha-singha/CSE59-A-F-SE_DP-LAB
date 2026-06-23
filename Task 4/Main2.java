public class Main {
    public static void main(String[] args) {

        Employee emp = new Employee("Alice");
        Contractor contractor = new Contractor("Bob");

        emp.calculateBonus();
        contractor.submitInvoice();
    }
}
abstract class TeamMember {
    protected String name;

    public TeamMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface BonusEligible{
    void calculateBonus();
}
class Employee extends TeamMember implements BonusEligible{
    public Employee(String name){
        super(name);
    }
    @Override
    public void calculateBonus(){
        System.out.println("Calculating standard employee bonus ..");
    }
}
class Contractor extends TeamMember {
    public Contractor(String name){
        super(name);
    }
    public void submitInvoice(){
        System.out.println(" Submitting contractor invoice ..");
    }
}
