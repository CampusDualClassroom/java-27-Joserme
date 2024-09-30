package com.campusdual.classroom;


import com.google.gson.*;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Exercise27 {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
                    crearXml();
                    crearJson();

    }
    public static void crearXml() throws ParserConfigurationException, TransformerException {
        Document documento;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dc = documentBuilderFactory.newDocumentBuilder();
        DOMImplementation imp = dc.getDOMImplementation();
        documento = imp.createDocument(null,"shoppinglist",null);
        documento.setXmlVersion("1.0");

        Element items = documento.createElement("items");
        Element item = documento.createElement("item");
        items.appendChild(item);
        item.setAttribute("quantity","2");
        Text producto = documento.createTextNode("Manzana");
        item.appendChild(producto);
        documento.getDocumentElement().appendChild(items);

        items = documento.createElement("items");
        item = documento.createElement("item");
        items.appendChild(item);
        item.setAttribute("quantity","1");
        producto = documento.createTextNode("Leche");
        item.appendChild(producto);
        documento.getDocumentElement().appendChild(items);

        items = documento.createElement("items");
        item = documento.createElement("item");
        items.appendChild(item);
        item.setAttribute("quantity","3");
        producto = documento.createTextNode("Pan");
        item.appendChild(producto);
        documento.getDocumentElement().appendChild(items);

        items = documento.createElement("items");
        item = documento.createElement("item");
        items.appendChild(item);
        item.setAttribute("quantity","2");
        producto = documento.createTextNode("Huevo");
        item.appendChild(producto);
        documento.getDocumentElement().appendChild(items);

        items = documento.createElement("items");
        item = documento.createElement("item");
        items.appendChild(item);
        item.setAttribute("quantity","1");
        producto = documento.createTextNode("Queso");
        item.appendChild(producto);
        documento.getDocumentElement().appendChild(items);

        items = documento.createElement("items");
        item = documento.createElement("item");
        items.appendChild(item);
        item.setAttribute("quantity","1");
        producto = documento.createTextNode("Cereal");
        item.appendChild(producto);
        documento.getDocumentElement().appendChild(items);

        items = documento.createElement("items");
        item = documento.createElement("item");
        items.appendChild(item);
        item.setAttribute("quantity","4");
        producto = documento.createTextNode("Agua");
        item.appendChild(producto);
        documento.getDocumentElement().appendChild(items);

        items = documento.createElement("items");
        item = documento.createElement("item");
        items.appendChild(item);
        item.setAttribute("quantity","6");
        producto = documento.createTextNode("Yogur");
        item.appendChild(producto);
        documento.getDocumentElement().appendChild(items);

        items = documento.createElement("items");
        item = documento.createElement("item");
        items.appendChild(item);
        item.setAttribute("quantity","2");
        producto = documento.createTextNode("Arroz");
        item.appendChild(producto);
        documento.getDocumentElement().appendChild(items);


        Source source = new DOMSource(documento);
        Result result = new StreamResult(new File("src/main/resources/shoppingList.xml"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source,result);
        if(source.isEmpty()){
            System.out.println("Archivo no creado");
        }



    }
    public static void crearJson() throws IOException {

        Gson gson = new Gson();
        Lista obj = new Lista();
        HashMap<String,List<Lista>> items = new HashMap<>();

        List<Lista> objetos = Arrays.asList(
                new Lista("2","Manzana"),
                new Lista("1","Leche"),
                new Lista("3","Pan"),
                new Lista("2","Huevo"),
                new Lista("1","Queso"),
                new Lista("1","Cereal"),
                new Lista("4","Agua"),
                new Lista("6","Yogur"),
                new Lista("2","Arroz"));

            items.put("items",objetos);
            gson = new GsonBuilder().setPrettyPrinting().create();

            String json  = gson.toJson(items);
            System.out.println(json);
            BufferedWriter bf = null;
            String path = "src/main/resources/shoppingList.json";
            try {
                bf = new BufferedWriter(new FileWriter(path));
                bf.write(json);
                bf.flush();
            } catch (IOException ex) {
                System.out.println("Error al escribir en el archivo");
            } finally {
                try {
                    if (bf != null) bf.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el archivo");
                }
            }


    }

}
