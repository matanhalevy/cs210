package ca.ubc.cpsc210.filesystem;


public abstract class FileSystemResource {
	protected static final String INDENTATION = "   ";
	protected String name;
	
	public String getName() {
		return name;
	}
	
	public void print(){print(0);}

    protected abstract void print(int indent);

    protected void printIndent(int indent){
        for (int i = 0; i < indent; i++) {
            System.out.print(INDENTATION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileSystemResource that = (FileSystemResource) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
