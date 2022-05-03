package src;

import java.util.ArrayList;


public class Lstatements {

    ArrayList<Statement> statementLists;

    public Lstatements(Statement s){
        statementLists  = new ArrayList<Statement>();
        statementLists.add(s);
    }

    public Lstatements(Lstatements l, Statement s){
        statementLists = l.statementLists;
        statementLists.add(s);
    }

    public void execute(){

        for (Statement Statement : statementLists) {
            Statement.execute();
        }
    }

    public void showStatements()
    {
        for (int i = 0; i < statementLists.size(); i++)
        {
            System.out.println("****************");
            System.out.println(statementLists.get(i));
            System.out.println("****************");
            
        }
    }
}
