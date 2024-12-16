package lab07.Parking;

import java.util.Random;

public abstract class Identyfier {

    public String getID() {
        Random rand = new Random();

        String[] name = {"Jan", "Barbara", "Anna" , "Mateusz", "Katarzyna", "Michał", "Aleksandra", "Jakub", "Zofia", "Adam", "Natalia", "Piotr", "Maria"};
        String[] lastName = {"Kowalski", "Rico", "Szeregowy", "Nowak", "Wiśniewski", "Kamiński", "Zielińska", "Wójcik", "Szymański", "Kaczmarek", "Mazur", "Kucharska", "Dąbrowski"};

        int index1 = rand.nextInt(name.length);
        int index2 = rand.nextInt(lastName.length);

        return name[index1] + " " + lastName[index2];
    }

    public String getColor() {
        Random rand = new Random();
        String[] color = {
                "Red",
                "Green",
                "Blue",
                "Black",
                "White",
                "Silver",
                "Gray",
                "Yellow",
                "Orange",
                "Brown",
                "Beige",
                "Purple",
                "Pink"
        };

        return color[rand.nextInt(color.length)];
    }

    public String getPlates() {
        Random rand = new Random();
        String[] first = {
                "DSW",
                "KRK",
                "P0",
                "BI",
                "BS",
                "BL",
                "FGW",
                "FKR",
                "FMI",
                "GBY",
                "CH",
                "CZ",
                "KN"
        };
        String[] second = {
                "007",
                "999",
                "345",
                "VS43",
                "JP21",
                "KW37",
                "HW10",
                "DP90",
                "GPO4",
                "CHT0"
        };

        return first[rand.nextInt(first.length)] + "-" + second[rand.nextInt(second.length)];
    }

    public String getModel() {
        Random rand = new Random();
        String[] model = {
                "Audi A4",
                "Mazda MX6",
                "VW Passat",
                "Toyota Corolla",
                "Ford Mustang",
                "Honda Civic",
                "BMW 3 Series",
                "Mercedes-Benz C-Class",
                "Hyundai Tucson",
                "Kia Sportage",
                "Volvo XC60",
                "Subaru Outback",
                "Chevrolet Camaro"
        };
        int index = rand.nextInt(model.length);
        return model[index];
    }
}
