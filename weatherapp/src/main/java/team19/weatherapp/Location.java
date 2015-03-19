package team19.weatherapp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 * The Location class allows us to look up specific location from a data set.
 * 
 * Currently, this is a placeholder for future development needs.
 * 
 * @author Scott Mackie
 *
 */
public class Location {
	
	String[] cityList;
	int locId;
	String name;
	String countryCode;
	Location leftChild;
	Location rightChild;
	Location parent;

	public Location (int id, String name, String countryCode) {
		this.locId = id;
		this.name = name;
		this.countryCode = countryCode;
		this.parent = null;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public static Location makeLocation(String line) {
		StringTokenizer st;
		int id;
		String name, countryCode, temp;
		st = new StringTokenizer(line);
        id = Integer.parseInt(st.nextToken());
        name = st.nextToken();
        temp = st.nextToken();
        while (!((temp.charAt(0) > 47 && temp.charAt(0) < 58) || temp.charAt(0) == 45)) {
     	   name = name.concat(" " + temp);
     	   temp = st.nextToken();
        }
        st.nextToken();
        countryCode = st.nextToken();
        Location locObject = new Location(id, name, countryCode);
        return locObject;
        
	}
	
	public static void buildTree (String cityListName) throws IOException, ClassNotFoundException{
		FileReader file = new FileReader(cityListName);
		BufferedReader br = new BufferedReader(file);
		Location temp, root;
		int i = 0;
		String line, tempName;
		br.readLine();
		line = br.readLine();
		root = makeLocation(line);
		LocationSearchTree tree = new LocationSearchTree(root);
        while ((line = br.readLine()) != null) {
        	i++;
        	temp = makeLocation(line);
        	tempName = temp.getName();
        	//System.out.println(tempName);
        	tree.insert(temp);
        }  
		System.out.println(i);
		//tree.traverseTree(root);
		int [] ids = new int[10];
		tree.findCityList("Jasp", root, ids);
		ids = new int[10];
		tree.findCityList("Tor", root , ids);
		ids = new int[10];
		tree.findCityList("Ra", root, ids);
		br.close();
		file.close();
	}
	
	/**
	 * The search method will allow us to search for specific cities.
	 * 
	 * @param s		The city which to be searched for
	 * @return		Special data paired with the specified city
	 */
	public static String search(String s) {
		return "";
	}
	
	public int getId() {
		return this.locId;
	}
	
	public String getName() {
		return this.name + " " + this.countryCode;
	}
	
	public void setLeft(Location newLeft) {
		this.leftChild = newLeft;
	}
	
	public Location getLeft() {
		return this.leftChild;
	}
	
	public void setRight(Location newRight) {
		this.rightChild = newRight;
	}
	
	public Location getRight() {
		return this.rightChild;
	}
	
	public void setParent(Location newParent) {
		this.parent = newParent;
	}
	
	public Location getParent() {
		return this.parent;
	}
	
	public String toString() {
		String locInfo = this.locId + " " + this.name + ", " + this.countryCode;
		return locInfo;
	}

}
