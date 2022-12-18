import javax.xml.bind.annotation.*;
import java.util.*;
import javax.xml.bind.*;
import java.io.*;

@XmlType
@XmlRootElement
public class ProductXML {

    @XmlElementWrapper
    @XmlElement
    public List<Object> allAnimals = new ArrayList<>();

    @Override
    public String toString() {
        return "ProductXML {" + "allAnimals = " + allAnimals + '}';
    }
}
