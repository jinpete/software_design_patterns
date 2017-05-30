import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {

//    private static DisplayList displayList = DisplayList.getTheDisplayList();
    public static BodyType getBodyTypeFromUser() {

        // default CarBodyType
        BodyType returnBodyType = CarBodyType.getCarBodyType();
        // Prepare to read from the console
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));

        try {
            // Display a list of body types
            System.out.print("Please choose a body type(default=car):\ncar\nsuv\ntruck\nminivan\n");
            String input = reader.readLine();

            if(input.equals("car"))
                returnBodyType = CarBodyType.getCarBodyType();
            if(input.equals("suv"))
                returnBodyType = SuvBodyType.getSuvBodyType();
            if(input.equals("truck"))
                returnBodyType = TruckBodyType.getTruckBodyType();
            if(input.equals("minivan"))
                returnBodyType = MinivanBodyType.getMinivanBodyType();

        } catch (IOException e) {
            System.out.println(e);
        }

        return returnBodyType;
    }

    public static Manufacturer getManufacturerFromUser() {
        // default Ford
        Manufacturer returnManufacturer = Ford.getFord();
        // Prepare to read from the console
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));

        try {
            // get Manufacturer from the user
            System.out.print("Please choose a manufacturer(default= ford):\nford\nhonda\ntoyota\n");
            String input = reader.readLine();

            if(input.equals("ford"))
                returnManufacturer = Ford.getFord();
            if(input.equals("honda"))
                returnManufacturer = Honda.getHonda();
            if(input.equals("toyota"))
                returnManufacturer = Toyota.getToyota();

        } catch (IOException e) {
            System.out.println(e);
        }

        return returnManufacturer;
    }

    //testing

    public static void main(String[] args) {
        BodyType bodyType;
        Manufacturer manufacturer;
        bodyType = getBodyTypeFromUser();
        manufacturer = getManufacturerFromUser();

    }
}
