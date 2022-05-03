package src;

public class Expression {

    private parser parser = new parser();
    private boolean[] tag = new boolean[6];
    private Integer NUMBER_INTEGER;
    private Float NUMBER_FLOAT;
    private String TEXT_LITERAL;
    private String ID;
    private Arguments Operands;
    private int Operator;
    private Boolean BOL;
    //type is determined from the constructor
    private Type type = new Type();
    //A variable to check if identifier hold boolean or not. If false, its integer.
    private boolean isBool;

    Expression(Integer x) {
        int i;
        for (i = 0; i <= 5; i++) {
            if (i == 0) {
                tag[i] = true;
            } else {
                tag[i] = false;
            }
        }

        NUMBER_INTEGER = x;
        type = Type.integer();
        isBool = false;
    }

    Expression(Float x) {
        int i;
        for (i = 0; i <= 5; i++) {
            if (i == 1) {
                tag[i] = true;
            } else {
                tag[i] = false;
            }
        }

        NUMBER_FLOAT = x;
        type = Type.floating_point();
        isBool = false;
    }

    Expression(String a, String x) {
        int i;
        for (i = 0; i <= 5; i++) {
            if (i == 2) {
                tag[i] = true;
            } else {
                tag[i] = false;
            }
        }

        TEXT_LITERAL = x;
        type = Type.string();
        isBool = false;
    }

    Expression(String x) {

        int i;

        for (i = 0; i <= 5; i++) {
            if (i == 3) {
                tag[i] = true;
            } else {
                tag[i] = false;
            }
        }

        //System.out.println("IN X constructor");
        if(Tables.envTable.get(x) != null){
            if (Tables.envTable.get(x).getType().isInteger()) {
                type = Type.integer();
                isBool = false;
                //System.out.println("ID test(integer): "+x+" "+type.isInteger());
            } else if (Tables.envTable.get(x).getType().isFloating_point()) {
                type = Type.floating_point();
                isBool = false;
            } else if (Tables.envTable.get(x).getType().isString()) {
                type = Type.string();
                isBool = false;
            } else if (Tables.envTable.get(x).getType().isBool()) {
                //System.out.println(x+" is boolean "+ Tables.envTable.get(x));
                type = Type.bool();
                isBool = true;
            } else {
                type = Type.errortype();
            }
        }
        else{
            System.out.println("ERROR!");
        }
        

        ID = x;
    }

    Expression(Arguments x, int op) {
        int i;
        for (i = 0; i <= 5; i++) {
            if (i == 4) {
                tag[i] = true;
            } else {
                tag[i] = false;
            }
        }

        //set type here
        if (op == sym.PLUS || op == sym.MINUS || op == sym.TIMES || op == sym.DIVIDE) {

            if (x.getsecond().getType().isFloating_point()) {
                type = Type.floating_point();
            } else if (x.getsecond().getType().isInteger()) {
                type = Type.integer();
            } else if (x.getsecond().getType().isString()) {
                type = Type.string();
            }

            isBool = false;
        } else if (op == sym.GT || op == sym.LT || op == sym.EQUAL || op == sym.GTE || op == sym.LTE || op == sym.NOTEQUAL || op == sym.OR || op == sym.AND) {
            type = Type.bool();
            isBool = true;
        } else {
            type = Type.errortype();
        }

        Operands = x;
        Operator = op;
    }

    Expression(Boolean mutex) {
        int i;
        for (i = 0; i <= 5; i++) {
            if (i == 5) {
                tag[i] = true;
            } else {
                tag[i] = false;
            }
        }

        type = Type.bool();
        this.BOL = mutex;
        //System.out.println("Mutex "+BOL);
        isBool = true;
    }

    public String getexp() {

        String s = "";
        if (tag[0]) {
            s = "" + NUMBER_INTEGER;
        } else if (tag[1]) {
            s = "" + NUMBER_FLOAT;
        } else if (tag[2]) {
            s = "" + TEXT_LITERAL;
        } else if (tag[3]) {
            s = ID;
        } else if (tag[4]) {
            if (Operator == sym.PLUS) {
                s = "PLUS(" + Operands.getfirst().getexp() + "," + Operands.getsecond().getexp() + ")";
            } else if (Operator == sym.MINUS) {
                s = "MINUS(" + Operands.getfirst().getexp() + "," + Operands.getsecond().getexp() + ")";
            }
            if (Operator == sym.TIMES) {
                s = "TIMES(" + Operands.getfirst().getexp() + "," + Operands.getsecond().getexp() + ")";
            }
            if (Operator == sym.DIVIDE) {
                s = "DIVIDE(" + Operands.getfirst().getexp() + "," + Operands.getsecond().getexp() + ")";
            }
        } else if (tag[5]) {
            s = "" + BOL;
        }
        return s;
    }

    //Evaluation of expressions
    public TypeValue getTypeValue() {
        TypeValue typeVal = null;
        if (tag[0]) //number integer
        {
            typeVal = new TypeValue(NUMBER_INTEGER);
        } else if (tag[1]) //number float
        {
            typeVal = new TypeValue(NUMBER_FLOAT);
        } else if (tag[2]) //String
        {
            typeVal = new TypeValue(TEXT_LITERAL);
        } else if (tag[3]) //identifier
        {
            if (isBool) {
                typeVal = Tables.envTable.get(ID);
            } else {
                typeVal = Tables.envTable.get(ID);
            }
        } else if (tag[4])//operation on two expressions fi and si
        {
            /*
             * Typecasts will throw a exception from java itself, when there
             * is a type error in the language
             */
            if (Operator == sym.PLUS) {

                if (Operands.getfirst().getType().isInteger()) {
                    int val = (Integer) Operands.getfirst().getTypeValue().getValue() + (Integer) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                } else if (Operands.getfirst().getType().isFloating_point()) {
                    float val = (Float) Operands.getfirst().getTypeValue().getValue() + (Float) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                }
            } else if (Operator == sym.MINUS) {
                if (Operands.getfirst().getType().isInteger()) {
                    int val = (Integer) Operands.getfirst().getTypeValue().getValue() - (Integer) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                } else if (Operands.getfirst().getType().isFloating_point()) {
                    float val = (Float) Operands.getfirst().getTypeValue().getValue() - (Float) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                }

            } else if (Operator == sym.TIMES) {
                if (Operands.getfirst().getType().isInteger()) {
                    int val = (Integer) Operands.getfirst().getTypeValue().getValue() * (Integer) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                } else if (Operands.getfirst().getType().isFloating_point()) {
                    float val = (Float) Operands.getfirst().getTypeValue().getValue() * (Float) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                }
            } else if (Operator == sym.DIVIDE) {

                if (Operands.getfirst().getType().isInteger()) {
                    int val = (Integer) Operands.getfirst().getTypeValue().getValue() / (Integer) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);

                } else if (Operands.getfirst().getType().isFloating_point()) {
                    float val = (Float) Operands.getfirst().getTypeValue().getValue() / (Float) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                }
            } else if (Operator == sym.GT) {

                if (Operands.getfirst().getType().isInteger()) {
                    boolean val = (Integer) Operands.getfirst().getTypeValue().getValue() > (Integer) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);

                } else if (Operands.getfirst().getType().isFloating_point()) {
                    boolean val = (Float) Operands.getfirst().getTypeValue().getValue() > (Float) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                }
            } else if (Operator == sym.LT) {
                if (Operands.getfirst().getType().isInteger()) {
                    boolean val = (Integer) Operands.getfirst().getTypeValue().getValue() < (Integer) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);

                } else if (Operands.getfirst().getType().isFloating_point()) {
                    boolean val = (Float) Operands.getfirst().getTypeValue().getValue() < (Float) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                }
            } else if (Operator == sym.GTE) {
                if (Operands.getfirst().getType().isInteger()) {
                    boolean val = (Integer) Operands.getfirst().getTypeValue().getValue() >= (Integer) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);

                } else if (Operands.getfirst().getType().isFloating_point()) {
                    boolean val = (Float) Operands.getfirst().getTypeValue().getValue() >= (Float) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                }
            } else if (Operator == sym.LTE) {
                if (Operands.getfirst().getType().isInteger()) {
                    boolean val = (Integer) Operands.getfirst().getTypeValue().getValue() <= (Integer) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);

                } else if (Operands.getfirst().getType().isFloating_point()) {
                    boolean val = (Float) Operands.getfirst().getTypeValue().getValue() <= (Float) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                }
            } else if (Operator == sym.EQUAL) {
                if (Operands.getfirst().getType().isInteger()) {
                    boolean val = (Integer) Operands.getfirst().getTypeValue().getValue() == (Integer) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);

                } else if (Operands.getfirst().getType().isFloating_point()) {
                    boolean val = (Float) Operands.getfirst().getTypeValue().getValue() == (Float) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);

                } else if (Operands.getfirst().getType().isBool()) {
                    boolean val = (Boolean) Operands.getfirst().getTypeValue().getValue() == (Boolean) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                } else if (Operands.getfirst().getType().isString() && Operands.getsecond().getType().isString()) {
                    boolean val = (Boolean) Operands.getfirst().getTypeValue().getValue().equals(Operands.getsecond().getTypeValue().getValue());
                    typeVal = new TypeValue(val);
                }
            } else if (Operator == sym.NOTEQUAL) {
                if (Operands.getfirst().getType().isInteger()) {
                    boolean val = (Integer) Operands.getfirst().getTypeValue().getValue() != (Integer) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);

                } else if (Operands.getfirst().getType().isFloating_point()) {
                    boolean val = (Float) Operands.getfirst().getTypeValue().getValue() != (Float) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);

                } else if (Operands.getfirst().getType().isBool()) {
                    boolean val = (Boolean) Operands.getfirst().getTypeValue().getValue() != (Boolean) Operands.getsecond().getTypeValue().getValue();
                    typeVal = new TypeValue(val);
                } else if (Operands.getfirst().getType().isString() && Operands.getsecond().getType().isString()) {
                    boolean val = (Boolean) !Operands.getfirst().getTypeValue().getValue().equals(Operands.getsecond().getTypeValue().getValue());
                    typeVal = new TypeValue(val);
                }
            } else if (Operator == sym.OR) {
                boolean val = (Boolean) Operands.getfirst().getTypeValue().getValue() || (Boolean) Operands.getsecond().getTypeValue().getValue();
                typeVal = new TypeValue(val);
            } else if (Operator == sym.AND) {
                boolean val = (Boolean) Operands.getfirst().getTypeValue().getValue() && (Boolean) Operands.getsecond().getTypeValue().getValue();
                typeVal = new TypeValue(val);
            }

        }
        if (tag[5]) //for boolean expression (from constructor)
        {
            typeVal = new TypeValue(BOL);
        }
        return typeVal;
    }

    public Type getType() {
        return type;
    }

}
