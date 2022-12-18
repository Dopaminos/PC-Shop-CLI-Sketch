import javax.xml.bind.annotation.*;
import java.util.*;
import javax.xml.bind.*;
import java.io.*;


import static javax.xml.bind.JAXBContext.newInstance;

@XmlRootElement
public class Main {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("Животный мир. Пользовательское меню");
        doAnimals menu = new doAnimals();
        menu.mainMenu();


    }
    public void parametersInput() {
        System.out.println("Введите название товара: ");
        String name = read.nextLine();
    
        System.out.println("Введите параметры товара: ");
        String specs = read.nextLine();
        
        System.out.println("Игровой товар?: ");
        String gaming = read.nextLine();
    }
    static public void writeToXML() {
        AnimalsXML animalsXML = new AnimalsXML();
        animalsXML.allAnimals.addAll(PC.pcs);
        animalsXML.allAnimals.addAll(KeyboardMouse.KeyboardMouses);
        animalsXML.allAnimals.addAll(Accessories.Accessoriess);
        animalsXML.allAnimals.addAll(Screen.Screens);
        animalsXML.allAnimals.addAll(SpareParts.spareParts);
        String filePath = "infoXMl.xml";
        try {
            JAXBContext context = JAXBContext.newInstance(Main.class, PC.class, KeyboardMouse.class, Accessories.class, Screen.class, SpareParts.class, AnimalsXML.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(animalsXML, new File(filePath));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("Данные сохранены в XML");
    }

    static public void readFromXML() {
        AnimalsXML animalsXML;
        String filePath = "infoXMl.xml";
        try {
            JAXBContext context = JAXBContext.newInstance(Main.class, PC.class, KeyboardMouse.class, Accessories.class, Screen.class, SpareParts.class, AnimalsXML.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            animalsXML = (AnimalsXML) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        for (Object obj : animalsXML.allAnimals) {
            if (obj instanceof PC) {
                PC.pcs.add((PC) obj);
            }
            if (obj instanceof KeyboardMouse) {
                KeyboardMouse.KeyboardMouses.add((KeyboardMouse) obj);
            }
            if (obj instanceof Accessories) {
                Accessories.Accessoriess.add((Accessories) obj);
            }
            if (obj instanceof Screen) {
                Screen.Screens.add((Screen) obj);
            }
            if (obj instanceof SpareParts) {
                SpareParts.spareParts.add((SpareParts) obj);
            }

        }

        System.out.println("Получены данные из XML-файла");
        System.out.println("Используейте функцию №4 для вывода");
    }
}
