public class FordStore extends Store {

    public Automobile createAuto(String name) {
        Automobile automobile = null;
        AutomobileFactory autoFactory = new FordSUVFactory();

        if (name.equals("Explorer")) {
            automobile = new FordSUV(autoFactory);
            automobile.setName("Explorer");
        }

//        if (name.equals("Fusion")) {
//            automobile = new FordSedan()
//        }

        return automobile;
    }


}
