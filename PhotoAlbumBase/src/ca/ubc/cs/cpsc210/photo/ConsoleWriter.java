package ca.ubc.cs.cpsc210.photo;

/**
 * Created by Yoram on 2014-12-02.
 */
public class ConsoleWriter implements Observer {

   private void writeToConsole(String s){
       System.out.println(s);
   }

    @Override
    public void update(String s) {
        writeToConsole(s);
    }
}
