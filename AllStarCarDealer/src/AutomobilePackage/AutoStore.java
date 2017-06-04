package AutomobilePackage;

public class AutoStore extends Store {

    public Automobile createAuto(String name) {
        Automobile automobile = null;
        AutomobileFactory autoFactory;

        switch (name) {
            // ford
            case "explorer":
                autoFactory = new FordSUVFactory();
                automobile = new Explorer(autoFactory);
                break;
            case "f150":
                autoFactory = new FordTruckFactory();
                automobile = new F150(autoFactory);
                break;
            case "fusion":
                autoFactory = new FordSedanFactory();
                automobile = new Fusion(autoFactory);
                break;

            // Honda
            case "pilot":
                autoFactory = new HondaSUVFactory();
                automobile = new Pilot(autoFactory);
                break;
            case "ridgeline":
                autoFactory = new HondaTruckFactory();
                automobile = new Ridgeline(autoFactory);
                break;
            case "accord":
                autoFactory = new HondaSedanFactory();
                automobile = new Accord(autoFactory);
                break;
            case "odyssey":
                autoFactory = new HondaMinivanFactory();
                automobile = new Odyssey(autoFactory);
                break;

            // Toyota
            case "highlander":
                autoFactory = new ToyotaSUVFactory();
                automobile = new Highlander(autoFactory);
                break;
            case "tundra":
                autoFactory = new ToyotaTruckFactory();
                automobile = new Tundra(autoFactory);
                break;
            case "camry":
                autoFactory = new ToyotaSedanFactory();
                automobile = new Camry(autoFactory);
                break;
            case "sienna":
                autoFactory = new ToyotaMinivanFactory();
                automobile = new Sienna(autoFactory);
                break;

        }

//        if (name.equals("explorer")) {
//            autoFactory = new FordSUVFactory();
//            automobile = new Explorer(autoFactory);
//        }

//        if (name.equals("Fusion")) {
//            automobile = new FordSedan()
//        }

        return automobile;
    }


}
