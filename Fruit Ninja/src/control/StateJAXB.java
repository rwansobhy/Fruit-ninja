package control;


import java.io.*;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class StateJAXB {
	
	ReadXml readXml;
	public  List<GameState> list=new ArrayList<GameState>();

	public void readXML(JAXBContext jc) throws JAXBException
	{
		Unmarshaller unmarshaller=jc.createUnmarshaller();
		 readXml=(ReadXml) unmarshaller.unmarshal(new File("Fruit.xml"));
		 list=readXml.getGameList();
		if(readXml.getGameList().isEmpty())
		{
			System.out.println("list is empty");
			
		}
		else {
			for(int i=0; i<readXml.getGameList().size();i++)
			{
				System.out.println("best score "+ readXml.getGameList().get(i).getBest_score());

			}
		}
	}
	
	
public List<GameState> getList() {
		return list;
	}


public static void writeXml(JAXBContext jc,ArrayList<GameState>  list) 
{
	ReadXml read =new ReadXml();
	read.setGameList(list);
	
		
		try {
			Marshaller  marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			OutputStream output=new FileOutputStream("Fruit.xml");
			marshaller.marshal(read, output);
		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println("error jaxb catch1");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("error jaxb catch2");

		}   
		
		
				
	
}

}
/*
 * {DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); try {
 * DocumentBuilder builder = factory.newDocumentBuilder(); Document doc =
 * builder.parse("Fruitninja.xml"); NodeList list=
 * doc.getElementsByTagName("Fruitninja"); for(int i=0;i<list.getLength();i++) {
 * Node s=list.item(i); if(s.getNodeType()==Node.ELEMENT_NODE) { Element
 * state=(Element) s;
 * 
 * String score=state.getAttribute("current_score"); System.out.println(score);
 * }
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * } catch (ParserConfigurationException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } catch (SAXException e) { // TODO Auto-generated catch
 * block e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
 * catch block e.printStackTrace(); }
 */
/*
 * public void marshall() { try { List<GameStateXml> states=new
 * ArrayList<GameStateXml>(); states.add(new GameStateXml()); ReadXml r=new
 * ReadXml();
 * 
 * r.setStatesfromXml(states);
 * 
 * JAXBContext jc=JAXBContext.newInstance(ReadXml.class);
 * 
 * 
 * Marshaller ms=jc.createMarshaller();
 * ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); ms.marshal(r,
 * System.out); File xFile=new File("SaveGameState.xml"); ms.marshal(r,xFile);
 * 
 * 
 * 
 * 
 * } catch(Exception e) { System.out.println(""+e.getMessage()); } } public void
 * unMarshell()
 * 
 * { try { //Unmarshaller ums=jc.createUnmarshaller(); //FruitNinjaXml
 * state=(FruitNinjaXml)ums.unmarshal(new File("Fruitninja.xml")); JAXBContext
 * jc=JAXBContext.newInstance(ReadXml.class);
 * 
 * Unmarshaller unmarshaller = jc.createUnmarshaller(); ReadXml r = (ReadXml)
 * unmarshaller.unmarshal(new File("SaveGameState.xml"));
 * System.out.println("state information"); for(GameStateXml s:
 * r.getStatesfromXml()) { System.out.println(s.getRemaining_lives());
 * 
 * }
 * 
 * 
 * 
 * 
 * } catch(Exception e) { System.out.println(""+e.getMessage());
 * 
 * }
 * 
 * 
 * }
 */