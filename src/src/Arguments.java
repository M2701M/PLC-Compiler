package src;


public class Arguments {

    private Expression First, Second;
    Arguments(Expression x, Expression y){
        First = x;

        Second =y;
    }

    public Expression getfirst() {
        return First;
    }

    public Expression getsecond() {
        return Second;
    }
}
