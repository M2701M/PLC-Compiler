
   
/* --------------------------Usercode Section------------------------ */
package src;
import java_cup.runtime.*;
      
%%
   
/* -----------------Options and Declarations Section----------------- */
   
%class Lexer

%line
%column
    
%cup
   
%{   
    
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
   
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
   

LineTerminator = \r|\n|\r\n
   

WhiteSpace     = {LineTerminator} | [ \t\f]
   

/*int      = 0 | [1-9][0-9]*
float    = [0-9][0-9]*.[0-9][0-9]*
*/

dot = "."
int = 0 | [1-9][0-9]*
float = [0-9]+{dot}[0-9]+

string   = \'{alphabet}{specials}{digit}\'
digit    = [0-9]*
alphabet = [a-zA-Z ]*
specials = [!|@|#|$|%|\^|&|*|(|)]*
   
ID = [A-Za-z_][A-Za-z_0-9]*

boolean = true|false


%%

   
<YYINITIAL> {
   
    /* Return the token SEMI declared in the class sym that was found. */
    ";"                { return symbol(sym.SEMI); }
    ","                { return symbol(sym.COMMA); }
   
    /* Print the token found that was declared in the class sym and then
       return it. */
    "+"                { return symbol(sym.PLUS); }
    "-"                { return symbol(sym.MINUS); }
    "*"                { return symbol(sym.TIMES); }
    "/"                { return symbol(sym.DIVIDE); }

    "("                { return symbol(sym.LPAREN); }
    ")"                { return symbol(sym.RPAREN); }
    "="                { return symbol(sym.EQ); }
    "if"               { return symbol(sym.IF); }
    "then"             { return symbol(sym.THEN); }
    "else"             {return symbol(sym.ELSE);  }
    "endif"            {return symbol(sym.ENDIF);}
    "print"            { return symbol(sym.PRINT); }
    "while"            { return symbol(sym.WHILE); }
    "{"                { return symbol(sym.BEGIN); }
    "}"                { return symbol(sym.END); }
    "boolean"          { return symbol (sym.BOOL);}
    "int"              { return symbol (sym.INT);}
    "float"            { return symbol (sym.FLOAT);}
    "string"           { return symbol (sym.STRING);}

    "||"               { return symbol (sym.OR);}
    "&&"               { return symbol (sym.AND);}

    "<"                { return symbol (sym.LT);}
    ">"                { return symbol (sym.GT);}

    ">="               { return symbol (sym.GTE);}
    "<="               { return symbol (sym.LTE);}
    "=="               { return symbol (sym.EQUAL);}
    "!="               { return symbol (sym.NOTEQUAL);}
    "void"             { return symbol  (sym.VOID);}
    "return"           { return symbol  (sym.RETURN);}
    "func"             { return symbol  (sym.FUNC);}
    ":"                { return symbol  (sym.COLON);}


    {int}             {return symbol(sym.INTEGER_LITERAL, new Integer(yytext()));}
    {float}           {return symbol(sym.FLOAT_LITERAL, new Float(yytext()));}
    {boolean}         {return symbol(sym.BOL,new Boolean(yytext()));}
    {string}          {return symbol(sym.STRING_LITERAL,new String (yytext().substring(1,yylength()-1)));}

    {ID}       {
                        Integer n = (Integer) Tables.globalTable.get(yytext());

                        if (n == null) {
                               Tables.globalTable.put(yytext(),0);
                        }
                        return symbol(sym.ID, yytext());
                       }

        
    {WhiteSpace}       { /* just skip what was found, do nothing */ }   
}

[^]                    { throw new Error("Illegal character <"+yytext()+">"); }
