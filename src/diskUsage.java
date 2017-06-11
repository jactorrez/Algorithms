import java.io.File;

public class diskUsage {
	public static long diskUsage(File root){
		long total = root.length();						// start with direct disk usage
		if(root.isDirectory()){							// check if this is a directory
			for(String childName : root.list()){		// for each child...
				File child = new File(root, childName); // compose full path to child
				total += diskUsage(child);				// add child's usage to total
			}
		}	
		System.out.println(total + "\t" + root);	// descriptive output
		return total;								// return the grand total
	}
}
