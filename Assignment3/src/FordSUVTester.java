public class FordSUVTester {
    public static void main(String[] args) {
        Store fordStore = new FordStore();

        Automobile automobile = fordStore.getAutomobile("Explorer");
        automobile.setPrice(31999);
        automobile.setModelYear(2017);

        System.out.println("You selected\n\n" + automobile +"\n");
    }
}
