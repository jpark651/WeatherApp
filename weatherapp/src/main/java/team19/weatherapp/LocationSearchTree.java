package team19.weatherapp;

public class LocationSearchTree {
	
	private Location root;
	
	public LocationSearchTree (Location newRoot) {
		root = newRoot;
		int numPrinted = 0;
	}
	
	public void insert (Location newLocObj) {
		String tempName;
		String newObjName = newLocObj.getName();
		int compare;
		Location temp = root;
		while (temp != null) {
			tempName = temp.getName();
			compare = newObjName.compareTo(tempName);
			if (compare < 0) {
				if (temp.getLeft() == null) {
					temp.setLeft(newLocObj);
					return;
				}
				else temp = temp.getLeft();
			} else if (temp.getRight() == null) {
				temp.setRight(newLocObj);
				return;
			} else temp = temp.getRight();
		}
	}
	
	public void traverseTree (Location temp) {
		if (temp.getLeft() != null) {
			traverseTree (temp.getLeft());
		}
		System.out.println(temp.toString());
		if (temp.getRight() != null) {
			traverseTree (temp.getRight());
		}
		return;
	}
	
	public int [] findCityList (String target, Location temp, int [] idList) {
		int compare;
		int i = 0;
		if (temp.getName().startsWith(target)) {
			while (i < 10) {
				if (idList[i] == 0) {
					idList[i] = temp.getId();
					i = 10;
					System.out.println(temp.getName());
				}
				i++;
			}
		}
		compare = target.compareTo(temp.getName());
		if (compare < 0 && (temp.getLeft() != null)) {
			findCityList(target, temp.getLeft(), idList);
		}
		if ((temp.getRight() != null) && (compare > -1 || temp.getName().startsWith(target))) {
			findCityList(target, temp.getRight(), idList);
		}
		return idList;
	}
	
	
	/*
	public boolean isRoot (Location locObj) {
		if (locObj.getParent() == null)
			return true;
		else return false;
	}
	*/

}
