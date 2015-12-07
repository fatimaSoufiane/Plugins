package modele;

/** 
 * represent a plugin which can transform a string to an another string
 * */
public interface Plugin {
	public String transform(String s);

	public String getLabel();

	public String helpMessage();
}
