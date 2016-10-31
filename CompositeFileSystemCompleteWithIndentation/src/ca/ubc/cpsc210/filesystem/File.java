package ca.ubc.cpsc210.filesystem;

public class File extends FileSystemResource {

	public File(String name){
		this.name = name;
	}
	
	protected void print(int indent) {
		printIndent(indent);
		System.out.println(this.name);
	}

}
