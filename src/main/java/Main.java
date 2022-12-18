import javax.xml.bind.annotation.*;
import java.util.*;
import javax.xml.bind.*;
import java.io.*;

import static javax.xml.bind.JAXBContext.newInstance;

@XmlRootElement
public class Main {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Меню компьютерного магазина");
        ProductActions menu = new ProductActions();
        menu.mainMenu();

    }

    static public void writeToXML() {
        ProductXML productXML = new ProductXML();
        productXML.allProducts.addAll(PC.pcs);
        productXML.allProducts.addAll(KeyboardMouse.KeyboardMouses);
        productXML.allProducts.addAll(Accessories.Accessoriess);
        productXML.allProducts.addAll(Screen.Screens);
        productXML.allProducts.addAll(SpareParts.spareParts);
        String filePath = "infoXMl.xml";
        try {
            JAXBContext context = JAXBContext.newInstance(Main.class, PC.class, KeyboardMouse.class, Accessories.class,
                    Screen.class, SpareParts.class, ProductXML.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(productXML, new File(filePath));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("Данные сохранены в XML");
    }

    static public void readFromXML() {
        ProductXML productXML;
        String filePath = "infoXMl.xml";
        try {
            JAXBContext context = JAXBContext.newInstance(Main.class, PC.class, KeyboardMouse.class, Accessories.class,
                    Screen.class, SpareParts.class, ProductXML.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            productXML = (ProductXML) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        for (Object obj : productXML.allProducts) {
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

        System.out.println("Получены данные из XML-файла\nИспользуйте пункт меню №4 для их вывода");
    }
}
