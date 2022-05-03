package src;

// Java program implementing Singleton class 
// with getInstance() method 
 

public class Statement
{
    parser parser = new parser();
    String statementType;
    String ID;
    Type type;
    Expression e;
    Expression e1;
    Statement body;
    Statement expbody;
    Statement elsebody;
    Lstatements statementList;
    int calculatorResult;
    float calculatorFloatResult;
    String ID2;

    //for logical
    Expression left;    
    Expression right;
    

    public Statement(Type t, String ID, Expression e)
    {
        this.ID = ID;
        this.e = e;
        this.type = t;
    }
    
    public Statement(Type t, String ID)
    {
        this.ID = ID;
        this.e = null;
        this.type = t;
    }

    public Statement (Integer i)
    {
        this.calculatorResult = i;
    }
     public Statement (Float i)
    {
        this.calculatorFloatResult = i;
    }
     
    
    public Statement(String ID, Expression e)
    {
        this.ID = ID;
        this.e = e;
    }
    
    public Statement(String ID1,String ID2 )
    {
        this.ID = ID1;
        this.ID2 = ID2;
    }

    public Statement(Expression e, Statement body)
    {
        this.e = e;
        this.body = body;
    }
    
    public Statement(Expression e, Statement body1, Statement body2) {
        this.e = e;

        this.body = body1;
        this.elsebody = body2;

    }
    
    public Statement(String ID, Expression e, Expression e1, Statement expbody,Statement body) {   //for loop
        this.ID = ID;
        this.e = e;
        this.e1 = e1;
        this.expbody = expbody;  
        this.body = body;          
    }

    public Statement(Expression e)
    {
        this.e = e;
    }

    private Statement(Lstatements l)
    {
        statementList = l;
    }

    
    public static Statement logic (Expression logical)
    {
        Statement logic = new Statement(logical);
        logic.statementType="logic";

        return logic;
    }
    
    public static Statement assignment(String ID, Expression e)
    {
        Statement assignment = new Statement(ID, e);

        assignment.statementType = "assignment";

        return assignment;

    }

    public static Statement assignment(Type t, String ID, Expression e)
    {
        Statement assignment = new Statement(t, ID, e);
        assignment.statementType = "initialization";

        return assignment;

    }
    
    public static Statement assignment(Type t, String ID)
    {
        Statement assignment = new Statement(t, ID);
        assignment.statementType = "declaration";

        return assignment;

    }

    public static Statement whileloop(Expression e, Statement whileBody)
    {
        Statement loop = new Statement(e, whileBody);
        loop.statementType = "whileloop";
        return loop;

    }
    
    public static Statement until_st(Expression e, Statement untilBody)
    {
        Statement loop = new Statement(e, untilBody);
        loop.statementType = "until_st";
        return loop;

    }

    public static Statement ifthen(Expression e, Statement ifbody)
    {
        Statement ifthen = new Statement(e, ifbody);
        ifthen.statementType = "ifthen";
        return ifthen;
    }
    
    public static Statement ifthenelse(Expression e, Statement ifbody, Statement elsebody) {

        Statement ifthenelse = new Statement(e, ifbody,elsebody);
        ifthenelse.statementType = "ifthenelse";
        return ifthenelse;
        
    }
    
    public static Statement forloop(String ID, Expression e, Expression e1, Statement expbody,Statement forbody) {

        Statement forloop = new Statement(ID, e, e1,expbody,forbody);
        forloop.statementType = "forloop";
        return forloop;
        
    }

    public static Statement print(Expression e)
    {

        Statement p = new Statement(e);
        p.statementType = "print";
        return p;

    }

    public static Statement list(Lstatements l)
    {

        Statement p = new Statement(l);
        p.statementType = "list";
        return p;

    }
    
    public static Statement functioncall(String id)
    {
        Lstatements l;
        Statement p = null;
        l = Tables.funcTable.get(id);
        if(l != null){
           p = new Statement(l); 
           p.statementType = "function";
        }
        return p;

    }
    
    public static Statement functionReturn(String id1, String id2)
    {
       
       Statement p = new Statement(id1,id2);
       p.statementType = "function-return";
       
       return p;
    }

    public String getstat() {
        System.out.println(statementType);

        if (statementType.equals("assignment")) {
            return ID + "=" + e.getexp();
        } else if (statementType.equals("initialization")) {
            return type.getCode() + " " + ID + "=" + e.getexp();
        } else if (statementType.equals("ifthen")) {
            return "if " + e.getexp() + " " + body.getstat();
        } else if (statementType.equals("ifthenelse")) {
            return "else " + e.getexp() + " " + body.getstat();
        } else if (statementType.equals("print")) {
            return "print " + e.getexp();
        } else if (statementType.equals("whileloop")) {
            return "while " + e.getexp() + " do " + body.getstat();
        } else if (statementType.equals("forloop")) {    //check again
            return "for " + e.getexp() + body.getstat();
        } else if (statementType.equals("list")) {
            return "list";
        } else if (statementType.equals("function-return")) {
            return "function-return";
        } else if (statementType.equals("until_st")) {
            return "until_st";
        } else if (statementType.equals("type-error")) {
            return "type-error";
        } else {
            return "unknown";
        }
    }

    public void execute() {
        /*
         * Retreive identifier from table, check its type, then assign
         */
        if (statementType.equals("assignment")) {
            if (Tables.envTable.get(ID).getType().isInteger()) {
                Tables.envTable.put(ID, new TypeValue((Integer) e.getTypeValue().getValue()));
            }
            if (Tables.envTable.get(ID).getType().isString()) {
                Tables.envTable.put(ID, new TypeValue((String) e.getTypeValue().getValue()));
            }
            if (Tables.envTable.get(ID).getType().isFloating_point()) {
                Tables.envTable.put(ID, new TypeValue((Float) e.getTypeValue().getValue()));
            }
            if (Tables.envTable.get(ID).getType().isBool()) {
                Tables.envTable.put(ID, new TypeValue((Boolean) e.getTypeValue().getValue()));
            }
        } else if (statementType.equals("initialization")) {


            if (type.isInteger()) {
                Tables.envTable.put(ID, new TypeValue((Integer) e.getTypeValue().getValue()));
            }

            if (type.isFloating_point()) {
                Tables.envTable.put(ID, new TypeValue((Float) e.getTypeValue().getValue()));
            }
            if (type.isString()) {

                Tables.envTable.put(ID, new TypeValue((String) e.getTypeValue().getValue()));


            }
            if (type.isBool()) {
                Tables.envTable.put(ID, new TypeValue((Boolean) e.getTypeValue().getValue()));
            }

        } else if (statementType.equals("ifthen")) {
            if (e.getTypeValue().getType().isBool()) //expr must be boolean
            {
                boolean b = (Boolean) e.getTypeValue().getValue();
                if ((Boolean) e.getTypeValue().getValue()) {
                    body.execute();
                }
            } else {
                parser.type_error("", "if expression must be boolean.");
            }
        } else if (statementType.equals("ifthenelse")) {
            if (e.getTypeValue().getType().isBool()) //expr must be boolean
            {
                if ((Boolean) e.getTypeValue().getValue()) {
                    body.execute();
                } else {
                    elsebody.execute();
                }
            } else {
                parser.type_error("", "if expression must be boolean.");
            }
        } else if (statementType.equals("whileloop")) {
            if (e.getTypeValue().getType().isBool()) {
                for (;;) {
                    if ((Boolean) e.getTypeValue().getValue()) {
                        body.execute();
                    } else {
                        break;
                    }
                }
            } else {
                //type error
                parser.type_error("", "while expression must be boolean.");
            }
            
        }else if (statementType.equals("forloop")) {
            if (Tables.envTable.get(ID).getType().isInteger()) {
                Tables.envTable.put(ID, new TypeValue((Integer) e.getTypeValue().getValue()));
            }
            if (Tables.envTable.get(ID).getType().isString()) {
                Tables.envTable.put(ID, new TypeValue((String) e.getTypeValue().getValue()));
            }
            if (Tables.envTable.get(ID).getType().isFloating_point()) {
                Tables.envTable.put(ID, new TypeValue((Float) e.getTypeValue().getValue()));
            }
            if (Tables.envTable.get(ID).getType().isBool()) {
                Tables.envTable.put(ID, new TypeValue((Boolean) e.getTypeValue().getValue()));
            }
            
            if (e1.getTypeValue().getType().isBool()) {
                for (;;) {
                    if ((Boolean) e1.getTypeValue().getValue()) {                        
                        body.execute();
                        expbody.execute();
                    } else {
                        break;
                    }
                }
            } else {
                //type error
                parser.type_error("", "while expression must be boolean.");
            }
            
        }
        else if (statementType.equals("until_st")) {
            if (e.getTypeValue().getType().isBool()) {
                for (;;) {
                    if (!(Boolean) e.getTypeValue().getValue()) {
                        body.execute();
                    } else {
                        break;
                    }
                }
            } else {
                //type error
                parser.type_error("", "Until expression must be boolean.");
            }
        } else if (statementType.equals("print")) {
            //need to check type for casting from TypeValue
            if(e != null){
                if (e.getType().isInteger()) {
                    System.out.println((Integer) e.getTypeValue().getValue());
                }
                if (e.getType().isFloating_point()) {
                    System.out.println((Float) e.getTypeValue().getValue());
                }
                if (e.getType().isString()) {
                    System.out.println((String) e.getTypeValue().getValue());
                }
                if (e.getType().isBool()) {
                    System.out.println((Boolean) e.getTypeValue().getValue());
                }
            }
            else{
                System.out.println("HEre is the error");
            }
            

        } else if (statementType.equals("list")) {
            for (Statement s : statementList.statementLists) {
                s.execute();
            }
        } else if (statementType.equals("calculator")) {
            if (type.isInteger()) {
                System.out.println(calculatorResult);
            }
            if (type.isFloating_point()) {
                System.out.println(calculatorFloatResult);
            }

        } else if (statementType.equals("function")) {
            for (Statement s : statementList.statementLists) {
                s.execute();
            }
        } else if (statementType.equals("function-return")) {

            Lstatements l;
            Statement p = null;
            l = Tables.funcTable.get(ID2);
            if (l != null) {
                for (Statement s : l.statementLists) {
                    s.execute();
                }

                Tables.envTable.put(ID, Tables.envTable.get(ID2));
            }
        } 
    }
}
