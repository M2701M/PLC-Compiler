/* The following code was generated by JFlex 1.4_pre3 on 30/04/2022, 20:35 */


   
/* --------------------------Usercode Section------------------------ */
package src;
import java_cup.runtime.*;
      

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4_pre3
 * on 30/04/2022, 20:35 from the specification file
 * <tt>file:/C:/Users/mmueller43/AIT/voc_compiler/src/flex/voc_flex.flex</tt>
 */
class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int YY_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final char [] yycmap = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  3,  2,  0,  3,  1,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     9, 45,  0, 10, 10, 26, 42,  7, 27, 28, 24, 22, 21, 23,  4, 25, 
     5,  6,  6,  6,  6,  6,  6,  6,  6,  6,  0, 20, 43, 29, 44,  0, 
    10,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8, 
     8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  0,  0,  0, 10, 11, 
     0, 17, 39,  8, 32, 15, 16, 40, 35, 30,  8,  8, 18,  8, 31, 36, 
    33,  8, 13, 19, 12, 14, 46, 34,  8,  8,  8, 37, 41, 38,  0,  0
  };


  /** 
   * Translates a state to a row index in the transition table (packed version)
   */
  final private static String yy_rowMap_packed = 
    "\0\0\0\57\0\136\0\57\0\215\0\274\0\353\0\u011a\0\u0149\0\u0178"+
    "\0\u01a7\0\u01d6\0\u0205\0\u0234\0\57\0\57\0\57\0\57\0\57\0\57"+
    "\0\57\0\57\0\57\0\u0263\0\u0292\0\u02c1\0\u02f0\0\u031f\0\57\0\57"+
    "\0\u034e\0\u037d\0\u03ac\0\u03db\0\u040a\0\u0439\0\u0468\0\u0497\0\215\0\u04c6"+
    "\0\57\0\353\0\u04f5\0\u0524\0\u0553\0\u0582\0\u05b1\0\u05e0\0\u060f\0\u063e"+
    "\0\u066d\0\u069c\0\57\0\u011a\0\u06cb\0\u011a\0\u06fa\0\u0729\0\u0758\0\57"+
    "\0\57\0\57\0\57\0\57\0\u0787\0\u0497\0\u07b6\0\u07e5\0\u0814\0\u0843"+
    "\0\u0872\0\u08a1\0\u08d0\0\u011a\0\u08ff\0\u011a\0\u092e\0\u095d\0\u098c\0\u09bb"+
    "\0\u011a\0\u09ea\0\u0a19\0\u011a\0\u0a48\0\u0a77\0\u0aa6\0\u0ad5\0\u0b04\0\u0b33"+
    "\0\u011a\0\u0b62\0\u011a\0\u011a\0\u011a\0\u0b91\0\u011a\0\u011a\0\u0bc0\0\u011a"+
    "\0\u011a\0\u0bef\0\u011a";

  /** 
   * Translates a state to a row index in the transition table
   */
  final private static int [] yy_rowMap = yy_unpack_rowMap(yy_rowMap_packed);


  /** 
   * Unpacks the compressed row translation table.
   *
   * @param packed   the packed row translation table
   * @return         the unpacked row translation table
   */
  private static int [] yy_unpack_rowMap(String packed) {
    int [] map = new int[206];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 206) {
      int high = ((int) packed.charAt(i++)) << 16;
      map[j++] = high | packed.charAt(i++);
    }
    return map;
  }
  /** 
   * The packed transition table of the DFA (part 0)
   */
  private static final String yy_packed0 = 
    "\1\2\1\3\2\4\1\2\1\5\1\6\1\7\1\10"+
    "\1\4\1\2\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\2\10\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\10\1\32\1\33"+
    "\1\34\2\10\1\35\1\36\1\37\1\10\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\61\0\1\4\60\0\1\46"+
    "\2\47\54\0\1\46\2\6\55\0\2\50\1\51\2\52"+
    "\1\53\1\0\10\52\4\0\1\53\1\0\3\53\1\0"+
    "\7\52\2\0\2\52\2\53\2\0\1\53\1\52\5\0"+
    "\2\10\1\0\1\10\2\0\11\10\12\0\7\10\2\0"+
    "\2\10\5\0\1\10\5\0\2\10\1\0\1\10\2\0"+
    "\2\10\1\54\6\10\12\0\7\10\2\0\2\10\5\0"+
    "\1\10\5\0\2\10\1\0\1\10\2\0\4\10\1\55"+
    "\4\10\12\0\7\10\2\0\2\10\5\0\1\10\5\0"+
    "\2\10\1\0\1\10\2\0\11\10\12\0\1\10\1\56"+
    "\5\10\2\0\2\10\5\0\1\10\5\0\2\10\1\0"+
    "\1\10\2\0\7\10\1\57\1\10\12\0\1\10\1\60"+
    "\5\10\2\0\2\10\5\0\1\10\5\0\2\10\1\0"+
    "\1\10\2\0\6\10\1\61\1\62\1\10\12\0\6\10"+
    "\1\63\2\0\2\10\5\0\1\10\5\0\2\10\1\0"+
    "\1\10\2\0\1\10\1\64\7\10\12\0\7\10\2\0"+
    "\2\10\5\0\1\10\35\0\1\65\26\0\2\10\1\0"+
    "\1\10\2\0\5\10\1\66\3\10\12\0\1\10\1\67"+
    "\5\10\2\0\2\10\5\0\1\10\5\0\2\10\1\0"+
    "\1\10\2\0\11\10\12\0\6\10\1\70\2\0\2\10"+
    "\5\0\1\10\5\0\2\10\1\0\1\10\2\0\2\10"+
    "\1\71\6\10\12\0\7\10\2\0\2\10\5\0\1\10"+
    "\5\0\2\10\1\0\1\10\2\0\11\10\12\0\5\10"+
    "\1\72\1\10\2\0\2\10\5\0\1\10\5\0\2\10"+
    "\1\0\1\10\2\0\11\10\12\0\6\10\1\73\2\0"+
    "\2\10\5\0\1\10\51\0\1\74\57\0\1\75\41\0"+
    "\1\76\56\0\1\77\56\0\1\100\26\0\2\10\1\0"+
    "\1\10\2\0\11\10\12\0\6\10\1\101\2\0\2\10"+
    "\5\0\1\10\5\0\2\102\55\0\2\50\1\51\54\0"+
    "\2\50\1\51\2\0\1\53\15\0\1\53\1\0\3\53"+
    "\14\0\2\53\2\0\1\53\6\0\2\10\1\0\1\10"+
    "\2\0\3\10\1\103\5\10\12\0\7\10\2\0\2\10"+
    "\5\0\1\10\5\0\2\10\1\0\1\10\2\0\1\10"+
    "\1\104\7\10\12\0\7\10\2\0\2\10\5\0\1\10"+
    "\5\0\2\10\1\0\1\10\2\0\1\10\1\105\7\10"+
    "\12\0\7\10\2\0\2\10\5\0\1\10\5\0\2\10"+
    "\1\0\1\10\2\0\10\10\1\106\12\0\7\10\2\0"+
    "\2\10\5\0\1\10\5\0\2\10\1\0\1\10\2\0"+
    "\11\10\12\0\2\10\1\107\4\10\2\0\2\10\5\0"+
    "\1\10\5\0\2\10\1\0\1\10\2\0\7\10\1\110"+
    "\1\10\12\0\7\10\2\0\2\10\5\0\1\10\5\0"+
    "\2\10\1\0\1\10\2\0\11\10\12\0\6\10\1\111"+
    "\2\0\2\10\5\0\1\10\5\0\2\10\1\0\1\10"+
    "\2\0\2\10\1\112\6\10\12\0\7\10\2\0\2\10"+
    "\5\0\1\10\5\0\2\10\1\0\1\10\2\0\2\10"+
    "\1\113\6\10\12\0\7\10\2\0\2\10\5\0\1\10"+
    "\5\0\2\10\1\0\1\10\2\0\1\10\1\114\7\10"+
    "\12\0\7\10\2\0\2\10\5\0\1\10\5\0\2\10"+
    "\1\0\1\10\2\0\11\10\12\0\1\115\6\10\2\0"+
    "\2\10\5\0\1\10\5\0\2\10\1\0\1\10\2\0"+
    "\11\10\12\0\1\116\6\10\2\0\2\10\5\0\1\10"+
    "\5\0\2\10\1\0\1\10\2\0\11\10\12\0\6\10"+
    "\1\117\2\0\2\10\5\0\1\10\5\0\2\10\1\0"+
    "\1\10\2\0\11\10\12\0\1\120\6\10\2\0\2\10"+
    "\5\0\1\10\5\0\2\10\1\0\1\10\2\0\4\10"+
    "\1\121\4\10\12\0\7\10\2\0\2\10\5\0\1\10"+
    "\5\0\2\10\1\0\1\10\2\0\3\10\1\122\5\10"+
    "\12\0\7\10\2\0\2\10\5\0\1\10\5\0\2\10"+
    "\1\0\1\10\2\0\11\10\12\0\1\123\6\10\2\0"+
    "\2\10\5\0\1\10\5\0\2\10\1\0\1\10\2\0"+
    "\4\10\1\124\4\10\12\0\7\10\2\0\2\10\5\0"+
    "\1\10\5\0\2\10\1\0\1\10\2\0\11\10\12\0"+
    "\1\125\6\10\2\0\2\10\5\0\1\10\5\0\2\10"+
    "\1\0\1\10\2\0\10\10\1\103\12\0\7\10\2\0"+
    "\2\10\5\0\1\10\5\0\2\10\1\0\1\10\2\0"+
    "\6\10\1\126\2\10\12\0\7\10\2\0\2\10\5\0"+
    "\1\10\5\0\2\10\1\0\1\10\2\0\11\10\12\0"+
    "\1\127\6\10\2\0\2\10\5\0\1\10\5\0\2\10"+
    "\1\0\1\10\2\0\11\10\12\0\1\10\1\130\5\10"+
    "\2\0\2\10\5\0\1\10\5\0\2\10\1\0\1\10"+
    "\2\0\7\10\1\131\1\10\12\0\7\10\2\0\2\10"+
    "\5\0\1\10\5\0\2\10\1\0\1\10\2\0\7\10"+
    "\1\132\1\10\12\0\7\10\2\0\2\10\5\0\1\10"+
    "\5\0\2\10\1\0\1\10\2\0\11\10\12\0\2\10"+
    "\1\133\4\10\2\0\2\10\5\0\1\10\5\0\2\10"+
    "\1\0\1\10\2\0\2\10\1\134\6\10\12\0\7\10"+
    "\2\0\2\10\5\0\1\10\5\0\2\10\1\0\1\10"+
    "\2\0\7\10\1\135\1\10\12\0\7\10\2\0\2\10"+
    "\5\0\1\10\5\0\2\10\1\0\1\10\2\0\5\10"+
    "\1\136\3\10\12\0\7\10\2\0\2\10\5\0\1\10"+
    "\5\0\2\10\1\0\1\10\2\0\1\10\1\137\7\10"+
    "\12\0\7\10\2\0\2\10\5\0\1\10\5\0\2\10"+
    "\1\0\1\10\2\0\11\10\12\0\1\10\1\140\5\10"+
    "\2\0\2\10\5\0\1\10\5\0\2\10\1\0\1\10"+
    "\2\0\1\10\1\141\7\10\12\0\7\10\2\0\2\10"+
    "\5\0\1\10\5\0\2\10\1\0\1\10\2\0\4\10"+
    "\1\142\4\10\12\0\7\10\2\0\2\10\5\0\1\10"+
    "\5\0\2\10\1\0\1\10\2\0\4\10\1\143\4\10"+
    "\12\0\7\10\2\0\2\10\5\0\1\10\5\0\2\10"+
    "\1\0\1\10\2\0\11\10\12\0\1\10\1\144\5\10"+
    "\2\0\2\10\5\0\1\10\5\0\2\10\1\0\1\10"+
    "\2\0\11\10\12\0\7\10\2\0\1\10\1\145\5\0"+
    "\1\10\5\0\2\10\1\0\1\10\2\0\6\10\1\146"+
    "\2\10\12\0\7\10\2\0\2\10\5\0\1\10\5\0"+
    "\2\10\1\0\1\10\2\0\11\10\12\0\1\10\1\147"+
    "\5\10\2\0\2\10\5\0\1\10";

  /** 
   * The transition table of the DFA
   */
  private static final int yytrans [] = yy_unpack();


  /* error codes */
  private static final int YY_UNKNOWN_ERROR = 0;
  private static final int YY_ILLEGAL_STATE = 1;
  private static final int YY_NO_MATCH = 2;
  private static final int YY_PUSHBACK_2BIG = 3;

  /* error messages for the codes above */
  private static final String YY_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Internal error: unknown state",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * YY_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final byte YY_ATTRIBUTE[] = {
     0,  9,  1,  9,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  9,  9, 
     9,  9,  9,  9,  9,  9,  9,  1,  1,  1,  1,  1,  9,  9,  1,  1, 
     1,  1,  1,  1,  1,  0,  0,  0,  9,  0,  0,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  9,  1,  1,  1,  1,  1,  1,  9,  9,  9,  9,  9, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1
  };

  /** the input device */
  private java.io.Reader yy_reader;

  /** the current state of the DFA */
  private int yy_state;

  /** the current lexical state */
  private int yy_lexical_state = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char yy_buffer[] = new char[YY_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int yy_markedPos;

  /** the textposition at the last state to be included in yytext */
  private int yy_pushbackPos;

  /** the current text position in the buffer */
  private int yy_currentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int yy_startRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int yy_endRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn; 

  /** 
   * yy_atBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean yy_atBOL = true;

  /** yy_atEOF == true <=> the scanner is at the EOF */
  private boolean yy_atEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean yy_eof_done;

  /* user code: */
    /* To create a new java_cup.runtime.Symbol with information about
       the current token, the token will have no value in this
       case. */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    /* Also creates a new java_cup.runtime.Symbol with information
       about the current token, but this object has a value. */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.yy_reader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the split, compressed DFA transition table.
   *
   * @return the unpacked transition table
   */
  private static int [] yy_unpack() {
    int [] trans = new int[3102];
    int offset = 0;
    offset = yy_unpack(yy_packed0, offset, trans);
    return trans;
  }

  /** 
   * Unpacks the compressed DFA transition table.
   *
   * @param packed   the packed transition table
   * @return         the index of the last entry
   */
  private static int yy_unpack(String packed, int offset, int [] trans) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do trans[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   IOException  if any I/O-Error occurs
   */
  private boolean yy_refill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (yy_startRead > 0) {
      System.arraycopy(yy_buffer, yy_startRead, 
                       yy_buffer, 0, 
                       yy_endRead-yy_startRead);

      /* translate stored positions */
      yy_endRead-= yy_startRead;
      yy_currentPos-= yy_startRead;
      yy_markedPos-= yy_startRead;
      yy_pushbackPos-= yy_startRead;
      yy_startRead = 0;
    }

    /* is the buffer big enough? */
    if (yy_currentPos >= yy_buffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[yy_currentPos*2];
      System.arraycopy(yy_buffer, 0, newBuffer, 0, yy_buffer.length);
      yy_buffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = yy_reader.read(yy_buffer, yy_endRead, 
                                            yy_buffer.length-yy_endRead);

    if (numRead < 0) {
      return true;
    }
    else {
      yy_endRead+= numRead;  
      return false;
    }
  }


  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    yy_atEOF = true;            /* indicate end of file */
    yy_endRead = yy_startRead;  /* invalidate buffer    */

    if (yy_reader != null)
      yy_reader.close();
  }


  /**
   * Closes the current stream, and resets the
   * scanner to read from a new input stream.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>YY_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) throws java.io.IOException {
    yyclose();
    yy_reader = reader;
    yy_atBOL  = true;
    yy_atEOF  = false;
    yy_endRead = yy_startRead = 0;
    yy_currentPos = yy_markedPos = yy_pushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    yy_lexical_state = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return yy_lexical_state;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    yy_lexical_state = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( yy_buffer, yy_startRead, yy_markedPos-yy_startRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return yy_buffer[yy_startRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return yy_markedPos-yy_startRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void yy_ScanError(int errorCode) {
    String message;
    try {
      message = YY_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = YY_ERROR_MSG[YY_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  private void yypushback(int number)  {
    if ( number > yylength() )
      yy_ScanError(YY_PUSHBACK_2BIG);

    yy_markedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void yy_do_eof() throws java.io.IOException {
    if (!yy_eof_done) {
      yy_eof_done = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int yy_input;
    int yy_action;

    // cached fields:
    int yy_currentPos_l;
    int yy_startRead_l;
    int yy_markedPos_l;
    int yy_endRead_l = yy_endRead;
    char [] yy_buffer_l = yy_buffer;
    char [] yycmap_l = yycmap;

    int [] yytrans_l = yytrans;
    int [] yy_rowMap_l = yy_rowMap;
    byte [] yy_attr_l = YY_ATTRIBUTE;

    while (true) {
      yy_markedPos_l = yy_markedPos;

      boolean yy_r = false;
      for (yy_currentPos_l = yy_startRead; yy_currentPos_l < yy_markedPos_l;
                                                             yy_currentPos_l++) {
        switch (yy_buffer_l[yy_currentPos_l]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          yy_r = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          yy_r = true;
          break;
        case '\n':
          if (yy_r)
            yy_r = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          yy_r = false;
          yycolumn++;
        }
      }

      if (yy_r) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean yy_peek;
        if (yy_markedPos_l < yy_endRead_l)
          yy_peek = yy_buffer_l[yy_markedPos_l] == '\n';
        else if (yy_atEOF)
          yy_peek = false;
        else {
          boolean eof = yy_refill();
          yy_markedPos_l = yy_markedPos;
          yy_buffer_l = yy_buffer;
          if (eof) 
            yy_peek = false;
          else 
            yy_peek = yy_buffer_l[yy_markedPos_l] == '\n';
        }
        if (yy_peek) yyline--;
      }
      yy_action = -1;

      yy_startRead_l = yy_currentPos_l = yy_currentPos = 
                       yy_startRead = yy_markedPos_l;

      yy_state = yy_lexical_state;


      yy_forAction: {
        while (true) {

          if (yy_currentPos_l < yy_endRead_l)
            yy_input = yy_buffer_l[yy_currentPos_l++];
          else if (yy_atEOF) {
            yy_input = YYEOF;
            break yy_forAction;
          }
          else {
            // store back cached positions
            yy_currentPos  = yy_currentPos_l;
            yy_markedPos   = yy_markedPos_l;
            boolean eof = yy_refill();
            // get translated positions and possibly new buffer
            yy_currentPos_l  = yy_currentPos;
            yy_markedPos_l   = yy_markedPos;
            yy_buffer_l      = yy_buffer;
            yy_endRead_l     = yy_endRead;
            if (eof) {
              yy_input = YYEOF;
              break yy_forAction;
            }
            else {
              yy_input = yy_buffer_l[yy_currentPos_l++];
            }
          }
          int yy_next = yytrans_l[ yy_rowMap_l[yy_state] + yycmap_l[yy_input] ];
          if (yy_next == -1) break yy_forAction;
          yy_state = yy_next;

          int yy_attributes = yy_attr_l[yy_state];
          if ( (yy_attributes & 1) == 1 ) {
            yy_action = yy_state; 
            yy_markedPos_l = yy_currentPos_l; 
            if ( (yy_attributes & 8) == 8 ) break yy_forAction;
          }

        }
      }

      // store back cached position
      yy_markedPos = yy_markedPos_l;

      switch (yy_action) {

        case 4: 
        case 5: 
          { return symbol(sym.INTEGER_LITERAL, new Integer(yytext())); }
        case 104: break;
        case 65: 
          { return symbol(sym.FLOAT_LITERAL, new Float(yytext())); }
        case 105: break;
        case 22: 
          {  return symbol(sym.RPAREN);  }
        case 106: break;
        case 21: 
          {  return symbol(sym.LPAREN);  }
        case 107: break;
        case 19: 
          {  return symbol(sym.DIVIDE);  }
        case 108: break;
        case 63: 
          {  return symbol (sym.NOTEQUAL); }
        case 109: break;
        case 100: 
          {  return symbol (sym.STRING); }
        case 110: break;
        case 99: 
          {  return symbol  (sym.RETURN); }
        case 111: break;
        case 2: 
        case 3: 
          {  /* just skip what was found, do nothing */  }
        case 112: break;
        case 83: 
          { return symbol(sym.ELSE);   }
        case 113: break;
        case 33: 
          {  return symbol (sym.LT); }
        case 114: break;
        case 29: 
          {  return symbol(sym.END);  }
        case 115: break;
        case 23: 
          {  return symbol(sym.EQ);  }
        case 116: break;
        case 20: 
          {  return symbol(sym.MOD);  }
        case 117: break;
        case 34: 
          {  return symbol (sym.GT); }
        case 118: break;
        case 53: 
          {  return symbol(sym.IF);  }
        case 119: break;
        case 55: 
          {  return symbol(sym.DO);  }
        case 120: break;
        case 59: 
          {  return symbol (sym.OR); }
        case 121: break;
        case 60: 
          {  return symbol (sym.AND); }
        case 122: break;
        case 61: 
          {  return symbol (sym.LTE); }
        case 123: break;
        case 62: 
          {  return symbol (sym.GTE); }
        case 124: break;
        case 73: 
          {  return symbol(sym.FOR);  }
        case 125: break;
        case 75: 
          {  return symbol (sym.INT); }
        case 126: break;
        case 102: 
          {  return symbol (sym.BOOL); }
        case 127: break;
        case 97: 
          {  return symbol(sym.WHILE);  }
        case 128: break;
        case 96: 
          {  return symbol(sym.PRINT);  }
        case 129: break;
        case 94: 
          {  return symbol (sym.FLOAT); }
        case 130: break;
        case 28: 
          {  return symbol(sym.BEGIN);  }
        case 131: break;
        case 18: 
          {  return symbol(sym.TIMES);  }
        case 132: break;
        case 14: 
          {  return symbol(sym.SEMI);  }
        case 133: break;
        case 15: 
          {  return symbol(sym.COMMA);  }
        case 134: break;
        case 16: 
          {  return symbol(sym.PLUS);  }
        case 135: break;
        case 17: 
          {  return symbol(sym.MINUS);  }
        case 136: break;
        case 52: 
          {  return symbol (sym.EQUAL); }
        case 137: break;
        case 90: 
          {  return symbol  (sym.VOID); }
        case 138: break;
        case 92: 
          {  return symbol(sym.UNTIL);  }
        case 139: break;
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 24: 
        case 25: 
        case 26: 
        case 27: 
        case 30: 
        case 36: 
        case 43: 
        case 44: 
        case 45: 
        case 46: 
        case 47: 
        case 48: 
        case 49: 
        case 50: 
        case 51: 
        case 54: 
        case 56: 
        case 57: 
        case 58: 
        case 64: 
        case 66: 
        case 67: 
        case 68: 
        case 69: 
        case 70: 
        case 71: 
        case 72: 
        case 74: 
        case 76: 
        case 77: 
        case 78: 
        case 79: 
        case 81: 
        case 82: 
        case 84: 
        case 85: 
        case 86: 
        case 87: 
        case 88: 
        case 89: 
        case 91: 
        case 95: 
        case 98: 
        case 101: 
          { 
                        Integer n = (Integer) SymbolTable.globalTable.get(yytext());

                        if (n == null) {
                               SymbolTable.globalTable.put(yytext(),0);
                        }
                        return symbol(sym.ID, yytext());
                        }
        case 140: break;
        case 1: 
        case 6: 
        case 31: 
        case 32: 
        case 35: 
          {  throw new Error("Illegal character <"+yytext()+">");  }
        case 141: break;
        case 40: 
          { return symbol(sym.STRING_LITERAL,new String (yytext().substring(1,yylength()-1))); }
        case 142: break;
        case 80: 
          { return symbol(sym.BOL,new Boolean(yytext())); }
        case 143: break;
        case 93: 
          { return symbol(sym.ENDIF); }
        case 144: break;
        default: 
          if (yy_input == YYEOF && yy_startRead == yy_currentPos) {
            yy_atEOF = true;
            yy_do_eof();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            yy_ScanError(YY_NO_MATCH);
          }
      }
    }
  }


}